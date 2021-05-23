package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class BobSpongeController {
	@FXML
	private BorderPane basePane;
	private Stage stage;
	
	public BobSpongeController(Stage s) throws IOException {
		stage=s;
	}
	public void initialize() {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				System.out.println("Closing the window!");
			}
		});
	}
	public void loadPlayGame(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("PlayGame.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	void playGame(ActionEvent event) {
		loadMap();
	}
	public void loadMap(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Map.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
