package heapPackage;

import java.util.Arrays;

public class MinHeap {

    public int [] array;
    public int capacity;
    public int size;

    public MinHeap(int capacity){
        this.array=new int[capacity];
        this.capacity = capacity;
        this.size=0;
    }

    public void printHeap(){
        for(int i =0;i<size;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("capacity is "+capacity );
        System.out.println("size is "+size );

    }

    public void add(int num){
        extendHeapSizeO();
        array[size]=num;
        size++;
        if(size>1) {
            heapifyUp();
        }

    }
    public int peek(){
        if (size==0){
            throw new IndexOutOfBoundsException();
        }
        return array[0];
    }

    public void extendHeapSizeO(){
        if (size == capacity){
            array = Arrays.copyOf(array,capacity*2);
            capacity *= 2;
        }

    }

    // Method to remove: Since its a MinHeap, it will remove the first element which is the min element
    public int poll(){
        if (size==0){
            throw new IndexOutOfBoundsException();
        }
        int num = array[0];
        array[0] = array[size-1];
        size--;
        heapifyDown(0);
        return num;
    }

    public void heapifyDown(int index){
        int min;
        if(hasLeftChild(index) && array[getLeftChild(index)]<array[index]){
            min = getLeftChild(index);
        }
        else{
            min = index;
        }

        if (hasRightChild(index) && array[getRightChild(index)]<min){
            System.out.println("index is "+array[index]+ " min is  "+array[min]);
            min = getRightChild(index);
        }
        if (min==index){
            return;
        }
        swap(index,min);
        System.out.println("swapped index is  "+array[index]+" min is  "+array[min]);
        heapifyDown(min);
    }

    public void heapifyUp(){
        int index = size-1;
        int temp;
        int parent = getParent(index);

        while(hasParent(index) && array[parent]>array[index]){
            swap(parent,index);
            index = parent;
        }

    }

    public void swap(int i, int j){
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public boolean hasParent(int index){
        int parent = (index-1)/2;
        if(parent>=0) {
            return true;
        }
        return false;
    }
    public boolean hasLeftChild(int index){
        int left = index*2 +1;
        if(left>=this.size) {
            return false;
        }
        return true;
    }

    public boolean hasRightChild(int index){
        int right = index*2 +2;
        if(right>=this.size) {
            return false;
        }
        return true;
    }

    public int getLeftChild (int index){
        int left = index*2 +1;
        if(left>=this.size) throw new IndexOutOfBoundsException();

        return left;
    }

    public int getRightChild (int index){
        int right = index*2 +2;
        if(right>=this.size) throw new IndexOutOfBoundsException();

        return right;
    }

    public int getParent (int index){
        if (index <=0){
            throw new IndexOutOfBoundsException();
        }
        int parent = (index-1)/2;
        return parent;
    }

}
