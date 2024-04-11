package Phase3;

import java.io.*;
import java.util.Scanner;

public class database {

    // Check if patient information file exists
    public static boolean patientExists(String username) {
        File patientInfoFile = new File(username + "_PatientInfo.txt");
        return patientInfoFile.exists();
    }

    // Retrieve patient's name by username
    public static String getPatientName(String username) {
        String patientInfoFileName = username + "_PatientInfo.txt";
        File patientInfoFile = new File(patientInfoFileName);
        if (patientInfoFile.exists()) {
            try (Scanner scanner = new Scanner(patientInfoFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("First Name:")) {
                        String firstName = line.split(":")[1].trim();
                        if(scanner.hasNextLine()){ // Ensure there is a next line for last name
                            String lastName = scanner.nextLine().split(":")[1].trim(); // Assuming last name follows first name
                            return firstName + " " + lastName;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
        }
        return "Unknown"; // Default if not found or error
    }

    // Save patient vitals to a file
    public static void savePatientVitals(String username, String... vitals) {
        String vitalsFileName = username + "_Vitals.txt";
        try (PrintWriter out = new PrintWriter(new FileWriter(vitalsFileName, true))) {
            for (String vital : vitals) {
                out.println(vital);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Load patient history, contacts, or insurance information
    public static String loadPatientInfo(String username, String infoType) {
        String fileName = username + "_" + infoType + ".txt";
        StringBuilder info = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                info.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return "No information found";
        }
        return info.toString().trim();
    }

    // Save user credentials and type
    public static void saveUserCredentials(String username, String password, String userType) {
        String credentialsFileName = username + "_Credentials.txt";
        try (PrintWriter out = new PrintWriter(new FileWriter(credentialsFileName))) {
            out.println("Username:" + username);
            out.println("Password:" + password);
            out.println("UserType:" + userType);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Verify user credentials
    public static boolean verifyUserCredentials(String username, String password) {
        String credentialsFileName = username + "_Credentials.txt";
        File credentialsFile = new File(credentialsFileName);
        if (credentialsFile.exists()) {
            try (Scanner scanner = new Scanner(credentialsFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("Username:") && line.split(":")[1].trim().equals(username)) {
                        if (scanner.hasNextLine() && scanner.nextLine().split(":")[1].trim().equals(password)) {
                            return true; // Username and password match
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
        }
        return false; // Default if not found or credentials do not match
    }

    // Get user type
    public String getUserType(String username) {
        String credentialsFileName = username + "_Credentials.txt";
        File credentialsFile = new File(credentialsFileName);
        if (credentialsFile.exists()) {
            try (Scanner scanner = new Scanner(credentialsFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("UserType:")) {
                        return line.split(":")[1].trim();
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
        }
        return "Unknown"; // Default if not found or error
    }
}
