class Solution {

    public int minScore(int n, int[][] roads) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] r : roads) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }

        boolean[] vis = new boolean[n + 1];

        return dfs(1, graph, vis);
    }

    private int dfs(int u, List<int[]>[] graph, boolean[] vis) {

        vis[u] = true;

        int ans = Integer.MAX_VALUE;

        for (int[] edge : graph[u]) {

            int v = edge[0];
            int w = edge[1];

            ans = Math.min(ans, w);

            if (!vis[v])
                ans = Math.min(ans, dfs(v, graph, vis));
        }

        return ans;
    }
}