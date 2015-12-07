package serverThread;

import classes.Client;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Arsefan on 06.12.2015.
 */
public class ServerThread extends Thread {
    private List<Client> usersGrantAccess= new ArrayList<Client>();
    private ObjectServer server;
    private ObjectContainer admin;
    public void run() {
        synchronized (this){

            //server.grantAccess("adminLogin", "adminPass");
            //ObjectContainer admin = server.openClient("localhost", 1234567, "adminLogin", "adminPass");
           // ObjectContainer admin = server.openClient();
//            List<Client> clientList = admin.queryByExample(Client.class);
//            for(Client c: clientList){
//                server.grantAccess(c.getLogin(),c.getPassword());
//            }
            try {
                server = Db4oClientServer.openServer("./restaurantData.db", 12345);
                updateGrantAccess();
//                while (true){
                System.out.println("server start");
//                }
            }catch (Exception e){
                e.printStackTrace();
                server.close();
                System.out.println("server stop in finally");
            }finally {
                System.out.println("in finally thread");
            }
        }
    }

    public List<Client> getUsersGrantAccess() {
        return usersGrantAccess;
    }

    public void setUsersGrantAccess(List<Client> usersGrantAccess) {
        this.usersGrantAccess = usersGrantAccess;
        updateGrantAccess();
    }

    public void stopServer(){
        if(server == null)
            return;
        server.close();
        System.out.println("server stop");
    }
    private void updateGrantAccess(){
        if(usersGrantAccess.isEmpty() || usersGrantAccess == null)
            return;
        for (Client c: usersGrantAccess){
            server.grantAccess(c.getLogin(), c.getPassword());
        }
    }

    public ObjectServer getServer() {
        return server;
    }
}
