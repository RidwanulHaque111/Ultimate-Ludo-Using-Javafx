
package termproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TermProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        ///main menu scene
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene mainmenuscene = new Scene(root);
        stage.setHeight(800);
        stage.setWidth(1330);
        stage.setScene(mainmenuscene);
        //stage.setFullScreen(true);
        stage.show();
                
        
    }

    
    public static void main(String[] args) throws IOException {
        
        launch(args);
        //////////DEBUG///////
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

        
        ////////DEBUG //////////
        
        
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
    @Override
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

