package classes;

import classes.Order;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Arsefan on 24.10.2015.
 */
public class Client {
//    private static long count = 0;
//    private final long id;
    private int tableNumber;
    //private Order currentOrder;
    private TreeSet<Order> orders;
    private String login;
    private String password;


//    private Client(){
//        this.id = count++;
//    }
    public Client(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public TreeSet<Order> getOrders() {
        return orders;
    }

    public void setOrders(TreeSet<Order> orders) {
        this.orders = orders;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public Order getLastOrder(){
        if(orders.isEmpty()){
            return null;
        }else{
            return orders.last();
        }
    }
}
