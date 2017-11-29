import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.geometry.*;
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
public class ShrinkAndGrow extends Application
{
	Circle circle = new Circle ();
		double radius = 100;
		public void start(Stage primaryStage)
		{
			primaryStage.setTitle("Expanding and Compressing");
			StackPane stackPane = new StackPane();
			circle.setRadius(radius);
			circle.setFill (new Color(0.75,0,0,0.75));
			circle.setStroke(new Color(0,0,0.75,0.75));
			circle.setStrokeWidth(3);
			stackPane.getChildren().add(circle);
			Button shrink = new Button("Shrink");
			shrink.setOnAction(ae -> {if(radius > 50)	{radius -=2;circle.setRadius (radius);}});
			Button grow = new Button("grow");
			grow.setOnAction(ae -> {if(radius < 150 )	{radius +=2;circle.setRadius (radius);}});
			HBox hbox = new HBox();
			hbox.setSpacing(40);
			hbox.setAlignment(Pos.CENTER);
			hbox.getChildren().addAll(shrink,grow);
			BorderPane borderPane= new BorderPane();
			borderPane.setPadding(new Insets (30,30,30,30));
			borderPane.setCenter(stackPane);
			borderPane.setBottom(hbox);

			Scene scene = new Scene(borderPane,600,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		}

}
