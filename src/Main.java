import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] lines = new List[n + 1];
        int[] parents = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            lines[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            lines[n1].add(n2);
            lines[n2].add(n1);
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : lines[now]) {
                if (visit[i]) continue;
                q.offer(i);
                visit[i] = true;
                parents[i] = now;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }
}
