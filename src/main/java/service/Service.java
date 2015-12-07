package service;

import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import settings.Settings;

/**
 * Created by Arsefan on 04.11.2015.
 */
public class Service{
    public ObjectContainer db;
//    private static Service service;
//    private String host;
//    private int port;

    public Service() {
        db = null;
    }
    protected ObjectContainer openDB()throws Exception{
        db = Db4oClientServer.openClient(Settings.HOST, Settings.PORT, Settings.LOGIN, Settings.PASSWORD);
        return db;
    }
}
