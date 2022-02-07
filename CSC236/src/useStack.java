import java.util.Scanner;
public class useStack {

	public static void main(String[] args) {
	
		ArrayBoundedStack<String> myStack = new ArrayBoundedStack<>(); //declare & instantiate an ArrayBoundedStack of String
		Scanner keyboard = new Scanner(System.in);//Create scanner item
		System.out.println("Insert a String"); //Ask for string
		
		String userInput = keyboard.nextLine(); //users input saved in userInput String
		
		while (!userInput.equals("end")){ //while loop that ends when "end" is input
			myStack.push(userInput);	//pushes userInput into the stack"myStack"
			System.out.println("Insert a String"); //prompts again for a new string
			userInput = keyboard.nextLine(); //overwrites userInput string with word inserted
		}
		
		while(!myStack.isEmpty()) { //runs while loop while myStack is not empty
			userInput =  myStack.top(); // userInput is overwritten with the top of the stack
			myStack.pop(); //pop removes the top the stack
			System.out.println(userInput); //prints out top word
		}
		

	}
	
}
