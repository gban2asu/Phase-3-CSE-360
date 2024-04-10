package Phase3;

import java.io.*;
import java.util.Scanner;

public class Database {

    // Check if patient information file exists
    public static boolean patientExists(int patientId) {
        File patientInfoFile = new File(patientId + "_PatientInfo.txt");
        return patientInfoFile.exists();
    }

    // Retrieve patient's name by ID
    public static String getPatientName(int patientId) {
        String patientInfoFileName = patientId + "_PatientInfo.txt";
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
    public static void savePatientVitals(int patientId, String... vitals) {
        String vitalsFileName = patientId + "_Vitals.txt";
        try (PrintWriter out = new PrintWriter(new FileWriter(vitalsFileName, true))) {
            for (String vital : vitals) {
                out.println(vital);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Load patient history, contacts, or insurance information
    public static String loadPatientInfo(int patientId, String infoType) {
        String fileName = patientId + "_" + infoType + ".txt";
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
}
