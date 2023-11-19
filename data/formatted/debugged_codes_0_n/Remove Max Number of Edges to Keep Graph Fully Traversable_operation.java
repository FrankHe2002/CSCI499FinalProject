```java
// Runtime: 29 ms (Top 44.9%) | Memory: 82.52 MB (Top 97.7%)

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> {
            return b[0] - a[0];
        });        

        int[] parentAlice = new int[n + 1];
        int[] parentBob = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parentAlice[i] = i;
            parentBob[i] = i;
        }

        int mergeAlice = 1;
        int mergeBob = 1;

        int removeEdge = 0;

        for (int[] edge : edges) {
            int cat = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (cat == 3) {
                boolean tempAlice = union(u, v, parentAlice);
                boolean tempBob = union(u, v, parentBob);

                if (tempAlice)
                    mergeAlice++;

                if (tempBob)
                    mergeBob--;

                if (!tempAlice && !tempBob)
                    removeEdge++;
            } else if (cat == 2) {
                boolean tempBob = union(u, v, parentBob);

                if (tempBob)
                    mergeBob++;
                else
                    removeEdge++;
            } else {
                boolean tempAlice = union(u, v, parentAlice);

                if (tempAlice)
                    mergeAlice++;
                else
                    removeEdge++;
            }
        }
        if (mergeAlice != n || mergeBob != n)
            return - 1;
        return removeEdge;
    }

    public int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;

        int temp = find(parent[x], parent);

        parent[x] = temp;

        return temp;
    }

    public boolean union(int x, int y, int[] parent) {
        int lx = find(x, parent);
        int ly = find(y, parent);

        if (lx != ly) {
            parent[lx] = ly;

            return true;
        } else
            return false;
    }
}
```