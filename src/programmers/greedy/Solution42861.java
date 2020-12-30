package programmers.greedy;

import java.util.PriorityQueue;

public class Solution42861 {
	class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;

		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		// cost 기준으로 오름차순 정렬
		@Override
		public int compareTo(Edge o){
			return this.cost - o.cost;
		}
	}

	static int[] parent;
	static PriorityQueue<Edge> adj;

	public int solution(int n, int[][] costs) {

		int answer = 0;
		parent = new int[n];
		adj = new PriorityQueue<>();

		for (int[] cost : costs) {
			Edge edge = new Edge(cost[0], cost[1], cost[2]);
			adj.offer(edge);
		}

		for(int i = 0 ; i < n ; ++i) {
			parent[i] = i;
		}

		while(!adj.isEmpty()) {
			Edge edge = adj.poll();

			if(find(edge.from) != find(edge.to)) { // 싸이클이 없는 경우
				union(edge.from, edge.to); //  연결해주고
				answer += edge.cost; // 비용 더하기
			}
		}

		return answer;
	}

	// union-find (합집합 찾기): 두 개의 정점이 같은 부모로 연결되어있는지 확인할 수 있는 알고리즘
	// 각 정점마다, 가지고있는 최상위 부모 노드를 기록한다.
	// 정점 2가 1 의부모를 가지고 있다면 parent[2] = 1 ; 과같이 표현
	public int find(int n){
		if(parent[n] == n) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	public void union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);

		if(rootA != rootB) {
			parent[rootB] = rootA;
		}
	}
}
