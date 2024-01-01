


package project.server;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class ProjectServer
{
    String clientSentence;
    String capitalizedSentence;
    ServerSocket welcomeSocket = null ;
    Socket connectionSocket = null ;
    int workerThreadCount, id;
    static Vector<String> username ;
    static Vector<String> pw ;
    static Vector<String> type ;
    static Vector<WorkerThread> wtList ;



    public ProjectServer()
    {
         workerThreadCount = 0;
         id=1;
         wtList = new Vector<>();
         System.out.println("Waiting for client...");


        try {

            welcomeSocket = new ServerSocket(7777);
        }
        catch (IOException ioe)
        {
            System.out.println(ioe);
        }

        while(true) ///while loop for multiple clients
        {
            try
            {
                connectionSocket = welcomeSocket.accept();
                System.out.printf("Client %d has been accepted\n",id);
            }
            catch (IOException ioe)
            {
                System.out.println(ioe);
                break;
            }

            WorkerThread wt = new WorkerThread(connectionSocket, id);
            wtList.add(wt);
            Thread t = new Thread(wt);


            t.start();
            workerThreadCount++;
            System.out.println("Client [" + id + "] is now connected. No. of worker threads = " + workerThreadCount);
            id++;
        }
    }



    public static void main(String argv[]) throws Exception
    {
	    	new ProjectServer();
    } 
}


