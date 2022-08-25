//Written by Joshua Li: li002380
public class LinkedList<T extends Comparable<T>> implements List<T> {
    private boolean isSorted;
    public Node<T> head;
    private int size;
    public LinkedList() {
        head = null;
        isSorted = false;
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
        Node<T> ptr = head;
        if(element != null) {
            Node<T> newNode = new Node<>(element);
            if (head == null) {
                head = newNode;
            }
            else {
                while (ptr.getNext() != null) {
                    ptr = ptr.getNext();
                }
                ptr.setNext(newNode);
            }
            size++; //Increases size counter.
            checkSorted(); //Calls checkSorted method
            return true;
        }
        else{
            checkSorted();
            return false;
        }
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
        if(element == null){
            return false;
        }
        Node<T> internalCounterPtr = head;
        if(index >= 0 && index < size){
            Node<T> newNode = new Node<>(element);
            for(int i = 0; i < size; i++) {
                if(i == index - 1){
                    if (internalCounterPtr.getNext() != null) { //Check if ptr is at the end
                        newNode.setNext(internalCounterPtr.getNext());
                        internalCounterPtr.setNext(newNode);
                    } else { //Sets the ptr next to new node
                        internalCounterPtr.setNext(newNode);
                    }
                }
                if(internalCounterPtr.getNext() != null) {
                    internalCounterPtr = internalCounterPtr.getNext(); //Keeps the ptr going
                }
            }
            size++;
            checkSorted();
            return true;
        }
        checkSorted();
        return false;
    }
    /**
     * Remove all elements from the list and updates isSorted accordingly.
     */
    public void clear(){
        head = null;
        size = 0;
        isSorted = true;
    }
    /**
     * Return the element at given index. If index is
     * out-of-bounds, it will return null.
     *
     * @param index index to obtain from the list.
     * @return the element at the given index.
     */
    public T get(int index){
        Node<T> internalCounterPtr = head;
        for (int i= 0; i < size; i++) {
            if(i == index && internalCounterPtr != null){
                return internalCounterPtr.getData(); //Node's data at said index
            }
            if(internalCounterPtr.getNext() != null) {
                internalCounterPtr = internalCounterPtr.getNext();
            }
        }

        return null;
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
        if (element == null || head == null) { //Error checker
            return -1;
        }
        int internalCounter = 0;
        Node<T> internalCounterPtr = head;
        while(internalCounterPtr != null){
            if(internalCounterPtr.getData().equals(element)){
                return internalCounter; //Index of the element
            }
            internalCounterPtr = internalCounterPtr.getNext();
            internalCounter++;
        }
        return -1;
    }

    /**
     * Return true if the list is empty and false otherwise.
     *
     * @return if the list is empty.
     */
    public boolean isEmpty(){
        if(head == null){
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
        return size;
    }

    /**
     * Sort the elements of the list in ascending order using insertion sort.
     * If isSorted is true, do NOT re-sort.
     * Hint: Since T extends Comparable, you will find it useful
     * to use the public int compareTo(T other) method.
     * Updates isSorted accordingly.
     */
    private Node<T> sorter(Node<T> sortedHeadNode, Node<T> newNode){ //Separate method meant to compare two individual
        //Nodes away from the first method.
        if(sortedHeadNode == null || head.getData().compareTo(newNode.getData()) > 0){ //Check if it at the start of the list
            newNode.setNext(sortedHeadNode);
            return newNode;
        }
        else{
            Node<T> ptr = sortedHeadNode;
            while(ptr.getNext() != null && ptr.getNext().getData().compareTo(newNode.getData()) < 0){ //Compares the two
                ptr = ptr.getNext();
                newNode.setNext(ptr.getNext());
                ptr.setNext(newNode);
            }
        }
        return sortedHeadNode;
    }
    public void sort(){
        Node current = head, cursor = null;
        T temp;
        if(head == null){
            return;
        }else{
            while(current != null){
                cursor = current.getNext();
                while (cursor != null) {
                    if (current.getData().compareTo(cursor.getData()) > 0) { //Cursor and current are compared and sorted
                        temp = (T) current.getData();
                        current.setData(cursor.getData());
                        cursor.setData(temp);
                    }

                    cursor = cursor.getNext();
                }
                current = current.getNext();
            }
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
        Node<T> internalCounterPtr = head;
        Node<T> temp = null;
        if(index == 0 && head != null){ //Case for removing the head. Sets head to next element
            temp = head;
            head = head.getNext();
            size--;
            checkSorted();
            return temp.getData();
        }
        else if(index > 0 || index < size){
            int i = 0;
            while(internalCounterPtr != null && i < size){
                if(i == index-1){
                    temp = internalCounterPtr.getNext();
                    if (temp != null) {
                        internalCounterPtr.setNext(temp.getNext()); //Skips over the temp node while also assigning it

                    }
                }
                internalCounterPtr = internalCounterPtr.getNext();
                i++;

            }
            size--;
            checkSorted();
            if(temp != null) {
                return temp.getData(); //Check for if temp is a null.
            }
        }
        return null;
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
        int origSize = size; //Prevent changes in size attribute.
        for (int i = 0; i < origSize; i++) {
            Node <T> ptr2 = head;
            while(ptr2 != null){
                if(!ptr2.getData().equals(element)){
                    remove(indexOf(ptr2.getData())); //Uses the remove function and shifts the list
                    //whenever the element isn't equal
                }
                ptr2 = ptr2.getNext();
            }
        }
        isSorted = true;
    }

    /**
     * Reverses the list IN PLACE. Any use of intermediate data structures will yield
     * your solution invalid.
     */
    public void reverse(){ // Credit: 1933 Reversed headed list method - Chris Dovolis
        if(head.getNext() == null || head.getNext().getNext()  == null) {
            return;
        }
        Node<T> ptr = head.getNext().getNext();
        Node<T> trl = head.getNext();
        while(ptr != null){
            trl.setNext(ptr.getNext());
            ptr.setNext(head.getNext());
            head.setNext(ptr);
            ptr = trl.getNext();
        }
        Node<T> once = new Node<>(remove(0));
        add(once.getData()); //Extra cycle since this reverse is for a headed list
        checkSorted();
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
        if(otherList == null){
            return;
        }

        LinkedList<T> other = (LinkedList<T>) otherList;
        sort();
        other.sort();

        Node<T> head1 = head;
        Node<T> head2 = other.head;

        Node<T> mergedHead = null;
        if (head1.getData().compareTo(head2.getData()) <= 0) { //Checks to see if the first element of the first list is
            //greater than or less than the first element of the second list
            mergedHead = head1;
            head1 = head1.getNext();
        } else {
            mergedHead = head2;
            head2 = head2.getNext();
        }

        Node<T> mergedTail = mergedHead; //Creates a list that has one round sorted (A head is necessary)

        while (head1 != null && head2 != null) {
            Node<T> temp = null;
            if (head1.getData().compareTo(head2.getData()) <= 0) { //Sorts the rest of the list
                temp = head1;
                head1 = head1.getNext();
            } else {
                temp = head2;
                head2 = head2.getNext();
            }
            mergedTail.setNext(temp);
            mergedTail = temp;
        }

        if (head1 != null) { //Adds nodes to the merged list
            mergedTail.setNext(head1);
        } else if (head2 != null) {
            mergedTail.setNext(head2);
        }

        head = mergedHead;
        size = getCount();
        isSorted = true;
    }

    int getCount(){
        int count = 0;
        Node currNode = head;
        while(currNode.getNext() != null){
            currNode = currNode.getNext();
            count++;
        }
        return count+1;
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
        if(n <= 0 || size() <= 1){
            return false;
        }
        else{
            for(int i = 0; i < n; i++){
                Node<T> temp = head;
                Node<T> end = head;
                while(temp.getNext() != null){
                    if(temp.getNext().getNext() == null) {
                        end = temp; // Shifts all the elements to the end of the list ignoring the
                        //last element. Last element is assigned to end.
                    }
                    temp = temp.getNext();
                }
                Node<T> temp2 = new Node<T>(temp.getData());
                temp2.setNext(head);
                end.setNext(null); //Sets end to the front
                head = temp2;
            }
        }
        checkSorted();
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
        Node<T> ptr = head;
        while(ptr != null){
            statement += ptr.getData();
            statement = statement.trim();
            statement += "\n";
            ptr = ptr.getNext();
        }
        return statement;
    }

    /**
     * Simply returns the isSorted attribute.
     *
     * @return isSorted boolean attribute.
     */
    public boolean isSorted(){
        return isSorted;
    }
    private boolean checkSorted(){
        if (size < 2){
            isSorted = true;
            return true;
        }
        isSorted = true;
        Node<T> ptr = head;
        while(ptr != null && ptr.getNext() != null){ //Iterates through the list in linkedList and determines if all
            //elements are in sorted order.
            if(ptr.getData().compareTo(ptr.getNext().getData()) > 0) {
                isSorted = false;
                break;
            }
            ptr = ptr.getNext();
        }
        return false;
    }
    public static void main(String[] args){

    }
}
