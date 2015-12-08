import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.config.annotations.reflect.Db4oConfiguratorFactory;
import com.db4o.cs.Db4oClientServer;
import forms.AdminWindow;
import forms.MainWindows;
import serverThread.ServerThread;
import sun.rmi.server.Util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arsefan on 01.11.2015.
 */
public class Main {
    private static ServerThread serverThread = new ServerThread();
    static MainWindows mainWindows = new MainWindows();
    static private AdminWindow adminWindow = new AdminWindow();
    public static void main(String[] args) {


        try {
          serverThread.start();
//            System.out.println("server start");
//            }
        }catch (Exception e){
            e.printStackTrace();
            serverThread.stopServer();
        }finally {
            System.out.println("mail finally");
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                mainWindows.setPreferredSize(new Dimension(500, 500));
                adminWindow.setSize(new Dimension(500, 500));
                adminWindow.setVisible(true);
            }
        });
    }
    public static ObjectContainer openDB(String name){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), name);

//        ObjectServer server = Db4oClientServer.openServer(filename, serverPort);
//        server.grantAccess("serverUser","serverPassword");
//        try
//        {
//            ObjectContainer client = Db4oClientServer.openClient("localhost", serverPort,
//                    serverUser, serverPassword);
//            // работаем с ООБД
//            client.close();
//        }
//        finally
//        {
//            server.Close();
//        }

        return db;
    }
}
