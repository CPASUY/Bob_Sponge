package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.AdjListGraph;
import model.AdjVertex;
import model.User;
import model.UserManagment;
import model.Vertex;


public class BobSpongeController {
	@FXML
	private BorderPane basePane;
	@FXML
	private TableView<User<String>> tableScores;
	@FXML
	private TableColumn<User<String>, String> idNickname;
	@FXML
	private TableColumn<User<String>, Double> idScore;
	@FXML
    private TextField textNickname;
	private Stage stage;

	private AdjListGraph<String> listGraph;
	@FXML
	private Rectangle rectangleBOB;
	private Rectangle rectangleBurger;
	private Rectangle rectanglePactrick;
	private Rectangle rectangleMassage;
	private Rectangle rectangleCalam;
	private Rectangle rectangleScissor;
	private Rectangle rectangleSchool;
	private Rectangle rectangleBucket;
	private Rectangle rectangleCards;
	

	private AdjListGraph<String> listGraphMap;
	private AdjListGraph<String> listGraphClue;
	private UserManagment<String> um;


	public BobSpongeController(Stage s) throws IOException {
		stage=s;
		listGraphMap=new AdjListGraph<String>(false,true,9);
		listGraphClue=new AdjListGraph<String>(false,false,8);
		um=new UserManagment<String>();
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
		listGraphMap.addVertex("Bob's House");
		listGraphMap.addVertex("Squidward's House");
		listGraphMap.addVertex("Patrick's House");
		listGraphMap.addVertex("Planton's Restaurant");
		listGraphMap.addVertex("Vehicle School");
		listGraphMap.addVertex("Scissors Shop");
		listGraphMap.addVertex("Massage Shop");
		listGraphMap.addVertex("Card Shop");
		listGraphMap.addVertex("Krabby Crustacio");
	}
	public void initGameEdges() {
		listGraphMap.addEdge("Bob's House", "Patrick's House",20);
		listGraphMap.addEdge("Bob's House", "Card Shop",130);
		listGraphMap.addEdge("Bob's House", "Scissors Shop", 120);
		listGraphMap.addEdge("Bob's House", "Squidward's House", 35);
		listGraphMap.addEdge("Squidward's House","Patrick's House",40);
		listGraphMap.addEdge("Squidward's House", "Scissors Shop", 60);
		listGraphMap.addEdge("Patrick's House", "Krabby Crustacio", 140);
		listGraphMap.addEdge("Patrick's House", "Vehicle School", 40);
		listGraphMap.addEdge("Planton's Restaurant", "Krabby Crustacio", 15);
		listGraphMap.addEdge("Card Shop", "Planton's Restaurant", 20);
		listGraphMap.addEdge("Vehicle School", "Card Shop", 50);
		listGraphMap.addEdge("Scissors Shop", "Card Shop", 15);
		listGraphMap.addEdge("Scissors Shop","Vehicle School", 30);
		listGraphMap.addEdge("Scissors Shop", "Krabby Crustacio", 60);
		listGraphMap.addEdge("Scissors Shop", "Planton's Restaurant", 40);
		listGraphMap.addEdge("Massage Shop", "Scissors Shop", 35);
		listGraphMap.addEdge("Massage Shop", "Krabby Crustacio", 25);
		listGraphMap.addEdge("Massage Shop", "Planton's Restaurant", 30);
		listGraphMap.addEdge("Massage Shop","Patrick's House",70);
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
	public void loadRules(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Rules.fxml"));
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
	public void loadClue3(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Clue3.fxml"));
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
	public void loadSignUp(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("SignUp.fxml"));
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
	public void loadGame(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Game.fxml"));
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
		loadGame();
	}
	@FXML
	void nextSignUp(ActionEvent event) {
		loadMap();
	}
	@FXML
	void nextClue3(ActionEvent event) {
		loadSignUp();
	}
	@FXML
	void nextRules(ActionEvent event) {
		loadClue3();
	}
	@FXML
	void nextGame(ActionEvent event) {
		loadRules();
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
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Challenge.fxml"));
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
    void playGameScores(ActionEvent event) {
    	loadScores();
    }
	 public void loadScores() {
	    	basePane.setOnKeyPressed(null);
	    	FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Scores.fxml"));
			fxmload.setController(this);
			Parent root;
			try {
				root = fxmload.load();
				basePane.getChildren().clear();
				basePane.setCenter(root);
			} catch (IOException e) {
				e.printStackTrace();
			}
			tableScores.getItems().clear();
			ObservableList<User<String>> user= FXCollections.observableArrayList(um.showList());
			tableScores.setItems(user);
			
			idNickname.setCellValueFactory(new PropertyValueFactory<User<String>, String>("Nickname"));
			idScore.setCellValueFactory(new PropertyValueFactory<User<String>, Double>("Score"));
		}
	 @FXML
	 void backMenu(ActionEvent event) {
		 loadPlayGame();
	 }
	 @FXML
	 void clue1(ActionEvent event) {
		 Vertex<String> v1=listGraphMap.getVertex().get(0);
		 Vertex<String> v2=listGraphMap.getVertex().get(8);
		 System.out.println(listGraphMap.dijkstra(v1,v2));
	}

	@FXML
	void clue2(ActionEvent event) {

	}

	@FXML
	void clue3(ActionEvent event) {
		initClue3Vertex();
		initClue3Edges();
		loadChallenge();
		System.out.println("AQUI");
		System.out.println(listGraphClue.bfs("Bob's Sponge", "Gary"));
	}
	public void initClue3Vertex() {
		listGraphClue.addVertex("Bob's Sponge");
		listGraphClue.addVertex("Calamardo");
		listGraphClue.addVertex("Patricio");
		listGraphClue.addVertex("Planton");
		listGraphClue.addVertex("Gary");
		listGraphClue.addVertex("Larry");
		listGraphClue.addVertex("Perlita");
		listGraphClue.addVertex("Eugene");
	}
	public void initClue3Edges() {
		listGraphClue.addEdge("Bob's Sponge", "Patricio");
		listGraphClue.addEdge("Patricio", "Gary");
		listGraphClue.addEdge("Gary", "Calamardo");
		listGraphClue.addEdge("Calamardo", "Larry");
		listGraphClue.addEdge("Calamardo", "Planton");
		listGraphClue.addEdge("Planton","Perlita");
		listGraphClue.addEdge("Planton", "Larry");
		listGraphClue.addEdge("Larry", "Perlita");
		listGraphClue.addEdge("Perlita", "Eugene");
	}
	@FXML
	void exitGame(ActionEvent event) {

	}
	
	@FXML
	void buttonBOB(ActionEvent event) {
		rectangleBOB.setVisible(true);
	}

}
