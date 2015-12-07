package classes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Arsefan on 24.10.2015.
 */
public class Price {
    private BigDecimal value;
    private LocalDate actualTo;
    private LocalDate actualFrom;

    private Price(){

    }
    public Price(BigDecimal value){
        this.value = value;
        this.actualFrom = LocalDate.now();
        this.actualTo = LocalDate.now().plusMonths(12);
    }
    public Price(BigDecimal value, LocalDate from, LocalDate to){
        this.value = value;
        this.actualFrom = from;
        this.actualTo = to;
    }
    //private LocalDate localDate
}
