class Solution {

    List<int[]>[] graph;
    int[] topo;
    boolean[] online;
    long k;
    int n;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        this.online = online;
        this.k = k;
        n = online.length;

        graph = new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        int[] indegree = new int[n];

        TreeSet<Integer> set = new TreeSet<>();

        for(int[] e : edges){
            graph[e[0]].add(new int[]{e[1],e[2]});
            indegree[e[1]]++;
            set.add(e[2]);
        }

        topo = topoSort(indegree);

        if(set.isEmpty())
            return -1;

        int[] vals = new int[set.size()];
        int idx=0;
        for(int x:set)
            vals[idx++]=x;

        int lo=0, hi=vals.length-1;
        int ans=-1;

        while(lo<=hi){
            int mid=(lo+hi)/2;

            if(check(vals[mid])){
                ans=vals[mid];
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }

        return ans;
    }

    private boolean check(int limit){

        long INF = Long.MAX_VALUE/4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0]=0;

        for(int u: topo){

            if(dist[u]==INF)
                continue;

            if(u!=0 && u!=n-1 && !online[u])
                continue;

            for(int[] edge: graph[u]){

                int v=edge[0];
                int w=edge[1];

                if(w<limit)
                    continue;

                if(v!=n-1 && !online[v])
                    continue;

                if(dist[v] > dist[u]+w){
                    dist[v]=dist[u]+w;
                }
            }
        }

        return dist[n-1]<=k;
    }

    private int[] topoSort(int[] indegree){

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0;i<n;i++)
            if(indegree[i]==0)
                q.offer(i);

        int[] order = new int[n];
        int idx=0;

        while(!q.isEmpty()){

            int u=q.poll();
            order[idx++]=u;

            for(int[] e: graph[u]){
                if(--indegree[e[0]]==0)
                    q.offer(e[0]);
            }
        }

        return order;
    }
}