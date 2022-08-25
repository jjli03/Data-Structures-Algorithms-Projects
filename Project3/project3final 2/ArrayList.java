//Written by Joshua Li: li002380
import java.util.Arrays;

public class ArrayList<T extends Comparable<T>> implements List<T> {
    private int size;
    private T[] arrayList;
    private boolean isSorted;
    public ArrayList() {
        arrayList = (T[]) new Comparable[2];
        isSorted = true;
    }
    /**
     * Add an element to end of the list. If element is null,
     * it will NOT add it and return false.  Otherwise, it
     * will add it and return true. Updates isSorted to false if
     * the element added breaks sorted order.
     *
     * @param element element to be added to the list.
     * @return if the addition was successful.
     */
    public boolean add(T element){
        if(element == null){
            return false;
        }
        else{
            T[] arrayList2;
            if(size() == arrayList.length) {
                arrayList2 = (T[]) new Comparable[arrayList.length * 2];
                for(int i = 0; i < arrayList.length; i++){
                    arrayList2[i] = arrayList[i];
                }
                arrayList2[size()] = element; //Sets the end
                arrayList = arrayList2;
                checkSorted();
                size();
                return true;//Resizes iff array length equals size
            }
            else {
                arrayList[size] = element;
                checkSorted();
                size();
                return true;
            }

        }
    }
    private boolean checkSorted(){ //Iterates through the array in arrayList and determines if all
        //elements are in sorted order.
        size = size();
        if (size < 2){
            isSorted = true;
            return true;
        }

        isSorted = true;
        for (int k = 1; k < arrayList.length; k++) {
            if (arrayList[k] != null && arrayList[k-1] != null) {
                if (arrayList[k].compareTo(arrayList[k - 1]) < 0) {
                    isSorted = false;
                    break;
                }
            }
        }
        return false;
    }

    /**
     * Add an element at specific index. This method should
     * also shift the element currently at that position (if
     * any) and any subsequent elements to the right (adds
     * one to their indices). If element is null, or if index
     * index is out-of-bounds (index < 0 or index >= size_of_list),
     * it will NOT add it and return false. Otherwise it will
     * add it and return true. See size() for the definition
     * of size of list. Also updates isSorted variable to false if the
     * element added breaks the current sorted order.
     *
     * @param index index at which to add the element.
     * @param element element to be added to the list.
     * @return if the addition was successful.
     */
    public boolean add(int index, T element){
        if(element == null || index < 0 || index >= size()){
            return false;
        }
        else{
            T[] arrayList2;
            arrayList2 = (T[]) new Comparable[arrayList.length + 1];
            for (int i = 0; i < index; i++) {
                arrayList2[i] = arrayList[i];
            }
            arrayList2[index] = element;
            for (int i = index + 1; i <= arrayList.length; i++) {
                arrayList2[i] = arrayList[i - 1]; //Shifts all elements from this array list to the new array List forward
                //by one.
            }
            arrayList = arrayList2;
            checkSorted();
            size();
            return true;
        }
    }

    /**
     * Remove all elements from the list and updates isSorted accordingly.
     */
    public void clear(){
        for(int i = 0; i < size(); i++){
            arrayList[i] = null;
        }
        size = 0;
        arrayList = (T[]) new Comparable[2]; //Reinitializes the constructor
        isSorted=true;
    }

    /**
     * Return the element at given index. If index is
     * out-of-bounds, it will return null.
     *
     * @param index index to obtain from the list.
     * @return the element at the given index.
     */
    public T get(int index){
        T element = null;
        if(index < 0 || index >= size) {
            return null;
        }
        else{
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    element = arrayList[i];
                }
            }
        }
        return element;
    }

    /**
     * Return the first index of element in the list. If element
     * is null or not found in the list, return -1. If isSorted is
     * true, uses the ordering of the list to increase the efficiency
     * of the search.
     *
     *
     * @param element element to be found in the list.
     * @return first index of the element in the list.
     */
    public int indexOf(T element){
        int counter = 0;
        if(element != null) {
            for(int i = 0; i < arrayList.length; i++) {
                if(arrayList[i] != null && arrayList[i].equals(element)) {
                    return counter;
                }
                counter++;
            }
        }
        return -1;
    }

    /**
     * Return true if the list is empty and false otherwise.
     *
     * @return if the list is empty.
     */
    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        return false;
    }

    /**
     * size() return the number of elements in the list. Be careful
     * not to confuse this for the length of a list like for an ArrayList.
     * For example, if 4 elements are added to a list, size will return
     * 4, while the last index in the list will be 3. Another example
     * is that an ArrayList like [5, 2, 3, null, null] would have a size
     * of 3 for an ArrayList.
     * ArrayList and LinkedList hint: create a class variable in both ArrayList
     * and LinkedList to keep track of the sizes of the respective lists.
     *
     * @return size of the list.
     */
    public int size(){
        int count = 0;
        for(int i = 0; i < arrayList.length; i++){
            if(arrayList[i] != null){
                count++; // Ensures no nulls are counted as an element
            }
        }
        size = count;
        return size;
    }

    /**
     * Sort the elements of the list in ascending order using insertion sort.
     * If isSorted is true, do NOT re-sort.
     * Hint: Since T extends Comparable, you will find it useful
     * to use the public int compareTo(T other) method.
     * Updates isSorted accordingly.
     */
    public void sort(){ //Credit Insertion Sort: Chris Dovolis
        if(isSorted){
            return;
        }
        for(int i = 1; i < size; i++){
            T n = arrayList[i];
            int j = i - 1;
            while((j > -1) && arrayList[j].compareTo(n) > 0){ //Compares the two adjacent elements to each other
                arrayList[j + 1] = arrayList[j];
                j--;
            }
            arrayList[j + 1] = n;
        }
        isSorted = true;
    }

    /**
     * Remove whatever is at index 'index' in the list and return
     * it. If index is out-of-bounds, return null. For the ArrayList,
     * elements to the right of index should be shifted over to maintain
     * contiguous storage. Must check to see if the list is sorted after removal
     * of the element at the given index and updates isSorted accordingly.
     *
     * @param index position to remove from the list.
     * @return the removed element.
     */
    public T remove(int index){
        T holder = null;
        if(index < 0 || index >= size()){
            return null;
        }
        else{
            if(arrayList[index] == null){
                return null;
            }
            T[] arrayList2 = (T[]) new Comparable[arrayList.length - 1]; //Resizes to fit the new amount of elememts
            int j = 0;
            for(int i = 0; i < size(); i++){
                if(i != index) {
                    arrayList2[j] = arrayList[i]; //Skips over the element
                    j++;
                }
                else{
                    holder = arrayList[i];
                }
            }
            arrayList = arrayList2;
            checkSorted();
            size();
        }
        return holder;
    }

    /**
     * Removes all elements of the list that are not equal to 'element'. If element is null, don't do anything.
     * When this function returns, the only elements that should be left in this list
     * are equal to 'element'. This method should not change the ordering of the list.
     * If the list is sorted, use this fact to increase the efficiency of this method.
     * This method should be done IN PLACE. Do not use any extra data structures to
     * solve this problem. (You are NOT allowed to create a new array for this function).
     * Updates isSorted accordingly.
     *
     * @param element type of element to be kept in the list.
     */
    public void equalTo(T element){
        int correct = 0;
        for(int i = 0; i < size; i++){
            if(arrayList[i] != null && arrayList[i].equals(element)){
                correct++; //Gains the amount of elements equal to the element
            }
        }
        for(int i = 0; i < arrayList.length; i++){
            if(i < correct){
                arrayList[i] = element; //Sets the from of the array to all the elements counted
            }
            else{
                arrayList[i] = null; //Sets the rear of the array to null
            }
        }
        size = correct;
        checkSorted();
        size();
    }

    /**
     * Reverses the list IN PLACE. Any use of intermediate data structures will yield
     * your solution invalid.
     */
    public void reverse(){
        for(int i = 0; i < size / 2; i++){
            if(arrayList[i] != null && arrayList[size - 1 - i] != null) {
                T temp = arrayList[i];
                arrayList[i] = arrayList[size - 1 - i]; //Switches to the opposite index in the list until
                //they meet in the middle
                arrayList[size - 1 - i] = temp;
            }
        }
        checkSorted();
        size();
    }

    /**
     * Merges two sorted lists together into this list. If other is null, do not attempt to merge.
     * Sort MUST be called first on both this list and other list. The resulting list should be sorted.
     * Updates isSorted to true. You will have to cast otherList from a List<T> type to a LinkedList<T>
     * or ArrayList<T> type.
     *
     * After error checking, the first two lines of your code should be:
     * LinkedList<T> other = (LinkedList<T>) otherList; or ArrayList<T> other = (Arraylist<T>) otherList;
     * sort();
     * other.sort();
     *
     * Other than these two lines, you may not sort, or call the sort method, anywhere else in this function.
     * Ignoring this rule will result in an invalid solution.
     *
     * IMPORTANT NOTE: Ignore the time complexity of the sort function calls when determining the time
     * complexity of this method. (i.e. Just consider the merging portion of this function).
     *
     * Second Note for ArrayList: You will be required to create an array of the perfect size to
     * fill all elements from both lists into the new one. Then you will update the current list to
     * this new one.
     *
     * @param otherList list to be merged into this one.
     */
    public void merge(List<T> otherList){
        if(otherList == null)
            return;

        sort();
        otherList.sort();

        T[] arrayList2 = (T[]) new Comparable[size + otherList.size()];

        int i = 0, j = 0, k = 0;
        int sizeArrayList = size();
        int sizeOtherList = otherList.size();

        // Traverse both array
        while (i < size && j < sizeOtherList) {
            if (arrayList[i].compareTo(otherList.get(j)) < 0)
                arrayList2[k++] = arrayList[i++];
            else
                arrayList2[k++] = otherList.get(j++);
        }

        while (i < sizeArrayList) {
            arrayList2[k++] = arrayList[i++];
        }
        while (j < sizeOtherList) {
            arrayList2[k++] = otherList.get(j++);
        }
        arrayList = arrayList2;
        size();
    }

    /**
     * Rotate this list to the right by n positions. This rotation must be done IN PLACE. Any use of
     * intermediate data structures will yield your solution invalid. If
     * n is less than or equal to 0 OR the list length is less than or equal to 1, return false without rotating.
     * Returns true otherwise after completing the rotation. Updates isSorted accordingly.
     * ArrayList hint: try to think about how the number of rotations could be simplified down based
     * on the size of the array.
     * LinkedList hint: try to think about the linked list in a circular way when rotating.
     *
     * @param n number of rotations.
     * @return if the rotation was successful.
     */
    public boolean rotate(int n){
        if(n <= 0 || size <= 1){
            return false;
        }
        else{
            for(int i = 0; i < n; i++){
                T temp = arrayList[size - 1]; // Gets the last element of the array
                for(int j = size - 2; j >= 0; j--){ // -2 is meant to ignore the last element when looping
                    arrayList[j + 1] = arrayList[j]; // Shifts elements to the right which eliminates the last
                    // element by replacing it with the penultimate element
                }
                arrayList[0] = temp; // Fills null first space with saved last element
            }
        }
        return true;
    }

    /**
     * Note that this method exists for debugging purposes.
     * It calls the toString method of the underlying elements in
     * the list in order to create a String representation of the list.
     * The format of the toString should appear as follows:
     * Element_1
     * Element_2
     * .
     * .
     * .
     * Element_n
     * Watch out for extra spaces or carriage returns. Each element
     * should be printed on its own line.
     *
     * @return String representation of the list.
     */
    public String toString(){
        String statement = "";
        for(int i = 0; i < size(); i++){
            statement += get(i);
            statement = statement.trim();
            statement += "\n";
        }
        return statement;
    }

    /**
     * Simply returns the isSorted attribute.
     *
     * @return isSorted boolean attribute.
     */
    public boolean isSorted(){ return isSorted; }
}

