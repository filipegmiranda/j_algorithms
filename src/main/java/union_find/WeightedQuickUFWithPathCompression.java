package union_find;

public class WeightedQuickUFWithPathCompression {

    private int id[];
    private int sz[];

    public WeightedQuickUFWithPathCompression(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
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
    }

    public static void main(String... args) {
        WeightedQuickUFWithPathCompression q = new WeightedQuickUFWithPathCompression(10);
        q.union(1,5);
        q.union(3,7);
        q.union(8,9);
        System.out.println("are they connected? " + q.connected(1,9));
        q.union(1,9);
        System.out.println("are they connected now? " + q.connected(1,9));
    }

}
