package stackPractice;

//Iterative Program to get all file names in Directory and SubDirectory

import java.io.File;


class dummyDir {
	public static void main(String[] args)
	{
		int layer = 0 ;
		int[] layerCount = new int[100];
		String spaces ="   ";
		// provide complete path for directory(to be changed accordingly)
		//String mainDir = "/zero";
		String mainDir = "C:/Users/TheRedBox/Videos/Anime Shows/";
		// File object
		File file = new File(mainDir);
		ArrayBoundedStack<File> stack = new ArrayBoundedStack<>();
		stack.push(file);

		// initially stack is not empty
		System.out.println("Content of Directory " + mainDir + " is");
		while (!stack.isEmpty()) {
			File tmpF = stack.top();
			stack.pop();
			// check if it is a file or not

			if (tmpF.isDirectory()) {
				// It's an directory hence list and push all
				// files in stack
				System.out.println(spaces.repeat(layer) + tmpF.getName());
				layer++;
				File[] f = tmpF.listFiles();
				//check if the folder is empty or not
				//to increase level if need or remain at the same level
				if(f.length!=0) {
					layerCount[layer]=f.length;
				}else {
					layer--;
				}
				for (File each : f) {
					stack.push(each);

				}
			} else  {
				// print file name can code here according to our need
				System.out.println(spaces.repeat(layer) + tmpF.getName());
			}

			if(layerCount[layer]<=0 ) {
				do {
					layer--;
					if(layer==0) {
						break;
					}
				}while(layerCount[layer]<=0 );
				layerCount[layer]--;
			}
			else {
				layerCount[layer]--;
			}
		} 
	}
}