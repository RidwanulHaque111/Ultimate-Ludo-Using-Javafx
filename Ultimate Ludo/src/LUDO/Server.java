/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LUDO;

import java.io.*;
import java.net.*;


public class Server {
    
    public static void main(String argv[]) throws Exception
    {
	int workerThreadCount = 0;
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        int id=1;
        while(true)
        {
            Socket connectionSocket = welcomeSocket.accept();
            WorkerThread wt = new WorkerThread(connectionSocket, id);
            Thread t = new Thread(wt);
            t.start();
            workerThreadCount++;
            System.out.println("Client [" + id + "] is now connected. No. of worker threads = " + workerThreadCount);
            id++;
        }		
    } 
}
class WorkerThread implements Runnable
{
    private Socket connectionSocket;
    private int id = 0;
    public WorkerThread(Socket s, int id)
    {
        this.connectionSocket = s;
		this.id = id;
    }
    public void run()
    {
        while(true)
        {
            String clientSentence;
            String capitalizedSentence;
            try
            {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                PrintWriter outToClient2 = new PrintWriter(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                outToClient2.print(capitalizedSentence);
				outToClient2.flush();
            }
            catch(Exception e)
            {

            }		
        }		
    }
}
