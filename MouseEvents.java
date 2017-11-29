import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
public class MouseEvents extends Application
	{
		public void start (Stage primaryStage)
			{
				primaryStage.setTitle ("Mouse Handling");
				Pane pane = new Pane();
				Text text = new Text(200,200,"ABCD");
				pane.getChildren().add(text);
				text.setOnMouseDragged(e ->
				{
					text.setX(e.getX());
					text.setY(e.getY());
				}
				);
				
				Scene scene = new Scene(pane,800,800);
				primaryStage.setScene(scene);
				primaryStage.show();
			}
	}
