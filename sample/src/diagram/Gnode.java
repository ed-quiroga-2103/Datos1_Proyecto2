package diagram;

public class Gnode {
    String type;
    Gnode next;


    public Gnode(String type){
        this. type=type;
    }
    public String gettype(){
        return type;
    }
    public Gnode getnext(){
        return next;
    }
}
