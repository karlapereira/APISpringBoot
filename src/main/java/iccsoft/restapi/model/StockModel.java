package iccsoft.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity (name = "stock")
public class StockModel {

    @Id
    public String stock_name;

    @Column(nullable = false, length = 10)
    public float quotes[] = new float[10];


    public String getStockName() {
        return stock_name;
    }

    public void setStockName(String stockName) {
        this.stock_name = stockName;
    }

    public float[] getQuotes() {
        return quotes;
    }

    public void setQuotes(float[] quotes) {
        this.quotes = quotes;
    }
}
