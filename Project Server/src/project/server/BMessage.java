
package project.server;



public class BMessage {
    String msg ;
    String sendthis ;
    int id;

    public BMessage(String msg, int id) {

        this.id= id;
        this.msg= msg;

    }

    public String eligibiliity()
    {
        

        
        
            for(int i=0;i<ProjectServer.wtList.size();i++)
            {
                if(i==id-1) continue;
                
                    sendthis = msg + '\n';
                    ProjectServer.wtList.elementAt(i).outToClient2.print(sendthis);
                    ProjectServer.wtList.elementAt(i).outToClient2.flush();
                
            }
            return "Message has been broadcasted successfully..";
        }

    
}
