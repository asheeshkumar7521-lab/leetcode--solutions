import java.util.*;

class Solution {
    static class State {
        int node, count;
        long distance;
        State(int node, int count, long distance) {
            this.node = node;
            this.count = count;
            this.distance = distance;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }
        long[][] dist = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.distance, b.distance)
        );
        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int node = cur.node;
            int count = cur.count;
            long d = cur.distance;
            if (d != dist[node][count]) {
                continue;
            }
            if (node == n - 1) {
                return (int) d;
            }
            for (int[] e : graph[node]) {
                int next = e[0];
                int weight = e[1];
                int nextCount;
                if (labels.charAt(node) == labels.charAt(next)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }
                if (nextCount > k) {
                    continue;
                }
                long newDist = d + weight;
                if (newDist < dist[next][nextCount]) {
                    dist[next][nextCount] = newDist;
                    pq.offer(new State(next, nextCount, newDist));
                }
            }
        }
        return -1;
    }
}