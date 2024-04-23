package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage stg;

	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			BorderPane root = FXMLLoader.load(getClass().getResource("/Screens/Sample.fxml"));
			Scene scene = new Scene(root,780,460);
			scene.getStylesheets().add(getClass().getResource("/Screens/loginPage.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/Screens/"+fxml));
		stg.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
