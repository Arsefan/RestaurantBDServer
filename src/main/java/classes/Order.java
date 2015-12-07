package classes;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by Arsefan on 24.10.2015.
 */
public class Order {
    //private static long count = 0;
    //private final long id;
    private Map<Good, Integer> goods;
    private Date timeOfCreate;
    private Date timeOfRelease;
    private boolean done;
    private BigDecimal sumPrice;



    public Order(){
       // this.id = clientNumber*timeOfCreate.toString()
        this.goods = new LinkedHashMap<Good, Integer>();
    }
    public Order(LinkedHashMap<Good, Integer>goods){
        this.goods = goods;
    }
    public boolean addGood(@NotNull Good good){
        return addGood(good , new Integer(1));
    }
    public boolean addGood(@NotNull Good good, Integer count){

        if(goods.isEmpty()){
            goods.put(good, count);
            return  true;
        }else{
            int goodsCount = 0;
            for (Good g: goods.keySet()){
                if(g.equals(good)){
                   goodsCount = goods.get(good).intValue();
                    goodsCount+= count.intValue();
                   goods.replace(good, goodsCount);
                    return true;
                }
            }
            goods.put(good, count);

            return true;

        }
    }
//    public boolean removeLastGood(){
//        if(goods.isEmpty()){
//            return true;
//        }else{
//            return goods.remove())
//        }
//
//    }

}
