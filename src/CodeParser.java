import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CodeParser {

	LinkedList KeyWords = new LinkedList();

	LinkedList charArray = new LinkedList();

	LinkedList finalList = new LinkedList();
	
	File test;
	
	List wordList = new List();

	int line = 0;
	
	CodeParser(String filename) {

		this.test = new File(System.getProperty("user.dir") + "/TestFolder/" + filename);

	}

	public static void main(String[] args) throws IOException {

		
		
	}

	public void parse() throws IOException {
		this.KeyWords = new LinkedList();

		this.charArray = new LinkedList();

		int ind = 0;

		if (this.test.exists()) {

			while (true) {

				try {
					String content = Files.readAllLines(this.test.toPath()).get(ind);

					this.KeyWords.newNode(content);

					char[] prent = content.toCharArray();

					for (int i = 0; i < prent.length; i++) {

						charArray.newNode(Character.toString(prent[i]));

					}

					ind++;

				} catch (Exception e) {

					System.out.println("Read");
					System.out.println();
					return;

				}

			}

		}

	}

	public void read() throws IOException {

		this.parse();

		for (int i = 0; i < this.KeyWords.getLength(); i++) {

			System.out.println(this.KeyWords.getNode(i).getKey());

		}
		return;
	}

	public void readline() throws IOException {
		
		this.parse();

		System.out.println(this.KeyWords.getNode(line).getKey());

		this.line++;

	}

	public void analizeText() throws IOException {
		this.parse();

		String currentLine;
		int ind = -1;


		for (int i = 0; i < this.KeyWords.getLength(); i++) {

			boolean checked = false;
			
			
			String word = "";

			currentLine = this.eraseBlanks(this.KeyWords.getNode(i).getKey());


			String[] a = currentLine.split("");
			
			
			
			for (int j = 0; j < a.length; j++) {
				
				if(!a[j].equals("{") & !a[j].equals("}")){

					word = word + a[j];
					
					}

				if (word.equals("if") & !checked) {
					checked = true;
					word = "";
					
					ind++;
					this.finalList.newNode("if");
				}
				if (word.equals("while")& !checked) {
					checked = true;
					word = "";
					
					ind++;
					this.finalList.newNode("while");

				}
				if (word.equals("for")& !checked) {
					checked = true;
					word = "";

					ind++;
					this.finalList.newNode("for");

				}
				if (word.equals("return")& !checked){
					checked = true;
					word = "";

					ind++;
					this.finalList.newNode("return");

				}
			}
			if(!checked){
				this.finalList.newNode("line", word);
				ind++;
			}
			if(checked){
				
				this.finalList.getNode(ind).setArg(word);
			}
		}
	this.blankLine();
	}

	public String eraseBlanks(String string) {

		String[] a = string.split("");
		String b = "";
		boolean erased = true;


		for (int i = 0; i < a.length; i++) {

			if (a[i].equals(" ") & erased) {}
			else {
				if (a[i].equals("\u0009")) {}
				
				else{
				b = b + a[i];
				
				erased = false;
				}
			}

			

		}
		return b;
	}

	public void blankLine(){
			
		int ind = 0;
		
		boolean checked = true;
		
		String current;
		
		while(checked){
						
			checked = false;
			
			for(int i = 0; i < this.finalList.getLength(); i++){
				
				current = this.finalList.getNode(i-ind).getArg();
				
				
				if(current.trim().isEmpty() || current.trim().length() < 1){
					
					checked = true;
					
					this.finalList.deleteNode(i-ind);
					
					ind++;
					
				}
				
			}
			ind=0;
			
			
		}
		
	}
}


