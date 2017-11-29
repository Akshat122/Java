import javafx.application.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
2import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
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
				circle.setFill (Color.WHITE);
				getChildren ().add (circle);
				//Writing the numbers 1, 2, ..., 12
				for (int i = 0; i < text.length; i ++)
				   {
				      xLoc = centerX + radius * 0.8 * Math.cos (Math.PI * i / 6 - Math.PI / 3);
				      yLoc = centerY + radius * 0.8 * Math.sin (Math.PI * i / 6 - Math.PI / 3);
				      text [i] = new Text (xLoc, yLoc, "" + (i + 1));
				      getChildren ().add (text [i]);
				   }
			 }
	 }