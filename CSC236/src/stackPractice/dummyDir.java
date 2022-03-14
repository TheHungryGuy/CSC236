package stackPractice;

//Iterative Program to get all file names in Directory and SubDirectory

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

class dummyDir {
	public static void main(String[] args)
	{


		int layer = 0 ;
		int[] layerCount = new int[100];

		// provide complete path for directory(to be changed accordingly)
		String mainDir = "c:/zero";
		// File object
		File file = new File(mainDir);
		Stack<File> stack = new Stack<>();
		stack.push(file);

		// initially stack is not empty
		System.out.println("Content of Directory " + mainDir
				+ " is");
		while (!stack.empty()) {
			File tmpF = stack.pop();

			// check if it is a file or not
			if (tmpF.isFile()) {
				// print file name can code here according
				// to our need
				System.out.println(tmpF.getName()+"("+layer+")");
				//System.out.println(layerCount.get(layer-1)+" Layer:"+layer);
			}

			else if (tmpF.isDirectory()) {
				// It's an directory hence list and push all
				// files in stack

				//layerCount=1;
				System.out.println(tmpF.getName()+"(f)"+"("+layer+")");


				layer++;
				File[] f = tmpF.listFiles();
				if(f.length!=0) {
					layerCount[layer]=f.length;
					//layerCount.add(f.length+0);
					//System.out.println(layerCount.get(layer-1)+" Layer:"+layer);

					//layerCount++;
				}else {
					layer--;
				}
				for (File fpp : f) {
					stack.push(fpp);

				}
			} // else if ends here
			//layerCount--;



			if(layerCount.get(layer-1)==0 ) {
				layer--;
				layerCount.set(layer-1,layerCount.get(layer-1)-1);
				//System.out.println(layerCount.get(layer-1));

			}
			else {
				layerCount.set(layer-1,layerCount.get(layer-1)-1);
				//System.out.println(layerCount.get(layer-1));

			}
		} // stack is not empty loop ends here
	} // main function ends here
}