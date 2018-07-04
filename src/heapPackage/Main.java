package heapPackage;

public class Main {


    public static void main(String[] args){

        MinHeap mheap = new MinHeap(10);
        mheap.printHeap();
        mheap.add(10);
        mheap.add(20);
        mheap.printHeap();
        mheap.add(5);
        mheap.add(7);
        mheap.printHeap();
        System.out.println(mheap.peek());
        mheap.poll();
        mheap.printHeap();
    }
}
