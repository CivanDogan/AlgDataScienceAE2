package civan;

public class Main {

    public static void main(String[] args) {
        MinPriorityQueue q = new MinPriorityQueue(10);
        q.insert(10);
        q.insert(5);
        q.insert(4);
        q.insert(6);
        q.insert(20);
        System.out.println();
        System.out.println("Min: " + q.getMin());
        System.out.println("Extracting min: " + q.extract_min());
        System.out.println("Extracting min: " + q.extract_min());
        System.out.println("Extracting min: " + q.extract_min());
        System.out.println("Extracting min: " + q.extract_min());
        System.out.println("Extracting min: " + q.extract_min());
        System.out.println("Extracting min: " + q.extract_min());
    }
}
