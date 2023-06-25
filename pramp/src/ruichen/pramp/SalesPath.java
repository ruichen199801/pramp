package ruichen.pramp;

public class SalesPath {
    // https://www.pramp.com/challenge/15oxrQx6LjtQj9JK9XqA

    class Solution {
        class Node {
            int cost;
            Node[] children;
            Node parent;

            Node(int cost) {
                this.cost = cost;
                children = null;
                parent = null;
            }
        }

        class SalesPathTree {
            // TC = O(n), SC = O(height)
            int getCheapestCost(Node rootNode) {
                if (rootNode == null) {
                    return Integer.MAX_VALUE;
                }
                return dfs(rootNode);
            }

            int dfs(Node rootNode) {
                // If the current node is a leaf, report to parent its own cost
                if (rootNode.children == null || rootNode.children.length == 0) {
                    return rootNode.cost;
                }

                // If not a leaf, continue DFS for each child and update minCost
                // Binary tree equivalence: minCost = Math.min(dfs(root.left), dfs(root.right));
                int minCost = Integer.MAX_VALUE;
                for (Node child : rootNode.children) {
                    if (child != null) {
                        minCost = Math.min(minCost, dfs(child));
                    }
                }

                // Report to parent the minCost so far
                return rootNode.cost + minCost;
            }
        }
    }
}
