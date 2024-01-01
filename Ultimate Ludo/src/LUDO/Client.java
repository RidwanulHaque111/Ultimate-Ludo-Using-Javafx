/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LUDO;

import java.io.*; 
import java.net.*; 

public class Client {
     
     private String sentence;
     private String serverMsg;
     private Socket s;
     private BufferedReader inFromServer;
     private PrintWriter outToServer ;
     private BufferedReader inFromUser ;

     
     
     public Client() throws IOException
     {
         
         s = new Socket("localhost",7777);
         System.out.println("connected");
         inFromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
         outToServer = new PrintWriter(s.getOutputStream(), true);
         inFromUser = new BufferedReader(new InputStreamReader(System.in));
                
         
     }
     
     public void send(String s)
     {
        outToServer.println(s);
        outToServer.flush();
     }
     
     public String receive() throws IOException
    {
        return inFromServer.readLine();
    }
     
}
