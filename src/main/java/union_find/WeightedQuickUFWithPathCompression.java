package union_find;

public class WeightedQuickUFWithPathCompression {

    private int id[];
    private int sz[];
    private int highest[];

    public WeightedQuickUFWithPathCompression(int n) {
        id = new int[n];
        sz = new int[n];
        highest = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
            highest[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        int r = root(p);
        int g = (p > q ? p : q);
        if (highest[r] < g) {
            highest[r] = g;
        }
    }

    public int find(int i) {
        int index = root(i);
        return highest[index];
    }

    public static void main(String... args) {
        WeightedQuickUFWithPathCompression q = new WeightedQuickUFWithPathCompression(10);
        q.union(1,5);
        q.union(3,7);
        System.out.println("The largest element in the tree 3-7 is " + q.find(7));
        q.union(8,9);
        System.out.println("are they connected? " + q.connected(1,9));
        System.out.println("=============");
        System.out.println("largest element in the tree containing 1 is " + q.find(1));
        q.union(1,9);
        System.out.println("largest element in the tree containing 1 after 9 is added is " + q.find(1));
        System.out.println("are they connected now? " + q.connected(1,9));
    }

}
