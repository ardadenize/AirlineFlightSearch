package AirlineFlightSearch1;

import java.time.LocalDateTime;
import java.util.Random;


public class Information {
    Random rnd=new Random();
    public LocalDateTime date;
    public Double price;
    public String fromcity;
    public String tocity;
    public String carrier;
    public int code;
    public Information(LocalDateTime date, String fromcity, String tocity, String carrier, Double price){
        this.date=date;
        this.fromcity=fromcity;
        this.tocity=tocity;
        this.carrier=carrier;
        this.price=price;
        this.code=rnd.nextInt(999999999);
    }

    public Double getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getFromcity() {
        return fromcity;
    }

    public String getTocity() {
        return tocity;
    }

    public String getCarrier() {
        return carrier;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "  " + "code "+ code+
                "  date=" + date +
                ", price=" + price +
                ", fromcity='" + fromcity + '\'' +
                ", tocity='" + tocity + '\'' +
                ", carrier='" + carrier + '\'';
    }
}
