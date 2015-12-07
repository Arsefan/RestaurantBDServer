package service;

import classes.Good;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.ObjectSet;
import com.db4o.cs.Db4oClientServer;
import com.db4o.query.Predicate;
import com.sun.istack.internal.NotNull;
import service.serviceImplements.ServiceInterface;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Arsefan on 25.10.2015.
 */
public class GoodsService extends Service{
   // private ObjectContainer db;
    private static GoodsService goodsService;
    public GoodsService(){


    }
    public static GoodsService getInstance(){
        synchronized (goodsService){
            if(goodsService == null){
                goodsService = new GoodsService();
                return goodsService;
            }else{
                return goodsService;
            }
        }
    }
    public List<Good> getAllGoods(){
        try {
            db = openDB();
            List<Good> result = openDB().queryByExample(Good.class);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            db.close();
        }
    }
    public boolean addGoods(@NotNull Good good){
        if(good != null) {
            try {
                db = openDB();
                db.store(good);
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
    public List<Good> getGood(@NotNull Good good){
        if(good != null) {
            try {
                db = openDB();
                ObjectSet result = db.queryByExample(good);
                return (List<Good>)result;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                db.close();
            }
        }
        return null;
    }
    public Good getGooodByName(String name){
        Good good = new Good(name);
        try {
            db = openDB();
            ObjectSet result = db.queryByExample(good);
            return (Good)result.next();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            db.close();
        }
    }
    public List<Good> getGoogByPrice(final BigDecimal price){
        try {
            db = openDB();
            List<Good> result = db.query(new Predicate<Good>() {
                @Override
                public boolean match(Good good) {
                    return good.getPrice().equals(price);
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
    public boolean deleteGood(Good good){
        try {
            db = openDB();
            db.delete(good);
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
