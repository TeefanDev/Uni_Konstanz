package perceptron;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GUI extends Application
{
	Perceptron perceptron;
	DataLoader dataLoader;
	Stage primaryStage;
	
	public void begin()
	{
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception
	{
		FlowPane root = new FlowPane();
		Button clickMe = new Button("Click Me!");
		root.getChildren().add(clickMe);
		Scene scene = new Scene(root, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	//JFrame meinFrame = new JFrame("Perceptron");
}
