package union_find;

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String... args) {
        QuickFindUF q = new QuickFindUF(10);
        q.union(1,5);
        q.union(3,7);
        q.union(8,9);
        System.out.println("are they connected? " + q.connected(1,9));
        q.union(1,9);
        System.out.println("are they connected now? " + q.connected(1,9));
    }

}
