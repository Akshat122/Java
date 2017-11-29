import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
public class EH12 extends Application
      {
                     Label loanAmt;
                     TextField amtField;
                     Label loanPeriod;
                     TextField periodField;
                     Label interestRate;
                     TextField interestRateField;
                     Label monthlyAmount;
                     Button calculateMonthlyAmount;

		   public void start (Stage primaryStage)
		         {
                     primaryStage.setTitle ("Loan Payments Calculator");
                     GridPane gridPane = new GridPane ();
                     gridPane.setAlignment (Pos.CENTER);
                     gridPane.setHgap (50);
                     gridPane.setVgap (50);
                     loanAmt = new Label ("Loan Amount Rs: ");
                     amtField = new TextField ();
                     amtField.setPrefColumnCount (10);
                     loanPeriod = new Label ("Loan Period, years: ");
                     periodField = new TextField ();
                     periodField.setPrefColumnCount (5);
                     interestRate = new Label ("Annual Interest Rate %");
                     interestRateField = new TextField ();
                     interestRateField.setPrefColumnCount (5);
                     monthlyAmount = new Label ("");
                     LoanCalculator lc = new LoanCalculator ();
                     calculateMonthlyAmount = new Button ("Compute Monthly Amount");
                     calculateMonthlyAmount.setOnAction (lc);
                     gridPane.add (loanAmt, 0, 0);
                     gridPane.add (amtField, 1, 0);
                     gridPane.add (loanPeriod, 0, 1);
                     gridPane.add (periodField, 1, 1);
                     gridPane.add (interestRate, 0, 2);
                     gridPane.add (interestRateField, 1, 2);
                     gridPane.add (calculateMonthlyAmount, 0, 3);
                     gridPane.add (monthlyAmount, 1, 3);
                     Scene scene = new Scene (gridPane, 600, 600);
                     primaryStage.setScene (scene);
                     primaryStage.show ();

				 }
private class LoanCalculator implements EventHandler<ActionEvent>
       {
		   public void handle (ActionEvent e)
		         {
					 double principal = Double.parseDouble (amtField.getText ());
					 double timePeriod = Double.parseDouble (periodField.getText ());
					 double interestRate = Double.parseDouble (interestRateField.getText ());
					 double amount = principal * Math. pow ((1 + interestRate / 100.0), timePeriod);
					 double monthlyPayment = amount / (timePeriod * 12);
					 monthlyAmount.setText (String.format ("$%.2f", monthlyPayment));

				 }
	   }
      }
