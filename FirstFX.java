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
public class FirstFX extends Application
	{
	/*	public static void main(String [] args)
			{
				launch (args);
			}
	*/	public FirstFX()
			{
				System.out.println("In no args constructor");
			}
		public FirstFX(String s)
			{
				System.out.println("In no args constructor");
			}
		public void init()
			{
				System.out.println("In init ()  method");

			}
		public void stop()
			{
						System.out.println("In stop ()  method");
			}
		public void start (Stage primaryStage)
			{
				System.out.println("In start () method");
			}
	}