package civan;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("PART 1");
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        MinPriorityQueue minPriorityQueue = new MinPriorityQueue(1000000);
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

        System.out.println("MinPriorityQueue sorted :" + isSorted(results.stream().mapToInt(i -> i).toArray()));
        results.clear();

        for (int i = 0; i < 1000000; i++) {
            binarySearchTree.insert(rn.nextInt());
        }

       size = binarySearchTree.getSize();
        for (int i = 0; i < size; i++) {
            int x = binarySearchTree.extract_min().value;
            results.add(x);
        }

        System.out.println("BinarySearchTree Sorted :" + isSorted(results.stream().mapToInt(i -> i).toArray()));

        System.out.println("PART 2 ");
        int sampleInput[] = {4,8,3,1,6,9,12,7,2};
        System.out.println("Total cost for connecting ropes is : " +
                RopesLowestCost.calculate(sampleInput));
    }

    public static boolean isSorted(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
