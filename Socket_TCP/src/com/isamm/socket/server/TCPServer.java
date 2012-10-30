package com.isamm.socket.server;

import java.net.*; 
import java.io.*; 

public class TCPServer extends Thread
{ 
 protected Socket clientSocket;

 private static int i = 0;

 public static void main(String[] args) throws IOException 
   { 
    ServerSocket serverSocket = null; 
   

    try { 
         serverSocket = new ServerSocket(1234); 
         System.out.println ("Connection Socket Created");
         try { 
              while (true)
                 {
                  System.out.println ("Waiting for Connection");
                  new TCPServer (serverSocket.accept()); 
                 }
             } 
         catch (IOException e) 
             { 
              System.err.println("Accept failed."); 
              System.exit(1); 
             } 
        } 
    catch (IOException e) 
        { 
         System.err.println("Could not listen on port: 1234."); 
         System.exit(1); 
        } 
    finally
        {
         try {
              serverSocket.close(); 
             }
         catch (IOException e)
             { 
              System.err.println("Could not close port: 1234."); 
              System.exit(1); 
             } 
        }
   }

 private TCPServer (Socket clientSoc)
   {
    clientSocket = clientSoc;
    
    start();
   }

 public static void WriteInFile(String msg){
 	
	 
	
 	String nomfichier="f"+i+".txt";
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
 
 
 
 
 
 public void run()
   {
    System.out.println ("New Communication Thread Started");

    try { 
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                                      true); 
         BufferedReader in = new BufferedReader( 
                 new InputStreamReader( clientSocket.getInputStream())); 

         String inputLine; 

         while ((inputLine = in.readLine()) != null) 
             { 
              System.out.println ("Server: " + inputLine); 
              //ecrire ds le fichier
              WriteInFile(inputLine);
             
              out.println(inputLine); 

              if (inputLine.equals("Bye.")) 
                  break; 
             } 

         out.close(); 
         in.close(); 
         i++;
         clientSocket.close(); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Problem with Communication Server");
         System.exit(1); 
        } 
    }
} 