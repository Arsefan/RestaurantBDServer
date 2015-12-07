package classes;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Arsefan on 24.10.2015.
 */
public class Good {
    //private QMap<>price;
    private String name;
    private String url;
    private String description;
    private List<Price> priceList;
    //private TypeOfGood type;

    public Good(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        if(priceList.isEmpty()){
            return null;
        }else{
            return priceList.get(priceList.size()-1);
        }
    }

    public void setPrice(Price price) {
        priceList.add(price);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }

    @Override
    public boolean equals(Object obj) {
        //not ready
        return super.equals(obj);
    }
}
