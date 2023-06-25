package ruichen.pramp;

public class TimePlanner {
    // https://www.pramp.com/challenge/3QnxW6xoPLTNl5jX5Lg1

    class Solution {
        // Assume slots are disjoint and already sorted
        // TC = O(m + n), SC = O(1)
        public int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
            int i = 0, j = 0;

            while (i < slotsA.length && j < slotsB.length) {
                int start = Math.max(slotsA[i][0], slotsB[j][0]);
                int end = Math.min(slotsA[i][1], slotsB[j][1]);

                if (end - start >= dur) {
                    return new int[] {start, start + dur};
                }

                // Move the pointer that points to the earlier end time
                if (slotsA[i][1] < slotsB[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }

            return new int[0];
        }
    }
}
