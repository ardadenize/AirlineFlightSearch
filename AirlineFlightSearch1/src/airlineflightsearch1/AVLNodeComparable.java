package AirlineFlightSearch1;

public class AVLNodeComparable<Key extends Comparable<Key>,Value> {
    public final Key key;
    public Value val;
    public int height;
    public int size;
    public AVLNodeComparable<Key,Value> left;
    public AVLNodeComparable<Key,Value> right;

    public AVLNodeComparable(Key key, Value val,int height, int size){
        this.key=key;
        this.val=val;
        this.size=size;
        this.height=height;
    }

    @Override
    public String toString() {
        return "Flight =" + val ;
    }
}