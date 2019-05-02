package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane mainLayout;
	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Newton's Law Stimulator App");
		Image icon = new Image(getClass().getResourceAsStream("asset/newton.jpg"));
		primaryStage.getIcons().add(icon);
		
		showView();
	}
	
	private void showView() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/View.fxml"));
		
		try {
			mainLayout = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
