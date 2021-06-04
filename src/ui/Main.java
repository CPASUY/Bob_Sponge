package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("BasePane.fxml"));
		BobSpongeController bsc=new BobSpongeController(primaryStage);
		fxmload.setController(bsc);
		Parent root=fxmload.load();
		Scene scene = new Scene(root,1009,686);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Where is my Cangreburguer?");
		bsc.initialize();
		bsc.loadPlayGame();
		bsc.initGameVertex();
		bsc.initGameEdges();
	}

}
