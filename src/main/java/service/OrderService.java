package service;

import classes.Client;
import classes.Order;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by Arsefan on 02.11.2015.
 */
public class OrderService extends Service{
    private static OrderService orderService;

    public TreeSet<Order> getOrderByClient(Client client){
        try {
            db = openDB();
            TreeSet<Order> result = ((Client)(openDB().queryByExample(client).next())).getOrders();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            db.close();
        }

    }
    public static OrderService getInstance(){
        synchronized (orderService){
            if(orderService == null){
                orderService = new OrderService();
                return orderService;
            }else{
                return orderService;
            }
        }
    }
    public List<Order> getAllGoods(){
        try {
            db = openDB();
            List<Order> result = openDB().queryByExample(Order.class);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            db.close();
        }
    }
}
