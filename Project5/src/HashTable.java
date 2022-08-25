// li002380 Joshua Li
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Math.abs;

public class HashTable<T>{
    NGen<T>[] hashTable;

    //TODO: Create a constructor that takes in a length and initializes the hash table array
    public HashTable(int length){
        hashTable = new NGen[length];
    }

    //TODO: Implement a simple hash function
    public int hash1(T item) {
        String word = item.toString();
        int mark = word.charAt(0) % hashTable.length;
        return mark;
    }

    //TODO: Implement a second (different and improved) hash function
    public int hash2(T item) {
        String word = item.toString();
        int mark = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'b' || word.charAt(i) == 'c' || word.charAt(i) == 'd') { // Meant to prevent modulus from being the same
                // since a and k are 10 apart (a is 97 and k is 107)
                mark += word.charAt(i); // Sum of all ASCII values for each character
            }
            else if(word.charAt(i) == 'g' || word.charAt(i) == 'h' || word.charAt(i) == 'i' || word.charAt(i) == 'j'){
                mark += word.charAt(i) + 5; // Increase by adding 5 so as to reduce the chance characters when added are equal
            }
            else if(word.charAt(i) == 'k' || word.charAt(i) == 'l' || word.charAt(i) == 'm' || word.charAt(i) == 'n') {
                mark += word.charAt(i) + 1;
            }
            else if(word.charAt(i) == 'q' || word.charAt(i) == 'r' || word.charAt(i) == 's' || word.charAt(i) == 't'){
                mark += word.charAt(i) + 3;
            }
            else if(word.charAt(i) == 'o' || word.charAt(i) == 'p' || word.charAt(i) == 'e' || word.charAt(i) == 'f'){
                mark += word.charAt(i) + 4;
            }
            else {
                mark += word.charAt(i) + 2;
            }
        }

        mark = mark % hashTable.length; // Ensure the mark index fits in the array
        mark = abs(mark);
        return mark;
    }

    //TODO: Implement the add method which adds an item to the hash table using your best performing hash function
    // Does NOT add duplicate items
    public void add(T item) {
        int index = hash2(item);
        NGen<T> node = new NGen(item, null);
        if(hashTable[index] == null) { // Check if linked node at array index is empty which case a new node is placed
            hashTable[index] = node;
        }
        else{
            NGen<T> ptr = hashTable[index];
            while(ptr.getNext() != null) { // Check if the item is already in the linked list
                if(ptr.getData() == item){
                    return;
                }
                ptr = ptr.getNext();
            }
            if(ptr.getData() == item){ // Final check because there is no trailer
                return;
            }
            ptr.setNext(new NGen<>(item, null));
        }
    }

    // ** Already implemented -- no need to change **
    // Adds all words from a given file to the hash table using the add(T item) method above
    @SuppressWarnings("unchecked")
    public void addWordsFromFile(String fileName) {
        Scanner fileScanner = null;
        String word;
        try {
            fileScanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " not found.");
            System.exit(1);
        }
        while (fileScanner.hasNext()) {
            word = fileScanner.next();
            word = word.replaceAll("\\p{Punct}", ""); // removes punctuation
            this.add((T) word);
        }
    }

    //TODO: Implement the display method which prints the indices of the hash table and the number of words "hashed"
    // to each index. Also prints:
    // - total number of unique words
    // - number of empty indices
    // - number of nonempty indices
    // - average collision length
    // - length of longest chain
    public void display() {
        double uniqueWords = 0;
        double emptyIndices = 0;
        double nonEmpty = 0;
        double greatestChain = 0;
        for(int i = 0; i < hashTable.length; i++) {
            int mark = 0;
            if (hashTable[i] == null) { // If index is null print 0
                System.out.println(i + ": 0");
                emptyIndices++;
            } else {
                NGen<T> ptr = hashTable[i];
                int temp = 0;
                while (ptr.getNext() != null) { // Add to unique words, mark (number of words in the chain), and
                    // temp (greatest chain length checker)
                    uniqueWords++;
                    mark++;
                    ptr = ptr.getNext();
                    temp++;
                }
                uniqueWords++;
                temp++;
                mark++;
                if(temp > greatestChain){ // If a greater length is found change the initial value
                    greatestChain = temp;
                }
                System.out.println(i + ": " + mark);
                nonEmpty++;
            }
        }
        System.out.println("# Unique Words: " + uniqueWords);
        System.out.println("# Empty Indices: " + emptyIndices);
        System.out.println("# Nonempty Indices: " + nonEmpty);
        System.out.println("Average Collision Length: " + uniqueWords / nonEmpty);
        System.out.println("Length of Longest Chain: " + greatestChain);
    }

    // TODO: Create a hash table, store all words from "canterbury.txt", and display the table
    //  Create another hash table, store all words from "keywords.txt", and display the table
    public static void main(String args[]) throws FileNotFoundException {
        HashTable test1 = new HashTable(149);
        test1.addWordsFromFile("canterbury.txt");
        test1.display();
        HashTable test2 = new HashTable(49);
        test2.addWordsFromFile("keywords.txt");
        test2.display();
    }
}
