

import java.util.ArrayList;

import java.util.Scanner;

//A class that implements all the methods of DictionaryInterface

public class dict  {

private ArrayList<String> words = new ArrayList<>();

public void addWord(String word) {

this.words.add(word);

}

public boolean isWord(String word) {

if (words.stream().anyMatch(word::equalsIgnoreCase)) {

return true;

}

return false;

}


public int getSize() {

return words.size();

}

@Override

public String toString() {

String ans = "";

for (int i = 0; i < words.size(); i++) {

ans += words.get(i) + " ";

}

return ans;

}

// One arg constructor that takes the file Name of the dictionary file to create

// a list of Strings

public dict(Scanner sc) {

while (sc.hasNext()) {

String str = sc.nextLine();

words.add(str);

}

sc.close();

}

}