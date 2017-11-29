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
public class PB extends Application
	{
		public void start(Stage primaryStage)
			{
				primaryStage.setTitle("Property Binding");
				StackPane sp= new StackPane();	//always draw a circle in the center
				//Pane sp= new Pane();
				Color  color = new Color(0.5,0.0,0.5,0.3);
				Circle circle = new Circle ();
				Label ok = new Label("ok");
				circle.setCenterX(100);
				circle.setCenterY(100);
				circle.setRadius (20);
				//circle.setFill(color);
				//circle.setStroke(Color.BLUE);
				circle.setStrokeWidth(4);

				//circle.centerXProperty().bind (sp.widthProperty().divide(2));
			//	circle.centerXProperty().bind (sp.heightProperty().divide(2));
				circle.radiusProperty().bind (sp.widthProperty().divide(3));

				sp.getChildren().add (circle);
				sp.getChildren().add (ok);
				Scene scene = new Scene(sp,300,400);
				primaryStage.setScene(scene);
				primaryStage.show();
			}
	}