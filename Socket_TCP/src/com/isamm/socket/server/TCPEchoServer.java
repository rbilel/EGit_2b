package com.isamm.socket.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class TCPEchoServer {
	private static ServerSocket servSock;
    private static final int PORT = 12345;

    public static void main(String[] args)
    {
        System.out.println("Opening port...\n");
        try
        {
            servSock = new ServerSocket(PORT);      //Step 1.
        }
        catch(IOException ioEx)
        {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
        do
        {
            handleClient();
        }
        while (true);
    }

    public static void WriteInFile(String msg){
    	
    	String nomfichier="f1.txt";
    	try {
			File f = new File(nomfichier);
			f.createNewFile();
			FileWriter fw = new FileWriter(f,true);
			fw.write("\n"+ msg + "\n \r");
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    	
    	
    }
    
    
    
    
    private static void handleClient()
    {
        Socket link = null;                     			//Step 2.
        try
        {
            link = servSock.accept();        				//Step 2.

            Scanner input = new Scanner(link.getInputStream()); 	//Step 3.
            PrintWriter output =
		    new PrintWriter(link.getOutputStream(),true); 	//Step 3.

            int numMessages = 0;
            String message = input.nextLine();      			//Step 4.
            
           
            while (!message.equals("***CLOSE***"))
            {
                System.out.println("Message received.");
                System.out.println(message);
                WriteInFile(message);
                numMessages++;
                output.println("Message " +
		        numMessages + ": " + message);   		//Step 4.
                message = input.nextLine();
            }
            output.println(numMessages + " messages received."); 	//Step 4.
        }
        catch(IOException ioEx)
        {
            ioEx.printStackTrace();
        }
        finally
        {
            try
            {
                System.out.println( "\n* Closing connection... *");
                link.close();                    //Step 5.
            }
            catch(IOException ioEx)
            {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}
