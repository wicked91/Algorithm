## Dijkstra Algorithm
- 시간복잡도
    - 우선순위 큐를 사용하지 않을 때 : O(|V|^2 + |E|)
    - 우선순위 큐를 사용할 때 : O(|E|log|V|)

```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

class Node {
	int index, distance;

	public Node(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}
}

class Main {

	static int N, M, Start;
	static int dist[];
	static Vector<Node> V[];
	static int INF = Integer.MAX_VALUE;

	public static void Dijkstra() {

		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.distance > o1.distance ? -1 : 1;
			}
		});
		Arrays.fill(dist, INF);
		dist[Start] = 0;
		pq.offer(new Node(Start, dist[Start]));

		while (!pq.isEmpty()) {
			int I = pq.peek().index;
			int D = pq.peek().distance;
			pq.poll();

			if (dist[I] < D)
				continue;

			for (Node next : V[I]) {
				int nextIndex = next.index;
				int nextDistance = next.distance;

				if (dist[nextIndex] > dist[I] + nextDistance) {
					dist[nextIndex] = dist[I] + nextDistance;
					pq.offer(new Node(nextIndex, dist[nextIndex]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Start = Integer.parseInt(br.readLine());
		V = new Vector[N + 1];
		dist = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			V[i] = new Vector<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				V[s].add(new Node(e, d));
			}
		}

		Dijkstra();
		for (int i = 1; i <= N; i++) {
			System.out.println(dist[i] == INF ? "INF" : dist[i]);
		}
	}
}
```