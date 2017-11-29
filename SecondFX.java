import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
public class SecondFX extends Application
	{
		public void start (Stage primaryStage)
			{
				primaryStage.setTitle ("A JavaFX program");
				Button ok = new Button("OK");
				// take the button and placed it as the root node on the scene
				/*HBox hBox = new HBox ();//Layout Manager
				hBox.getChildren ().add (ok);
				//Obserable List of Nodes , Like an ArrayList
				Scene scene = new Scene (hBox,200,200);
				*/
				StackPane stackPane = new StackPane ();
				Circle circle = new Circle ();
				circle.setRadius (100);
				circle.setCenterX (100);
				circle.setCenterY (100);
				stackPane.getChildren().add(circle);
				stackPane.getChildren().add(ok);

				circle.setFill(Color.BLUE);
				circle.setStroke(Color.RED);

				Scene scene = new Scene (stackPane,400,400);
				//Scene Constructor
				//pixel values are double
				primaryStage.setScene (scene);
				primaryStage.show();

			}
	}