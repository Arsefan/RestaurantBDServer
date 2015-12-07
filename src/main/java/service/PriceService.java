package service;

import classes.Price;

import java.util.List;

/**
 * Created by Arsefan on 02.11.2015.
 */
public class PriceService extends Service{
    private static PriceService priceService;
    public static PriceService getInstance(){
        synchronized (priceService){
            if(priceService == null){
                priceService = new PriceService();
                return priceService;
            }else{
                return priceService;
            }
        }
    }
    public List<Price> getAllPricees(){
        try {
            db = openDB();
            List<Price> result = openDB().queryByExample(Price.class);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            db.close();
        }
    }
}
