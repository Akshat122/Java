import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
public class CalculatorServer
	{
		public static void main(String [] args)
			{
				try 
					{
						final int PORT_NUM = 10001;
						ServerSocket serverSocket = new ServerSocket(PORT_NUM);
						Socket socket;
						
						Thread thread;
						CalculatorService service;
						while (true)
							{
								System.out.println("Waiting for clients to connect.... ");
								socket = serverSocket.accept();
								System.out.println("New Client connected.....");
								service = new CalculatorService (socket);
								thread = new Thread (service);
								thread.start(); 
							}
					}
				catch(IOException ioe)
				{
				System.out.println(ioe.getMessage());
				}		
			}
	}
class CalculatorService implements Runnable
	{
		Socket socket;
		InputStream is;
		OutputStream os;
		PrintWriter out;
		Scanner in;
		String command = "" , response = "";
		public CalculatorService (Socket fromServer)
			{
		 		socket = fromServer;
			}
		public void run ()
			{
				try
				{
					try
					{
						is = socket.getInputStream();
						os = socket.getOutputStream();
						out = new PrintWriter(os);
						in = new Scanner(is);
						if (in.hasNextLine())
							{
								command = in.nextLine();
							}
						processCommand();
					}	
					finally
					{
						socket.close();
					}
				}
				catch (IOException ioe)
				{
					System.out.println(ioe.getMessage());
				}	
			}
		public void processCommand()
			{
				while(true)
					{
						if (command.equalsIgnoreCase("quit"))
						{
							response = "Bye";
							out.println(response);
							out.flush();
							response = "";
							command = "";
							return ;
						}
						else
						{
							String pieces [] = command.split("[ ]+");//any number of spaces 
							int value1 =Integer.parseInt(pieces [0]),
							    value2 =Integer.parseInt(pieces [2]);
							char operator = pieces[1].trim().charAt(0);
							switch (operator)
								{
								
									case '+' : response = " "+ (value1 + value2);break;
									case '-' : response = " "+ (value1 - value2);break;
									case '*' : response = " "+ (value1 * value2);break;
									case '/' : response = " "+ (value1 / value2);break;
									default  : response = "Bad operator";break;
								}
							out.println(response);
							out.flush();
							if(in.hasNextLine())
								{
									command = in.nextLine();
								}
						}
					}//end while
			}
	}
