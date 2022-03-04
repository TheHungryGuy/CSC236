package stackPractice;

public class MyList {
	
	LLNode<String> head;
	
	
	public void head() {
		head = null;
	}
	
	public void createList(String parm) {
		LLNode<String>newnode;
		newnode = new LLNode <String>(parm);
		head = newnode;
		
	}
	
	public String toString() {
		LLNode<String> curr = head;
		String str="";
		while(curr != null) {
			
			str+="\nWord: " +curr.getInfo();
			curr = curr.getLink();
				
			}
		
		//str+="Word: " +head.getInfo();
		
		return str;
		
	}
	public void addAtFront(String newstr) {
		LLNode<String>newnode;
		newnode = new LLNode<String>(newstr);
		newnode.setLink(head);
		head = newnode;
	}
	public boolean contains(String item) {
		boolean found = false;
		LLNode<String> curr = head;
		while(curr != null) {
			if(curr.getInfo().equals(item)) {
				found = true;
				break;
			}else {
				curr =curr.getLink();
			}
			

		}
		if(found) {
			System.out.println("Word Found!");
		}else {
			System.out.println("Word Not Found!");
		}
		return found;
		
	}

	
	
}
