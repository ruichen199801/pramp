package ruichen.pramp;

public class LargestSmallerBSTKey {
    // https://www.pramp.com/challenge/pK6A4GA5YES09qKmqG33

    class Solution {
        class Node {
            int key;
            Node left;
            Node right;

            Node(int key) {
                this.key = key;
            }
        }

        class BinarySearchTree {
            Node root;

            // Assume strictly smaller, all node values are non-negative (therefore we won't have trouble returning -1 when no smaller key is found)
            // TC = O(n), SC = O(1)
            int findLargestSmallerKey(int num) {
                int result = -1;
                if (root == null) {
                    return result;
                }
                while (root != null) {
                    if (num > root.key) {
                        // Only update result when we find a valid smaller node value
                        result = root.key;
                        root = root.right;
                    } else {
                        root = root.left;
                    }
                }
                return result;
            }
        }
    }
}
