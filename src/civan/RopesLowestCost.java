package civan;

public class RopesLowestCost {
    public static int calculate(int[] input){
        int totalCost = 0;
        BinarySearchTree minPriority = new BinarySearchTree();
        for (int x : input) {
            minPriority.insert(x);
        }

        while (minPriority.getSize() > 1){
            try {
                int cost = minPriority.extract_min().value + minPriority.extract_min().value;
                totalCost += cost;
                minPriority.insert(cost);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return totalCost;
    }
}
