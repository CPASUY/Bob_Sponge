package ui;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
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
	@FXML
	private Rectangle rectangleBOB;
	@FXML
	private Rectangle rectangleBurger;
	@FXML
	private Rectangle rectanglePactrick;
	@FXML
	private Rectangle rectangleMassage;
	@FXML
	private Rectangle rectangleCalam;
	@FXML
	private Rectangle rectangleScissor;
	@FXML
	private Rectangle rectangleSchool;
	@FXML
	private Rectangle rectangleBucket;
	@FXML
	private Rectangle rectangleCards;
	@FXML
	private Rectangle rectangleStar;
	@FXML
	private Rectangle rectangleGary;
	@FXML
	private Rectangle rectanglePlanton;
	@FXML
	private Rectangle rectanglePerlita;
	@FXML
	private Rectangle rectangleMuscle;
	@FXML
	private Rectangle rectangleCalamardo;
	@FXML
	private Rectangle rectangleBobC;
	@FXML
	private Rectangle rectangleCangrejo;
	@FXML
	private Rectangle rectangleOnion;
	@FXML
	private Rectangle rectangleMeat;
	@FXML
	private Rectangle rectanglePickle;
	@FXML
	private Rectangle rectangleTomato;
	@FXML
	private Rectangle rectangleEgg;
	@FXML
	private Rectangle rectangleLettuce;
	@FXML
	private Rectangle rectangleBacon;
	
	User<String> user;
	private AdjListGraph<String> listGraphMap;
	private AdjListGraph<String> listGraphClue;
	private AdjListGraph<String> listGraphClue2;
	private UserManagment<String> um;
	private ArrayList<Vertex<String>> challengeElection;
	private ArrayList<Vertex<String>> challenge2Election;
	private ArrayList<Vertex<String>> mapElection;


	public BobSpongeController(Stage s) throws IOException {
		stage=s;
		s.setResizable(false);
		listGraphMap=new AdjListGraph<String>(false,true,9);
		listGraphClue=new AdjListGraph<String>(false,false,8);
		listGraphClue2=new AdjListGraph<String>(false,true,7);
		um=new UserManagment<String>();
		challengeElection=new ArrayList<Vertex<String>>();
		challenge2Election=new ArrayList<Vertex<String>>();
		mapElection=new ArrayList<Vertex<String>>();
	}
	public void initialize() {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	
				@Override
				public void handle(WindowEvent event) {
					System.out.println("Closing the window!");
					System.out.println("Closing the window!");
					try {
						um.saveRootUsers();
					} catch (FileNotFoundException e) {
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
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
		listGraphMap.addEdge("Vehicle School","Scissors Shop", 30);
		listGraphMap.addEdge("Scissors Shop", "Krabby Crustacio", 50);
		listGraphMap.addEdge("Scissors Shop", "Planton's Restaurant", 40);
		listGraphMap.addEdge("Massage Shop", "Scissors Shop", 35);
		listGraphMap.addEdge("Massage Shop", "Krabby Crustacio", 45);
		listGraphMap.addEdge("Massage Shop", "Planton's Restaurant", 30);
		listGraphMap.addEdge("Massage Shop","Patrick's House",80);
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
	public void loadClue2(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Clue2.fxml"));
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
		String n=textNickname.getText();
		if(n.isEmpty()) {
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Empty space");
			alert.setHeaderText("You must fill in the blank");
			alert.setContentText("Check that you have entered a nickname");
    	}else {
    		user = new User<String>(textNickname.getText(),0);
    		user.setInitialMap((AdjVertex<String>) listGraphMap.getVertex().get(0));
    		um.addPlayer(user);
    		user.setStartTime(System.currentTimeMillis());
    		loadMap();
    	}
	}
	@FXML
	void nextClue3(ActionEvent event) {
		loadSignUp();
	}
    @FXML
    void nextClue2(ActionEvent event) {
    	loadClue3();
    }
	@FXML
	void nextRules(ActionEvent event) {
		loadClue2();
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
	public void loadChallenge2(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Challenge1.fxml"));
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
	}

	@FXML
	void clue2(ActionEvent event) {
		initClue2Vertex();
		initClue2Edges();
		loadChallenge2();
	}

	@FXML
	void clue3(ActionEvent event) {
		initClue3Vertex();
		initClue3Edges();
		loadChallenge();
		user.setInitialClue((AdjVertex<String>) listGraphClue.getVertex().get(0));
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
		listGraphClue.addEdge("Planton","Larry");
		listGraphClue.addEdge("Eugene","Perlita");
		listGraphClue.addEdge("Larry", "Perlita");
		listGraphClue.addEdge("Perlita", "Eugene");
	}
	public void initClue2Vertex() {
		listGraphClue2.addVertex("Pickle");
		listGraphClue2.addVertex("Onion");
		listGraphClue2.addVertex("Meat");
		listGraphClue2.addVertex("Egg");
		listGraphClue2.addVertex("Tomato");
		listGraphClue2.addVertex("Lettuce");
		listGraphClue2.addVertex("Bacon");
	}
	public void initClue2Edges() {
		listGraphClue2.addEdge("Pickle", "Onion",50);
		listGraphClue2.addEdge("Pickle", "Meat",10);
		listGraphClue2.addEdge("Onion", "Meat",40);
		listGraphClue2.addEdge("Onion", "Bacon",60);
		listGraphClue2.addEdge("Onion", "Lettuce",20);
		listGraphClue2.addEdge("Meat","Tomato",70);
		listGraphClue2.addEdge("Meat","Bacon",80);
		listGraphClue2.addEdge("Bacon","Tomato",110);
		listGraphClue2.addEdge("Bacon", "Lettuce",90);
		listGraphClue2.addEdge("Lettuce", "Tomato",30);
		listGraphClue2.addEdge("Lettuce", "Egg",120);
		listGraphClue2.addEdge("Tomato", "Egg",100);
	}
	@FXML
	void exitGame(ActionEvent event) {
		user.setEndTime(System.currentTimeMillis());
		int score=(int) ((user.getEndTime()-user.getStartTime())/1000);
		user.setScore(score);
		loadPlayGame();
	}
	
	void putRectanglesMap() {
		if(user.getInitialMap().isAdjacent(user.getDestinyMap())) {
			user.setInitialMap(user.getDestinyMap());
			putAllInvisibleMap();
			visibleRectangleCurrent(user.getInitialMap());
			visibleRectangleAdjacent(user.adjMap());
		}
	}
	
	void putRectanglesChallenge() {
		if(user.getInitialClue().isAdjacent(user.getDestinyClue())) {
			user.setInitialClue(user.getDestinyClue());
			putAllInvisibleClue3();
			visibleRectangleCurrent(user.getInitialClue());
			visibleRectangleAdjacent(user.adjChallenge());
		}
	}
	
	void putRectanglesChallenge2() {
		
		if(user.isStartClue2() == false) {
			putAllInvisibleClue2();
			visibleRectangleCurrent(user.getInitialClue2());
			visibleRectangleAdjacent(user.adjChallenge2());
			user.setStartClue2(true);
		}
		else {
			if(user.getInitialClue2().isAdjacent(user.getDestinyClue2())) {
				user.setInitialClue2(user.getDestinyClue2());
				putAllInvisibleClue2();
				visibleRectangleCurrent(user.getInitialClue2());
				visibleRectangleAdjacent(user.adjChallenge2());
			}	
		}
	}
	
	@FXML
	void buttonCalam(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(1));
		mapElection.add(listGraphMap.getVertex().get(1));
		putRectanglesMap();
	}
	@FXML
	void buttonMassage(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(6));
		mapElection.add(listGraphMap.getVertex().get(6));
		putRectanglesMap();
	}
	@FXML
	void buttonPactrick(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(2));
		mapElection.add(listGraphMap.getVertex().get(2));
		putRectanglesMap();
	}
	@FXML
	void buttonBurguer(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(8));
		mapElection.add(listGraphMap.getVertex().get(8));
		putRectanglesMap();
	}
	@FXML
	void buttonSchool(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(4));
		mapElection.add(listGraphMap.getVertex().get(4));
		putRectanglesMap();
	}
	@FXML
	void buttonScissor(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(5));
		mapElection.add(listGraphMap.getVertex().get(5));
		putRectanglesMap();
	}
	@FXML
	void buttonCards(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(7));
		mapElection.add(listGraphMap.getVertex().get(7));
		putRectanglesMap();
	}
	@FXML
	void buttonBucket(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(3));
		mapElection.add(listGraphMap.getVertex().get(3));
		putRectanglesMap();
	}
	@FXML
	void buttonBOB(ActionEvent event) {
		user.setDestinyMap((AdjVertex<String>) listGraphMap.getVertex().get(0));
		putRectanglesMap();
	}
	//
	@FXML
	void buttonStarC(ActionEvent event) {
		user.setDestinyClue((AdjVertex<String>) listGraphClue.getVertex().get(2));
		challengeElection.add(listGraphClue.getVertex().get(2));
		putRectanglesChallenge();
		
	}
	@FXML
	void buttonBobC(ActionEvent event) {
		user.setDestinyClue((AdjVertex<String>) listGraphClue.getVertex().get(0));
		putRectanglesChallenge();
	}
	@FXML
	void buttonCalamC(ActionEvent event) {
		user.setDestinyClue((AdjVertex<String>) listGraphClue.getVertex().get(1));
		challengeElection.add(listGraphClue.getVertex().get(1));
		putRectanglesChallenge();
	}
	@FXML
	void buttonMuscleC(ActionEvent event) {
		user.setDestinyClue((AdjVertex<String>) listGraphClue.getVertex().get(5));
		challengeElection.add(listGraphClue.getVertex().get(5));
		putRectanglesChallenge();
	}
	@FXML
	void buttonCangrejoC(ActionEvent event) {
		user.setDestinyClue((AdjVertex<String>) listGraphClue.getVertex().get(7));
		challengeElection.add(listGraphClue.getVertex().get(7));
		putRectanglesChallenge();
	}
	@FXML
	void buttonPerlitaC(ActionEvent event) {
		user.setDestinyClue((AdjVertex<String>) listGraphClue.getVertex().get(6));
		challengeElection.add(listGraphClue.getVertex().get(6));
		putRectanglesChallenge();
	}
	@FXML
	void buttonPlantonC(ActionEvent event) {
		user.setDestinyClue((AdjVertex<String>) listGraphClue.getVertex().get(3));
		challengeElection.add(listGraphClue.getVertex().get(3));

		putRectanglesChallenge();
	}
	@FXML
	void buttonGaryC(ActionEvent event) {
		user.setDestinyClue((AdjVertex<String>) listGraphClue.getVertex().get(4));
		challengeElection.add(listGraphClue.getVertex().get(4));
		putRectanglesChallenge();
	}
	
	@FXML
	void buttonPickle(ActionEvent event) {
		if(user.isStartClue2() == false) {
			  user.setInitialClue2((AdjVertex<String>) listGraphClue2.getVertex().get(0));
			  putRectanglesChallenge2();
			  challenge2Election.add(listGraphClue2.getVertex().get(0));
			}
			else {
				user.setDestinyClue2((AdjVertex<String>) listGraphClue2.getVertex().get(0));
				putRectanglesChallenge2();	
				challenge2Election.add(listGraphClue2.getVertex().get(0));
			}
	}
	@FXML
	void buttonOnion(ActionEvent event) {
		if(user.isStartClue2() == false) {
			  user.setInitialClue2((AdjVertex<String>) listGraphClue2.getVertex().get(1));
			  putRectanglesChallenge2();
			  challenge2Election.add(listGraphClue2.getVertex().get(1));
			}
			else {
				user.setDestinyClue2((AdjVertex<String>) listGraphClue2.getVertex().get(1));
				putRectanglesChallenge2();	
				challenge2Election.add(listGraphClue2.getVertex().get(1));
			}
	}
	@FXML
	void buttonBacon(ActionEvent event) {
		if(user.isStartClue2() == false) {
			  user.setInitialClue2((AdjVertex<String>) listGraphClue2.getVertex().get(6));
			  challenge2Election.add(listGraphClue2.getVertex().get(6));
			  putRectanglesChallenge2();
			}
			else {
				user.setDestinyClue2((AdjVertex<String>) listGraphClue2.getVertex().get(6));
				putRectanglesChallenge2();	
				challenge2Election.add(listGraphClue2.getVertex().get(6));
			}
	}
	@FXML
	void buttonMeat(ActionEvent event) {
		if(user.isStartClue2() == false) {
		  user.setInitialClue2((AdjVertex<String>) listGraphClue2.getVertex().get(2));
		  putRectanglesChallenge2();
		  challenge2Election.add(listGraphClue2.getVertex().get(2));
		}
		else {
			user.setDestinyClue2((AdjVertex<String>) listGraphClue2.getVertex().get(2));
			putRectanglesChallenge2();	
			challenge2Election.add(listGraphClue2.getVertex().get(2));
		}
	}
	@FXML
	void buttonTomato(ActionEvent event) {
		if(user.isStartClue2() == false) {
			  user.setInitialClue2((AdjVertex<String>) listGraphClue2.getVertex().get(4));
			  putRectanglesChallenge2();
			  challenge2Election.add(listGraphClue2.getVertex().get(4));
			}
			else {
				user.setDestinyClue2((AdjVertex<String>) listGraphClue2.getVertex().get(4));
				putRectanglesChallenge2();	
				challenge2Election.add(listGraphClue2.getVertex().get(4));
			}
		}
	@FXML
	void buttonEgg(ActionEvent event) {
		if(user.isStartClue2() == false) {
			  user.setInitialClue2((AdjVertex<String>) listGraphClue2.getVertex().get(3));
			  putRectanglesChallenge2();
			  challenge2Election.add(listGraphClue2.getVertex().get(3));
			}
			else {
				user.setDestinyClue2((AdjVertex<String>) listGraphClue2.getVertex().get(3));
				putRectanglesChallenge2();	
				challenge2Election.add(listGraphClue2.getVertex().get(3));
			}
	}
	@FXML
	void buttonLettuce(ActionEvent event) {
		if(user.isStartClue2() == false) {
			  user.setInitialClue2((AdjVertex<String>) listGraphClue2.getVertex().get(5));
			  putRectanglesChallenge2();
			  challenge2Election.add(listGraphClue2.getVertex().get(5));
			}
			else {
				user.setDestinyClue2((AdjVertex<String>) listGraphClue2.getVertex().get(5));
				putRectanglesChallenge2();	
				challenge2Election.add(listGraphClue2.getVertex().get(5));
			}
	}
	
	@FXML
	boolean calificateElectionChallenge(ActionEvent event) {
		double distance=0;
		for(int s=0;s<challengeElection.size();s++) {
			AdjVertex<String> v=(AdjVertex<String>) challengeElection.get(s);
			distance=distance+v.findEdgeOfVertex(v).getWeight();
		}

		if(listGraphClue.bfs("Bob's Sponge","Eugene")==distance) {
			return true;
		}else {
			return false;
		}
	}
	@FXML
	boolean calificateElectionChallenge2(ActionEvent event) {
		double [] distances=new double[challenge2Election.size()];
		for(int s=0;s<distances.length;s++) {
			if(distances[s]==0) {
			}
		}
		double distance=0;
		for(int s=0;s<challenge2Election.size()-1;s++){
			AdjVertex<String> v1=(AdjVertex<String>) challenge2Election.get(s);
			AdjVertex<String> v2=(AdjVertex<String>) challenge2Election.get(s+1);
			if(!findNumber(distances,v1.findEdgeOfVertexFinal(v2).getWeight())) {
				distances[s]=v1.findEdgeOfVertexFinal(v2).getWeight();
				distance=distance+v1.findEdgeOfVertexFinal(v2).getWeight();
			}
		}
		if(listGraphClue2.kruskal()==distance) {
			return true;
		}else {
			return false;
		}
	}
	boolean findNumber(double[]a,double n) {
		for(int s=0;s<a.length;s++) {
			if(a[s]==n) {
				return true;
			}
		}
		return false;
	}
	@FXML
	boolean calificateElectionMap(ActionEvent event) {
		double distance=0;
		for(int s=0;s<mapElection.size();s++) {
			AdjVertex<String> v=(AdjVertex<String>) mapElection.get(s);
			distance=distance+v.findEdgeOfVertex(v).getWeight();
		}

		if(listGraphMap.dijkstra(listGraphMap.getVertexDijkstra().get(0),listGraphMap.getVertexDijkstra().get(8))==distance) {
			user.setEndTime(System.currentTimeMillis());
			int score=(int) ((user.getEndTime()-user.getStartTime())/1000);
			user.setScore(score);
			return true;
		}else {
			return false;
		}
	}
	
	void visibleRectangleCurrent(AdjVertex<String> initial) {
		switch((String)initial.getValue()) {
		case "Bob's House":
			rectangleBOB.setStroke(Color.RED);
			rectangleBOB.setVisible(true);
			break;
		case "Squidward's House":
			rectangleCalam.setStroke(Color.RED);
			rectangleCalam.setVisible(true);
			break;
		case "Patrick's House":
			rectanglePactrick.setStroke(Color.RED);
			rectanglePactrick.setVisible(true);
			break;
		case "Planton's Restaurant":
			rectangleBucket.setStroke(Color.RED);
			rectangleBucket.setVisible(true);
			break;
		case "Vehicle School":
			rectangleSchool.setStroke(Color.RED);
			rectangleSchool.setVisible(true);
			break;
		case "Scissors Shop":
			rectangleScissor.setStroke(Color.RED);
			rectangleScissor.setVisible(true);
			break;
		case "Massage Shop":
			rectangleMassage.setStroke(Color.RED);
			rectangleMassage.setVisible(true);
			break;
		case "Card Shop":
			rectangleCards.setStroke(Color.RED);
			rectangleCards.setVisible(true);
			break;
		case "Krabby Crustacio":
			rectangleBurger.setStroke(Color.RED);
			rectangleBurger.setVisible(true);
			break;
		case "Bob's Sponge":
			rectangleBobC.setStroke(Color.RED);
			rectangleBobC.setVisible(true);
			break;
		case "Calamardo":
			rectangleCalamardo.setStroke(Color.RED);
			rectangleCalamardo.setVisible(true);
			break;
		case "Patricio":
			rectangleStar.setStroke(Color.RED);
			rectangleStar.setVisible(true);
			break;
		case "Planton":
			rectanglePlanton.setStroke(Color.RED);
			rectanglePlanton.setVisible(true);
			break;
		case "Gary":
			rectangleGary.setStroke(Color.RED);
			rectangleGary.setVisible(true);
			break;
		case "Larry":
			rectangleMuscle.setStroke(Color.RED);
			rectangleMuscle.setVisible(true);
			break;
		case "Perlita":
			rectanglePerlita.setStroke(Color.RED);
			rectanglePerlita.setVisible(true);
			break;
		case "Eugene":
			rectangleCangrejo.setStroke(Color.RED);
			rectangleCangrejo.setVisible(true);
			break;
		case "Pickle":
			rectanglePickle.setStroke(Color.RED);
			rectanglePickle.setVisible(true);
			break;
		case "Onion":
			rectangleOnion.setStroke(Color.RED);
			rectangleOnion.setVisible(true);
			break;
		case "Bacon":
			rectangleBacon.setStroke(Color.RED);
			rectangleBacon.setVisible(true);
			break;
		case "Lettuce":
			rectangleLettuce.setStroke(Color.RED);
			rectangleLettuce.setVisible(true);
			break;
		case "Egg":
			rectangleEgg.setStroke(Color.RED);
			rectangleEgg.setVisible(true);
			break;
		case "Meat":
			rectangleMeat.setStroke(Color.RED);
			rectangleMeat.setVisible(true);
			break;
		case "Tomato":
			rectangleTomato.setStroke(Color.RED);
			rectangleTomato.setVisible(true);
			break;
		}
	}
	
	void visibleRectangleAdjacent(ArrayList<AdjVertex<String>>adj) {
		for(int i=0;i<adj.size();i++) {
		switch((String)adj.get(i).getValue()) {
		case "Bob's House":
			rectangleBOB.setStroke(Color.BLUE);
			rectangleBOB.setVisible(true);
			break;
		case "Squidward's House":
			rectangleCalam.setStroke(Color.BLUE);
			rectangleCalam.setVisible(true);
			break;
		case "Patrick's House":
			rectanglePactrick.setStroke(Color.BLUE);
			rectanglePactrick.setVisible(true);
			break;
		case "Planton's Restaurant":
			rectangleBucket.setStroke(Color.BLUE);
			rectangleBucket.setVisible(true);
			break;
		case "Vehicle School":
			rectangleSchool.setStroke(Color.BLUE);
			rectangleSchool.setVisible(true);
			break;
		case "Scissors Shop":
			rectangleScissor.setStroke(Color.BLUE);
			rectangleScissor.setVisible(true);
			break;
		case "Massage Shop":
			rectangleMassage.setStroke(Color.BLUE);
			rectangleMassage.setVisible(true);
			break;
		case "Card Shop":
			rectangleCards.setStroke(Color.BLUE);
			rectangleCards.setVisible(true);
			break;
		case "Krabby Crustacio":
			rectangleBurger.setStroke(Color.BLUE);
			rectangleBurger.setVisible(true);
			break;
		case "Bob's Sponge":
			rectangleBobC.setStroke(Color.BLUE);
			rectangleBobC.setVisible(true);
			break;
		case "Calamardo":
			rectangleCalamardo.setStroke(Color.BLUE);
			rectangleCalamardo.setVisible(true);
			break;
		case "Patricio":
			rectangleStar.setStroke(Color.BLUE);
			rectangleStar.setVisible(true);
			break;
		case "Planton":
			rectanglePlanton.setStroke(Color.BLUE);
			rectanglePlanton.setVisible(true);
			break;
		case "Gary":
			rectangleGary.setStroke(Color.BLUE);
			rectangleGary.setVisible(true);
			break;
		case "Larry":
			rectangleMuscle.setStroke(Color.BLUE);
			rectangleMuscle.setVisible(true);
			break;
		case "Perlita":
			rectanglePerlita.setStroke(Color.BLUE);
			rectanglePerlita.setVisible(true);
			break;
		case "Eugene":
			rectangleCangrejo.setStroke(Color.BLUE);
			rectangleCangrejo.setVisible(true);
			break;
		case "Pickle":
			rectanglePickle.setStroke(Color.BLUE);
			rectanglePickle.setVisible(true);
			break;
		case "Onion":
			rectangleOnion.setStroke(Color.BLUE);
			rectangleOnion.setVisible(true);
			break;
		case "Bacon":
			rectangleBacon.setStroke(Color.BLUE);
			rectangleBacon.setVisible(true);
			break;
		case "Lettuce":
			rectangleLettuce.setStroke(Color.BLUE);
			rectangleLettuce.setVisible(true);
			break;
		case "Egg":
			rectangleEgg.setStroke(Color.BLUE);
			rectangleEgg.setVisible(true);
			break;
		case "Meat":
			rectangleMeat.setStroke(Color.BLUE);
			rectangleMeat.setVisible(true);
			break;
		case "Tomato":
			rectangleTomato.setStroke(Color.BLUE);
			rectangleTomato.setVisible(true);
			break;
		}
		}
	}
	
	void putAllInvisibleMap() {
		
		rectangleBOB.setVisible(false);
		rectangleBurger.setVisible(false);
		rectanglePactrick.setVisible(false);
		rectangleMassage.setVisible(false);
		rectangleCalam.setVisible(false);
		rectangleScissor.setVisible(false);
		rectangleSchool.setVisible(false);
		rectangleBucket.setVisible(false);
		rectangleCards.setVisible(false);
	}
	
	void putAllInvisibleClue3() {
		rectangleCangrejo.setVisible(false);
		rectanglePerlita.setVisible(false);
		rectangleMuscle.setVisible(false);
		rectangleGary.setVisible(false);
		rectanglePlanton.setVisible(false);
		rectangleStar.setVisible(false);
		rectangleCalamardo.setVisible(false);
		rectangleBobC.setVisible(false);
	}
	
	void putAllInvisibleClue2() {
		rectanglePickle.setVisible(false);
		rectangleTomato.setVisible(false);
		rectangleBacon.setVisible(false);
		rectangleMeat.setVisible(false);
		rectangleEgg.setVisible(false);
		rectangleOnion.setVisible(false);
		rectangleLettuce.setVisible(false);
	}

}
