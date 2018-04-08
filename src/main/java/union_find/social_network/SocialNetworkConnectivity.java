package union_find.social_network;

import main.java.union_find.WeightedQuickUFWithPathCompression;

public class SocialNetworkConnectivity {

    private WeightedQuickUFWithPathCompression uf;
    private int connections;

    public SocialNetworkConnectivity(int n) {
        uf = new WeightedQuickUFWithPathCompression(n);
        connections = n;
    }

    public void addFriendship(int f1, int f2) {
        if (!uf.connected(f1, f2)) {
            connections--;
        }
        uf.union(f1,f2);
    }

    public boolean allConnected() {
        return connections == 1;
    }


    public static void main(String... args) {
        SocialNetworkConnectivity socialNetworkConnectivity = new SocialNetworkConnectivity(10);


        //for simplication we use here 2 dimensional array
        int n = 14; //nr entries in the log file

        int[][] logFile = new int[][] {
                {1,0,1}, // the first element having a number represents the hour, so in this case 1pm
                {2,1,2},
                {3,2,3},
                {4,3,4},
                {5,4,5},
                {6,5,6},
                {7,6,7},
                {8,7,8},
                {9,2,4},
                {10,6,1},
                {11,1,8},
                {12,5,6},
                {13,8,9},
                {14,9,1},
        };  // This array has a size of 14 (the above n declaration)

        //validate sizes
        validateManualArrayCreation(n, logFile);

        for (int i = 0; i < n; i++) {
            socialNetworkConnectivity.addFriendship(logFile[i][1], logFile[i][2]);
            if (socialNetworkConnectivity.allConnected()) {
                System.out.println("All friends are connected (a friend is a friend of a friend, of a friend, ...) at time " + logFile[i][0]);
                return;
            }
        }

    }

    private static void validateManualArrayCreation(int n, int[][] arrayLogFile) {
        if (n != arrayLogFile.length) {
            throw new IllegalStateException("the array created manually has not the same size as n - fix this! variable N has size " + n + " array has size " + arrayLogFile.length);
        }
    }

}
