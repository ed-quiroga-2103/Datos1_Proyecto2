package diagram;

public class Glist {
    int lenght;
    Gnode root;
    Gnode last;

    public void add(String type){
        Gnode first=new Gnode(type);
        if(root==null){
            root=first;
            last=first;
        }else{
            last.next=first;
            last=first;
        }
    }
    public void display(){
        Gnode current=root;
        for(int i=0;i<lenght;i++){
            System.out.println(current.type);
            current=current.getnext();
        }
    }
    public void draw(){
    for(int i=0;i==lenght;i++){

    }
    }
}
