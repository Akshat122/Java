import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
public class BorderPaneExample extends Application
      {
         public void start (Stage primaryStage)
               {
                  primaryStage.setTitle ("BorderPane example");
                  BorderPane borderPane = new BorderPane ();
                  borderPane.setTop (new AnotherPane ("Top"));
                  //Try and change this to setTop (null); What happened?
                  borderPane.setBottom (new AnotherPane ("Bottom"));
                  borderPane.setLeft (new AnotherPane ("Left"));
                  borderPane.setRight (new AnotherPane ("Right"));
                  borderPane.setCenter (new AnotherPane ("Center"));
                  Scene scene = new Scene (borderPane, 500, 500);
                  primaryStage.setScene (scene);
                  primaryStage.show ();
               }
      }
class AnotherPane extends StackPane
     {
		 public AnotherPane (String name)
		       {
				   Label label = new Label (name);
				   getChildren ().add (label);
				   setPadding (new Insets (5, 5, 5, 5));
				   setStyle ("-fx-border-color: red;");
			   }
	 }