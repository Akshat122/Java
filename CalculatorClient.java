import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
public class CalculatorClient
	{
		public static void main(String [] args)
			{
				try
				{
					final int PORT_NUM =10001;
					Socket socket = new Socket("localhost",PORT_NUM);
					InputStream is = socket.getInputStream();
					OutputStream os = socket.getOutputStream();
					Scanner in = new Scanner(is);
					Scanner kdb = new Scanner (System.in);
					PrintWriter out = new PrintWriter(os);
					String command = "",response = "";
					while(true)//user keeps giving commands
						{
							System.out.println("Enter a command (like \"2 + 3 \" or \" quit \" to end ");
							command = kdb.nextLine();
							out.println(command);//if user typr "quit" server will say "bye"
							out.flush();// sends the command to the server
							if (in.hasNextLine())
								{
									response =in.nextLine();
									if (response.equalsIgnoreCase("bye"))
										{
											System.out.println(response);
											response="";
											break;
										}
									else
										{
											System.out.println(response);
											response="";
											continue;
										}
								}
							else
								{
								System.out.println("No response from the server... please try again!..");
								}
						}
					socket.close();
				}
				catch(IOException ioe)
				{
				System.out.println(ioe.getMessage());
				}
			}
	}
