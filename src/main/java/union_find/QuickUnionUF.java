package union_find;

public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while(i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootp = root(p);
        id[rootp] = root(q);
    }

    public static void main(String... args) {
        QuickUnionUF q = new QuickUnionUF(10);
        q.union(1,5);
        q.union(3,7);
        q.union(8,9);
        System.out.println("are they connected? " + q.connected(1,9));
        q.union(1,9);
        System.out.println("are they connected now? " + q.connected(1,9));
    }

}
