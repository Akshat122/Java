import javafx.application.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.Date;
import java.time.LocalDateTime;
public class Clock extends Application
      {
		 private Button setSpecifiedTime = new Button ("Set Time");
		 private Label hoursLabel = new Label ("Hours"),
		               minutesLabel = new Label ("Minutes"),
		               secondsLabel = new Label ("Seconds");
		 private ComboBox<String> hoursCB = new ComboBox<String> (),
		                          minutesCB = new ComboBox<String> (),
		                          secondsCB = new ComboBox<String> ();
		 private HBox widgetsBox = new HBox (20);
		 private BorderPane bp = new BorderPane ();
         private Scene scene;
         ClockPane clockPane;
         public void start (Stage stage)
            {
				//Getting screen dimensions

			    Rectangle2D screenSize = Screen.getPrimary ().getVisualBounds ();
				double width = screenSize.getWidth ();
				double height = screenSize.getHeight ();
				double paneWidth = 0.63 * width;
				double paneHeight = 0.72 * height;

				//////////////////////////////
				stage.setTitle ("Analog Clock");
				hoursCB.getItems ().addAll ("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
				hoursCB.setValue ("12");
				minutesCB.getItems ().addAll ("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
				minutesCB.setValue ("0");
				secondsCB.getItems ().addAll ("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
				secondsCB.setValue ("0");
				hoursCB.setStyle ("-fx-color: slateblue");
				minutesCB.setStyle ("-fx-color: slateblue");
				secondsCB.setStyle ("-fx-color: slateblue");
				hoursLabel.setTextFill (Color.RED);
				minutesLabel.setTextFill (Color.RED);
				secondsLabel.setTextFill (Color.RED);
				setSpecifiedTime.setStyle ("-fx-color: gold");
				setSpecifiedTime.setOnAction (new TimeSpecifier ());
				widgetsBox.getChildren ().addAll (setSpecifiedTime, hoursLabel, hoursCB, minutesLabel, minutesCB, secondsLabel, secondsCB);
                widgetsBox.setAlignment (Pos.CENTER);
                widgetsBox.setPadding (new Insets (10, 10, 10, 10));
                clockPane = new ClockPane ();
                bp.setCenter (clockPane);
                bp.setBottom (widgetsBox);
                scene = new Scene (bp, paneWidth, paneHeight);
                stage.setScene (scene);
                stage.setResizable (false);
                stage.show ();
            }
class ClockPane extends Pane
      {
 		 private Circle circle = new Circle ();
 		 private Line hourHand = new Line (), minuteHand = new Line (), secondHand = new Line ();
 		 private double centerX, centerY, radius,
 		                hourHandLength, minuteHandLength, secondHandLength,
 		                hourHandEndX, hourHandEndY,
 		                minuteHandEndX, minuteHandEndY,
 		                secondHandEndX, secondHandEndY,
 		                hourHandAngle, minuteHandAngle, secondHandAngle,
 		                paneWidth, paneHeight;
 		 private Text text [] = new Text [12];
 		 private double xLoc, yLoc;
 		 private Date date;
 		 private int hours, minutes, seconds;
 		 public ClockPane ()
 		     {
 				Rectangle2D screenSize = Screen.getPrimary ().getVisualBounds ();
 				double width = screenSize.getWidth ();
 				double height = screenSize.getHeight ();
 				paneWidth = 0.63 * width;
 				paneHeight = 0.72 * height;
 				//Building the clock-face
 				centerX = paneWidth / 2;
 				centerY = paneHeight / 2;
 				circle.setCenterX (centerX);
 				circle.setCenterY (centerY);
 				radius = paneWidth / 5;
 				circle.setRadius (radius);
 				circle.setStroke (Color.RED);
 				circle.setStrokeWidth (3.6);
 				circle.setFill (Color.WHITE);
 				getChildren ().add (circle);
 				//Writing the numbers 1, 2, ..., 12
 				for (int i = 0; i < text.length; i ++)
 				   {
 				      xLoc = centerX + radius * 0.8 * Math.cos (Math.PI * i / 6 - Math.PI / 3);
 				      yLoc = centerY + radius * 0.8 * Math.sin (Math.PI * i / 6 - Math.PI / 3);
 				      text [i] = new Text (xLoc, yLoc, "" + (i + 1));
 				      text [i].setFont (new Font ("Times New Roman", 24));
 				      getChildren ().add (text [i]);
 				   }

 			   //Draw hands
 			   date = new Date ();
 			   System.out.println (date);
 			   hours = Integer.parseInt (date.toString ().substring (11, 13));
 			   minutes = Integer.parseInt (date.toString ().substring (14, 16));
			   seconds = Integer.parseInt (date.toString ().substring (17, 19));

			   if (hours >= 12)
			     hours -= 12;
			   hourHandAngle = (hours + minutes / 60.0 + seconds / 3600.0) * Math.PI / 6 - Math.PI / 2;
			   minuteHandAngle = minutes / 60.0 * 2 * Math.PI - Math.PI / 2;
			   secondHandAngle = seconds / 60.0 * 2 * Math.PI - Math.PI / 2;
			   hourHandLength = radius / 4.5;
			   minuteHandLength = radius / 2.7;
			   secondHandLength = radius / 1.8;

			   hourHandEndX = centerX + hourHandLength * Math.cos (hourHandAngle);
			   hourHandEndY = centerY + hourHandLength * Math.sin (hourHandAngle);
			   hourHand.setStartX (centerX);
               hourHand.setStartY (centerY);
			   hourHand.setEndX (hourHandEndX);
               hourHand.setEndY (hourHandEndY);
               hourHand.setStroke (Color.BLUE);
               hourHand.setStrokeWidth (3.6);

			   minuteHandEndX = centerX + minuteHandLength * Math.cos (minuteHandAngle);
			   minuteHandEndY = centerY + minuteHandLength * Math.sin (minuteHandAngle);
			   minuteHand.setStartX (centerX);
               minuteHand.setStartY (centerY);
			   minuteHand.setEndX (minuteHandEndX);
               minuteHand.setEndY (minuteHandEndY);
               minuteHand.setStroke (Color.RED);
               minuteHand.setStrokeWidth (2.7);

	/*		   secondHandEndX = centerX + secondHandLength * Math.cos (secondHandAngle);
			   secondHandEndY = centerY + secondHandLength * Math.sin (secondHandAngle);
			   secondHand.setStartX (centerX);
               secondHand.setStartY (centerY);
			   secondHand.setEndX (secondHandEndX);
               secondHand.setEndY (secondHandEndY);
               secondHand.setStroke (Color.GREEN);
               secondHand.setStrokeWidth (1.8); */  //code OK but not used
               getChildren ().addAll (hourHand, minuteHand);

 			 }
	     }
private class TimeSpecifier implements EventHandler<ActionEvent>
      {
		  public void handle (ActionEvent e)
		      {
LocalDateTime now = LocalDateTime.now();
				 /* clockPane.hours = Integer.parseInt (hoursCB.getValue ().toString ());
				  clockPane.minutes = Integer.parseInt (minutesCB.getValue ().toString ());
				  clockPane.seconds = Integer.parseInt (secondsCB.getValue ().toString ());
				  clockPane.getChildren ().removeAll (clockPane.hourHand, clockPane.minuteHand);*/
				  clockPane.hours = Integer.parseInt (now.getHour());
				  				  clockPane.minutes = Integer.parseInt (now.getMinute());
				  				  clockPane.seconds = Integer.parseInt (now.getSecond());
				  clockPane.getChildren ().removeAll (clockPane.hourHand, clockPane.minuteHand);

//This code is repeated...may be better to use a method call

			   clockPane.hourHandAngle = (clockPane.hours + clockPane.minutes / 60.0 + clockPane.seconds / 3600.0) * Math.PI / 6 - Math.PI / 2;
			   clockPane.minuteHandAngle = clockPane.minutes / 60.0 * 2 * Math.PI - Math.PI / 2;
			   clockPane.secondHandAngle = clockPane.seconds / 60.0 * 2 * Math.PI - Math.PI / 2;
			   clockPane.hourHandLength = clockPane.radius / 4.5;
			   clockPane.minuteHandLength = clockPane.radius / 2.7;
			   clockPane.secondHandLength = clockPane.radius / 1.8;

			   clockPane.hourHandEndX = clockPane.centerX + clockPane.hourHandLength * Math.cos (clockPane.hourHandAngle);
			   clockPane.hourHandEndY = clockPane.centerY + clockPane.hourHandLength * Math.sin (clockPane.hourHandAngle);
			   clockPane.hourHand.setStartX (clockPane.centerX);
               clockPane.hourHand.setStartY (clockPane.centerY);
			   clockPane.hourHand.setEndX (clockPane.hourHandEndX);
               clockPane.hourHand.setEndY (clockPane.hourHandEndY);
               clockPane.hourHand.setStroke (Color.BLUE);
               clockPane.hourHand.setStrokeWidth (3.6);

			   clockPane.minuteHandEndX = clockPane.centerX + clockPane.minuteHandLength * Math.cos (clockPane.minuteHandAngle);
			   clockPane.minuteHandEndY = clockPane.centerY + clockPane.minuteHandLength * Math.sin (clockPane.minuteHandAngle);
			   clockPane.minuteHand.setStartX (clockPane.centerX);
               clockPane.minuteHand.setStartY (clockPane.centerY);
			   clockPane.minuteHand.setEndX (clockPane.minuteHandEndX);
               clockPane.minuteHand.setEndY (clockPane.minuteHandEndY);
               clockPane.minuteHand.setStroke (Color.RED);
               clockPane.minuteHand.setStrokeWidth (2.7);
               clockPane.getChildren ().addAll (clockPane.hourHand, clockPane.minuteHand);
			  }
	     }
      }
