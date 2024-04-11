package Phase3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class patientView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Patient Dashboard");

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.setAlignment(Pos.TOP_CENTER);
        

        TabPane tabs = new TabPane();
        Tab contactTab = new Tab("Contact Info", createcontact());
        Tab historyTab = new Tab("View History", createpatienthistory());
        Tab insuranceTab = new Tab("Insurance", createinsurance());
        Tab messageTab = new Tab("Message", openmessage());
        tabs.getTabs().addAll(contactTab, historyTab, insuranceTab,  messageTab);
        mainLayout.getChildren().add(tabs);

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    private GridPane createcontact() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        
        grid.add(new Label("Phone Number"), 0, 0);
        TextField numberField = new TextField();
        numberField.setPromptText("Enter Phone Number");
        grid.add(numberField, 1, 0);
        
        grid.add(new Label("Email:"), 0, 1);
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");
        grid.add(emailField, 1, 1);

        
        Button saveButton = new Button("Save Contact Info");
        saveButton.setOnAction(e -> {
        	String number = numberField.getText();
        	String email = emailField.getText();
        });
        grid.add(saveButton, 1, 2);

        return grid;
    }
    
    
    private VBox createpatienthistory() {
        VBox vbox = new VBox(10);

        TextArea phistoryArea = new TextArea();
        phistoryArea.setPromptText("Enter patient's medical history");
        vbox.getChildren().add(phistoryArea);
        
        Button saveButton1 = new Button("Save");
        saveButton1.setOnAction(e-> {
        	String history = phistoryArea.getText();
        });
        
        vbox.getChildren().add(saveButton1);

        return vbox;
    }
    
    private GridPane createinsurance() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        
        grid.add(new Label("Plan:"), 0, 0);
        TextField planField = new TextField();
        planField.setPromptText("Enter Your Plan");
        grid.add(planField, 1, 0);
        
        grid.add(new Label("Insurance ID"), 0, 1);
        TextField idField = new TextField();
        idField.setPromptText("Enter Insurance ID");
        grid.add(idField, 1, 1);
        
        Button saveButton = new Button("Save Contact Info");
        saveButton.setOnAction(e -> {
        	String number = planField.getText();
        	String email = idField.getText();
        });
        grid.add(saveButton, 1, 2);

        return grid;
    }
    
    private VBox openmessage()
    {
    	VBox vbox = new VBox(10);
    	return vbox;
    }
    
    
    
    

    public static void main(String[] args) {
        launch(args);
    }
}
