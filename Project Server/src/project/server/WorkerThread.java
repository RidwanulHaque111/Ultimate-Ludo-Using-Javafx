
package project.server;

import java.io.*;
import java.net.Socket;

class WorkerThread implements Runnable
{
    private Socket connectionSocket;
    private int id;
    private int FileSerial;
    private boolean isLoggedIn = false;
    BufferedReader inFromClient = null;
    PrintWriter outToClient2 = null;
    private String player_number;
    private int max_players = 4;

    public WorkerThread(Socket connectionSocket, int id) {
        this.connectionSocket = connectionSocket;
        this.id = id;
    }

    public boolean getLogINStatus()
    {
        return isLoggedIn ;
    }
    public void setLogINStatus(boolean x)
    {
        isLoggedIn = x;
    }
    public int getFileSerial() { return FileSerial; }
    public void setFileSerial(int x) { FileSerial =x; }


    public void run()
    {
        while(true) ///while loop for multiple messages of a single clients
        {
            String clientMsg, serverMsg = null;
            String capitalizedSentence;

            try
            {
                inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                outToClient2 = new PrintWriter(connectionSocket.getOutputStream());
                clientMsg = inFromClient.readLine();
                
                if(clientMsg.equals("getID"))
                {
                    //sending player_number
                    outToClient2.println(String.valueOf(id));
                    outToClient2.flush();
                }else{
                    BMessage bmessage = new BMessage(clientMsg, id);
                    serverMsg = bmessage.eligibiliity() + "\n";
//                    outToClient2.print(serverMsg);
//                    outToClient2.flush();
                }
                
            }

            catch (IOException ioe)
            {
                System.out.println(ioe);
            }

        
//        try{
//            inFromClient.close();
//            outToClient2.close();
//            connectionSocket.close();
//        }catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }
        
        }
    
    }
}