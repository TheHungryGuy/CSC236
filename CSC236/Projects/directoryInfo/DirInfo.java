package directoryInfo;
//Antonio Arce CSC236 Data Structures in Java Lab 1

import java.io.File;

public class DirInfo {

	//ArrayList<String> currDir;

	/*
	 * Lab 2 Directions
	 * Read in String from parameter
	 * Use the File class(java.io.File) to print the name of the directory
	 * Print the name of each file and each directory
	 * For every directory contained in the starting directory,
	 * print the directory name and each file within
	 */

	public void printDir(String Path) {

		int layer = 0;//var to hold current layer 
		int[] layerCount = new int[1000];//Arr to hold Count of current and past levels of total files
		String spaces = "   ";//3 spaces

		File homePath = new File(Path); //create file object with the path passed
		//Create Stack of Files to Hold each file in the dir
		ArrayBoundedStack<File> stack = new ArrayBoundedStack<>(100000); //changed stack max size to 100000 to handle most folders and files to avoid overflow
		stack.push(homePath); //push the home path to first position in the stack
		System.out.println("Contents of Directory " + homePath.getAbsolutePath()); 
		//run a while loop until the entire stack is printed
		//files and folders will be added to the stack in order
		//and will be popped as they get printed
		while(!stack.isEmpty()) {
			File currF = stack.top();//create new file obj for current file/folder
			stack.pop(); //pop file since it will be printed
			System.out.println(spaces.repeat(layer) + currF.getName()); //print with spaces multiplied by the layer
			//check if the current obj is a file or directory
			if(currF.isDirectory()) {
				layer++;
				File[] dirF = currF.listFiles(); //create array with all the files/folders of next layer 
				//Check if folder is empty
				//if the folder has items 
				//add the total number to the array of the same level
				//else remain in the same layer
				if(dirF.length!=0) {
					layerCount[layer]=dirF.length;
				}else {
					layer--;
				}
				for (File each: dirF) {
					stack.push(each);
				}

				
			}
			//check if the currrnt layer has any remaining files/folders to print
			//if not it will go up a layer and check again for remaining files
			//keeps looping until layer with remaining files is found 
			//if loops reaches 0 then breaks to end program
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
