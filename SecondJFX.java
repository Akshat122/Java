import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
public class SecondJFX extends Application
      {
		  public void start (Stage primaryStage)
		        {
					primaryStage.setTitle ("Second Program");
					Button ok = new Button ("OK");
					StackPane sp = new StackPane ();
					Circle circle = new Circle ();
					circle.setRadius (100);
					circle.setCenterX (100);
					circle.setCenterY (100);

					circle.setFill (Color.BLUE);
					circle.setStroke (Color.RED);
					sp.getChildren ().add (circle);
					sp.getChildren ().add (ok);
					Scene scene = new Scene (sp, 400, 400);
					primaryStage.setScene (scene);
					primaryStage.show ();
				}
	  }