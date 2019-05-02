package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.Force;
import application.model.Objects;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Controller {
	Objects obj = new Objects();
	Force force = new Force();
	float acceleration = 0;
	TranslateTransition transition = new TranslateTransition();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField massInput;

    @FXML
    private Button runButton;

    @FXML
    private TextField forceInput;

    @FXML
    private TextField aOutput;
   
    @FXML
    private Button resetButton;
    
    @FXML
    private ImageView car;
    
    @FXML
    void initialize() {
    	
    	runButton.setOnAction(event ->{
    		try {
    		obj.setMass(Float.parseFloat(massInput.getText()));
        	force.setScalar(Float.parseFloat(forceInput.getText()));
    		}catch(Exception e) {
    			System.out.println("Error: You must input the value properly !!!");
    		}
    		
        	if(obj.getMass()>0&&force.getScalar()>0) {
    			acceleration = force.getScalar()/obj.getMass();
    			aOutput.setText(Float.toString(acceleration)+" m/s^2");
    		}
        	
        	car.setLayoutX(0);
        	car.setLayoutY(6);
        	
        	transition.setToX(850);
        	transition.setToY(6);
        	float j = acceleration;
        	transition.setRate(j);
         	
        	transition.setInterpolator(Interpolator.LINEAR);
        	transition.setNode(car);
        	transition.play();
        	
    	});
    	
    	resetButton.setOnAction(event ->{
    		obj.setMass(0);
    		force.setScalar(0);
    		acceleration = 0;
    		massInput.setText("");
    		forceInput.setText("");
    		aOutput.setText("");
    		
    		transition.setToX(0);
    		transition.setToY(6);
    		transition.setRate(4);
    		transition.play();
    	});
    }
}
