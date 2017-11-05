
public class Node {
	
	String key;
	
	

	String arg;
	
	Node next;
	
	Node(String key, String arg){
		
		this.arg = arg;
		
		this.key = key;
		
		this.next = null;
	}
	Node(String key){
		
		this.arg = null;
		
		this.key = key;
		
		this.next = null;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getArg() {
		return arg;
	}

	public void setArg(String arg) {
		this.arg = arg;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}
