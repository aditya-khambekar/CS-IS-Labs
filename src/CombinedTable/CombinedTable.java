package CombinedTable;

public class CombinedTable extends SingleTable{
    SingleTable t1, t2;
    public CombinedTable(SingleTable t1, SingleTable t2){
        this.t1 = t1;
        this.t2 = t2;
    }

    public Boolean canSeat(int seats){
        return seats<=(t1.getNumSeats()+t2.getNumSeats())-2;
    }

    public Double getDesirability(){
        int deficit = 0;
        if(t1.getHeight()!=t2.getHeight()){
            deficit = 10;
        }

        return ((t1.getViewQuality()+t2.getViewQuality())/2.0)-deficit;
    }

}
