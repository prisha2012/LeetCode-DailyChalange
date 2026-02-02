class Solution {
    private final TreeMap<Integer, Integer> leftPartition = new TreeMap<>();
    private final TreeMap<Integer, Integer> rightPartition = new TreeMap<>();
    private long currentSum;
    private int leftPartitionSize;

    public long minimumCost(int[] nums, int k, int dist) {
        --k;

        currentSum = nums[0];

        for (int i = 1; i < dist + 2; ++i) {
            currentSum += nums[i];
            leftPartition.merge(nums[i], 1, Integer::sum);
        }

        leftPartitionSize = dist + 1;

        while (leftPartitionSize > k) {
            moveLeftToRight();
        }

        long answer = currentSum;

        for (int i = dist + 2; i < nums.length; ++i) {
            int elementToRemove = nums[i - dist - 1];

            if (leftPartition.containsKey(elementToRemove)) {
                if (leftPartition.merge(elementToRemove, -1, Integer::sum) == 0) {
                    leftPartition.remove(elementToRemove);
                }
                currentSum -= elementToRemove;
                --leftPartitionSize;
            } else {
                if (rightPartition.merge(elementToRemove, -1, Integer::sum) == 0) {
                    rightPartition.remove(elementToRemove);
                }
            }

            int elementToAdd = nums[i];

            if (leftPartition.isEmpty() || elementToAdd < leftPartition.lastKey()) {
                leftPartition.merge(elementToAdd, 1, Integer::sum);
                ++leftPartitionSize;
                currentSum += elementToAdd;
            } else {
                rightPartition.merge(elementToAdd, 1, Integer::sum);
            }

            while (leftPartitionSize < k) {
                moveRightToLeft();
            }
            while (leftPartitionSize > k) {
                moveLeftToRight();
            }

            answer = Math.min(answer, currentSum);
        }

        return answer;
    }

    private void moveLeftToRight() {
        int elementToMove = leftPartition.lastKey();

        currentSum -= elementToMove;

        if (leftPartition.merge(elementToMove, -1, Integer::sum) == 0) {
            leftPartition.remove(elementToMove);
        }
        --leftPartitionSize;

        rightPartition.merge(elementToMove, 1, Integer::sum);
    }

    private void moveRightToLeft() {
        int elementToMove = rightPartition.firstKey();

        if (rightPartition.merge(elementToMove, -1, Integer::sum) == 0) {
            rightPartition.remove(elementToMove);
        }

        leftPartition.merge(elementToMove, 1, Integer::sum);

        currentSum += elementToMove;
        ++leftPartitionSize;
    }
}
public class Day98 {
    
}
