import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class EH11 extends Application
      {
		  public static int biCount, b2Count;
          public void start (Stage primaryStage)
                {
                   primaryStage.setTitle ("Event Handling");
                   HBox hBox = new HBox (50);
                   hBox.setAlignment(Pos.CENTER);
                   Button b1 = new Button ("Button B1"),
                          b2 = new Button ("Button B2");
                   B1Handler b1h = new B1Handler ();
                   B2Handler b2h = new B2Handler ();
                   b1.setOnAction (b1h);
                   b2.setOnAction (b2h);
                   hBox.getChildren ().addAll (b1, b2);
                   Scene scene = new Scene (hBox, 500, 500);
                   primaryStage.setScene (scene);
                   primaryStage.show ();
                }
      }

class B1Handler implements EventHandler<ActionEvent>
     {
		 public void handle (ActionEvent e)
		       {
				    System.out.println ("Number of times button B1 clicked: " + ++ EH11.biCount);
			   }
	 }
class B2Handler implements EventHandler<ActionEvent>
     {
		 public void handle (ActionEvent e)
		       {
				    System.out.println ("Number of times button B2 clicked: " + ++ EH11.b2Count);
			   }
	 }
