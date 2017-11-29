/*AWT or Abstract Windowing Toolkit
Use of peer components
Swing
the checkboxes, radio buttons, buttons, textfields
were now developed in Java itself, and provided
a much more uniform look and feel
than the peer components of the AWT
JavaFX
Circle circle = new Circle ();
circle.setRadius (100);
circle.setCenterX (200);
circle.setCenterY (200);
The Application class MUST be extended
by every Javafx program
The abstract public void start (Stage primaryStage)
method
here MUST be overridden.
public void init ()
public void stop ()
Stage, scene, node
*/
import javafx.application.Application; //.*
import javafx.stage.Stage; //.*
import javafx.scene.Scene; //.*
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
public class FirstJFX extends Application
       {
		   /*public static void main (String [] args)
		         {
					 launch (args);
				 }*/
		   public FirstJFX ()
		        {
					System.out.println ("In no arg constructor");
				}
		   public FirstJFX (String s)
		        {
					System.out.println ("In one arg constructor");
				}
		   public void init ()
		       {
				   System.out.println ("In init () method");
			   }
		   public void stop ()
		       {
				   System.out.println ("In stop () method");
			   }

		   public void start (Stage primaryStage)
		      {
                   System.out.println ("In start () method");
			  }
       }

