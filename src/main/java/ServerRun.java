import classes.Client;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import service.OrderService;

import java.util.List;

/**
 * Created by Arsefan on 01.11.2015.
 */
public class ServerRun implements Runnable {
    private ObjectServer server;
    public void run() {
        synchronized (this){
            server = Db4oClientServer.openServer("/restaurantDB.yap", 1234567);
            //server.grantAccess("adminLogin", "adminPass");
            //ObjectContainer admin = server.openClient("localhost", 1234567, "adminLogin", "adminPass");
            ObjectContainer admin = server.openClient();
            List<Client> clientList = admin.queryByExample(Client.class);
            for(Client c: clientList){
                server.grantAccess(c.getLogin(),c.getPassword());
            }
            try {
//                while (true){
                System.out.println("server start");
//                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                server.close();
                System.out.println("server stop in finally");
            }
        }
    }
    public void stopServer(){
        server.close();
        System.out.println("server stop");
    }
}
