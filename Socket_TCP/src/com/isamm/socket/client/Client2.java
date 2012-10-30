package com.isamm.socket.client;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	private static InetAddress host;
    private static final int PORT = 1234;

    
    

    public static void main(String[] args) throws IOException
    {
        try
        {
            host = InetAddress.getLocalHost();
        }
        catch(UnknownHostException uhEx)
        {
            System.out.println("Host ID not found!");
            System.exit(1);
        }
        
 

         accessServer();

				
		   
    }

    private static void accessServer() throws IOException
    {
        Socket link = null;      //Step 1.
      
		        try
		        {
		            link = new Socket(host,PORT); //Step 1.
		
		            Scanner input = new Scanner(link.getInputStream());//Step 2.
		
		            PrintWriter output =
		                new PrintWriter(link.getOutputStream(),true);//Step 2.
		
		            String message, response;
		            
		            //Set up stream for keyboard entry...
		         //  Scanner userEntry = new Scanner(System.in);
		
		            Scanner scanner=new Scanner(new File("french2.txt"));

		         // On boucle sur chaque champ detecté
		         while (scanner.hasNextLine()) {
		            
		             message = scanner.nextLine();
		                output.println(message);        //Step 3.
		                response = input.nextLine();    //Step 3.
		                System.out.println("\nSERVER> " + response);
		            
		         }

		        }
		        catch(IOException ioEx)
		        {
		            ioEx.printStackTrace();
		        }
		

       
      
            try
            {
                System.out.println("\n* Closing connection... *");
                link.close();                    //Step 4.
            }
            catch(IOException ioEx)
            {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
   
}
