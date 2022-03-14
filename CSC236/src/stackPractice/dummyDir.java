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
		String mainDir = "c:/zero";
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
			if (tmpF.isFile()) {
				// print file name can code here according to our need
				System.out.println(spaces.repeat(layer) + tmpF.getName()+"("+layer+")");
			}
			else if (tmpF.isDirectory()) {
				// It's an directory hence list and push all
				// files in stack
				System.out.println(spaces.repeat(layer) + tmpF.getName()+"(f)"+"("+layer+")");
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
			} 

			if(layerCount[layer]==0 ) {
				layer--;
				layerCount[layer]--;
				//System.out.println(layerCount.get(layer-1));

			}
			else {
				layerCount[layer]--;
				//System.out.println(layerCount.get(layer-1));

			}
		} 
	}
}