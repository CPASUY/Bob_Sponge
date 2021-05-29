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
import model.AdjListGraph;


public class BobSpongeController {
	@FXML
	private BorderPane basePane;
	private Stage stage;
	private AdjListGraph<String> listGraph;
	
	public BobSpongeController(Stage s) throws IOException {
		stage=s;
		listGraph=new AdjListGraph<String>(false,true,9);
	}
	public void initialize() {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				System.out.println("Closing the window!");
			}
		});
	}
	public void initGameVertex() {
		listGraph.addVertex("Bob's House");
		listGraph.addVertex("Squidward's House");
		listGraph.addVertex("Patrick's House");
		listGraph.addVertex("Krabby Crustacio");
		listGraph.addVertex("Planton's Restaurant");
		listGraph.addVertex("Vehicle School");
		listGraph.addVertex("Scissors Shop");
		listGraph.addVertex("Massage Shop");
		listGraph.addVertex("Card Shop");
	}
	public void initGameEdges() {
		listGraph.addEdge("Bob's House", "Patrick's House",20);
		listGraph.addEdge("Bob's House", "Card Shop",130);
		listGraph.addEdge("Bob's House", "Scissors Shop", 120);
		listGraph.addEdge("Bob's House", "Squidward's House", 35);
		listGraph.addEdge("Squidward's House","Patrick's House",40);
		listGraph.addEdge("Squidward's House", "Scissors Shop", 60);
		listGraph.addEdge("Patrick's House", "Krabby Crustacio", 140);
		listGraph.addEdge("Patrick's House", "Vehicle School", 40);
		listGraph.addEdge("Planton's Restaurant", "Krabby Crustacio", 15);
		listGraph.addEdge("Card Shop", "Planton's Restaurant", 20);
		listGraph.addEdge("Vehicle School", "Card Shop", 50);
		listGraph.addEdge("Scissors Shop", "Card Shop", 15);
		listGraph.addEdge("Scissors Shop","Vehicle School", 30);
		listGraph.addEdge("Scissors Shop", "Krabby Crustacio", 60);
		listGraph.addEdge("Scissors Shop", "Planton's Restaurant", 40);
		listGraph.addEdge("Massage Shop", "Scissors Shop", 35);
		listGraph.addEdge("Massage Shop", "Krabby Crustacio", 25);
		listGraph.addEdge("Massage Shop", "Planton's Restaurant", 30);
		listGraph.addEdge("Massage Shop","Patrick's House",70);
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
	public void loadChallenge(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Challenges.fxml"));
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
	void clue1(ActionEvent event) {

	}

	@FXML
	void clue2(ActionEvent event) {

	}

	@FXML
	void clue3(ActionEvent event) {

	}

	@FXML
	void exitGame(ActionEvent event) {

	}

}
