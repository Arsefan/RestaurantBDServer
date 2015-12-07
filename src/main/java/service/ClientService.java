package service;

import classes.Client;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import com.sun.istack.internal.NotNull;
import service.serviceImplements.ServiceInterface;

import java.util.List;

/**
 * Created by Arsefan on 27.10.2015.
 */
public class ClientService extends Service{
    private static ClientService clientService;
    private String host;
    private String port;

    private ClientService(){

    }
    public static ClientService getInstance(){
        synchronized (clientService){
            if(clientService == null){
                clientService = new ClientService();
                return clientService;
            }else{
                return clientService;
            }
        }
    }

    public boolean addClient(@NotNull Client client){
        if(client != null) {
            try {
                db = openDB();
                db.store(client);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            } finally {
                db.close();
            }
        }
        return false;
    }
    public List<Client> getClientByLogin(final String login){
        try {
            db = openDB();
            List<Client> result = db.query(new Predicate<Client>() {
                @Override
                public boolean match(Client client) {
                    return client.getLogin().equals(login);
                }
            });
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            db.close();
        }
    }
    public List<Client> getClientByTable(final int tableN){
        try {
            db = openDB();
            List<Client> result = db.query(new Predicate<Client>() {
                @Override
                public boolean match(Client client) {
                    return client.getTableNumber() == tableN;
                }
            });
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            db.close();
        }
    }
    public boolean deleteClient(Client client){
        try {
            db = openDB();
            db.delete(client);
        }catch (Exception e){
            e.printStackTrace();
            db.close();
            return false;
        }finally {
            db.close();
        }
        return true;
    }

}
