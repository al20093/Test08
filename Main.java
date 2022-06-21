package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public void start(Stage primaryStage) {
		SceneMain sceneMain = new SceneMain(primaryStage);
		SceneContents.createScene(sceneMain);
		sceneMain.assignSceneToStage("initial");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
