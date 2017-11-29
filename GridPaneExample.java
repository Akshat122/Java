import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
public class GridPaneExample extends Application
      {
         public void start (Stage primaryStage)
               {
                  primaryStage.setTitle ("GridPane example");
                  GridPane gridPane = new GridPane ();
                  gridPane.setAlignment (Pos.CENTER);
                  gridPane.setPadding (new Insets (15, 15, 15, 15));
                  gridPane.setHgap (10);
                  gridPane.setVgap (10);


                  Circle circle = new Circle ();
                  circle.setRadius (50);

                  circle.setFill (Color.WHITE);
                  circle.setStroke (Color.RED);
                  Ellipse ellipse = new Ellipse ();
                  ellipse.setRadiusX (40);
                  ellipse.setRadiusY (60);
                  ellipse.setFill (Color.WHITE);
                  ellipse.setStroke (Color.RED);

                  gridPane.add (circle, 0, 0);
                  gridPane.add (ellipse, 1, 0);
                  gridPane.setGridLinesVisible (true);
                  Scene scene = new Scene (gridPane, 500, 500);
                  primaryStage.setScene (scene);
                  primaryStage.show ();
               }
      }