package civan;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args)  {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            MinPriorityQueue minPriorityQueue = new MinPriorityQueue(10000);
            Random rn = new Random();
            ArrayList<Integer> results = new ArrayList();

            for (int i = 0; i < minPriorityQueue.getMaxheap(); i++) {
                minPriorityQueue.insert(rn.nextInt());
            }

            int size = minPriorityQueue.getHeapSize();
            for (int i = 0; i < size; i++) {
                int x = minPriorityQueue.extract_min();
                results.add(x);
            }

            System.out.println("Sorted :"+isSorted(results.stream().mapToInt(i -> i).toArray()));


        int len[] = { 4, 3, 2, 6 };
     System.out.println("Total cost for connecting ropes is : " +
        RopesLowestCost.calculate(len));
    }
    public static boolean isSorted(int a[]){
        int n = a.length;
        for (int i = 0; i < n-1; i++){
            if (a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }

}
