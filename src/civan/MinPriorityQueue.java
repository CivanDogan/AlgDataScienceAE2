package civan;

public class MinPriorityQueue {
    private int[] heap;
    private int maxheap;
    private int heapSize = 0;


    public MinPriorityQueue(int maxheap){
        this.maxheap = maxheap;
        this.heap = new int[maxheap];
    }
    private int left(int i){
        return (2*i) +1;
    }
    private int right(int i){
        return (2*i) +2;
    }
    private void swap(int i , int n){
        int temp = heap[i];
        heap[i] = heap[n];
        heap[n] = temp;
    }


    public void min_heapify(int i){
        int l = left(i);
        int r = right(i);
        int n = this.heapSize;
        int lowest;
        if ((l < n) && (heap[l] < heap[i])){
            lowest = l;
        }else {
            lowest = i;
        }
        if ((r < n) && (heap[r]< heap[lowest])){
            lowest = r;
        }
        if (lowest != i){
            swap(i,lowest);
            min_heapify(lowest);
        }

    }

    public void build_max_heap(int n){
        for (int i = (n/2) -1 ; i > 0 ; i--) {
            min_heapify(i);
        }
    }

    public int getMin() {
        return this.heap[0];
    }

    public int extract_min() throws IllegalArgumentException{
        if(heapSize == 0){
            throw new IllegalArgumentException("Empty");
        }
        var temp = heap[0];
        heap[0] = heap[heapSize - 1];

        heapSize--;
        min_heapify(0);

        return temp;
    }

    public void insert (int value) throws IllegalStateException{
        if(heapSize >= maxheap){
            throw new IllegalStateException("Heap Limit Reached");
        }
        int i = heapSize++;
        heap[i] = value;

        while(i > 0 && heap[i] < heap[getParent(i)]){
            swap(i,getParent(i));
            i = getParent(i);
        }



    }
    private int getParent(int index) {
        if (index == 0) {
            return -1;
        }
        return (index-1)/2;
    }

}
