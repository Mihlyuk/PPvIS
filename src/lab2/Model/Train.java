package lab2.Model;

import java.util.Date;

/**
 * Created by Константин on 13.03.2016.
 */
public class Train {
    public String number;
    public String stationArriving;
    public String stationDeparting;
    public Date dateArriving;
    public Date dateDeparting;
    public Date travelTime;

    public Train(String number, String stationArriving, String stationDeparting,
                 Date dataArriving, Date dateDeparting, Date travelTime) {
        this.number = number;
        this.stationArriving = stationArriving;
        this.stationDeparting = stationDeparting;
        this.dateArriving = dataArriving;
        this.dateDeparting = dateDeparting;
        this.travelTime = travelTime;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;

     /* obj ссылается на null */

        if (obj == null)
            return false;

     /* Удостоверимся, что ссылки имеют тот же самый тип */

        if (!(getClass() == obj.getClass()))
            return false;
        else {
            Train tmp = (Train) obj;
            if (this.number.equals(tmp.number) &&
                    this.stationArriving.equals(tmp.stationArriving) &&
                    this.stationDeparting.equals(tmp.stationDeparting) &&
                    this.dateArriving.equals(tmp.dateArriving) &&
                    this.dateDeparting.equals(tmp.dateDeparting) &&
                    this.travelTime.equals(tmp.travelTime)) {
                return true;
            } else
                return false;
        }
    }
}
