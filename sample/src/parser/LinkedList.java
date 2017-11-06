package parser;

public class LinkedList {

    Node root;
    int length;

    LinkedList(){}

    public static void main(String[] args){

    }

    public void newNode(String key, String arg){

        this.addNode(new Node(key, arg));

    }
    public void newNode(String arg){

        this.addNode(new Node(arg));

    }

    public void addNode(Node newNode){

        if(this.root==null){

            this.root = newNode;
            this.root.setNext(null);
            this.length++;

        }else{

            Node current = this.root;

            while(current.getNext() != null){

                current = current.getNext();

            }

            current.setNext(newNode);
            current.getNext().setNext(null);

            this.length++;

        }
    }

    public Node getNode(int ind){

        int cont = 0;
        Node current = this.root;

        while(cont != ind){

            current = current.getNext();

            cont++;

        }

        return current;

    }

    public void deleteNode(int ind){

        int cont = 0;
        Node current = this.root;

        if(ind == 0 ){

            this.root= this.root.getNext();

            this.length--;


            return;
        }

        while(cont != ind-1){

            current = current.getNext();

            cont++;

        }

        current.setNext(current.getNext().getNext());

        this.length--;

        return;
    }

    public void deleteNode(String arg){

        Node current = this.root;

        if(this.root.getArg().equals(arg)){

            this.root= this.root.getNext();

            return;

        }

        while(!current.getNext().getArg().equals(arg)){

            current = current.getNext();

        }


        current.setNext(current.getNext().getNext());

        return;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }



}
