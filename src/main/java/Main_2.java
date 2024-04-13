import java.util.Scanner;

public class Main_2 {

    static int n, k;
    static int[][] graph;
    static int maxCost = 0;
    static String path = "";
    static int minFuel = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n][n];

        for (int i=0; i<m; i++){
            int a = sc.next().charAt(0) - 'A';
            int b = sc.next().charAt(0) - 'A';
            int d = sc.nextInt();

            graph[a][b] = d;
            graph[b][a] = d;
        }

        dfs(new Node(0, 100, k, "A"));

        if (path.isEmpty())
            System.out.println("-1");
        else System.out.println(path + " " + maxCost + " " + minFuel);
    }

    static void dfs(Node node) {

        if (node.town == n - 1){
            if (node.cost > maxCost || (node.cost == maxCost && node.fuel < minFuel)){
                maxCost = node.cost;
                path = node.path;
                minFuel = node.fuel;
            }

            return;
        }

        for (int i=0; i<n; i++){
            if (graph[node.town][i] != 0 && node.fuel >= graph[node.town][i]){
                int nextFuel = node.fuel - graph[node.town][i];
                int nextCost = node.cost + 200;

                if (i != n-1)
                    nextFuel += 10;
                else nextCost += 100;

                if(nextFuel >= 0) {
                    dfs(new Node(i, nextCost, nextFuel, node.path + (char) ('A' + i)));
                }
            }
        }
    }
}

class Node{
    int town;
    int cost;
    int fuel;
    String path;

    public Node(int town, int cost, int fuel, String path) {
        this.town = town;
        this.cost = cost;
        this.fuel = fuel;
        this.path = path;
    }
}
