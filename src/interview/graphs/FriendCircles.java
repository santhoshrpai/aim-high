package interview.graphs;

/**
 * @author rajasan
 */
public class FriendCircles {

    public static void main(String[] args) {
        char[][] g = { { 'Y', 'Y', 'N', 'N' }, { 'Y', 'Y', 'Y', 'N' }, { 'N', 'Y', 'Y', 'N' },
                { 'N', 'N', 'N', 'Y' } };

        char[][] g1 = { { 'Y', 'N', 'N', 'N', 'N' }, { 'N', 'Y', 'N', 'N', 'N' }, { 'N', 'N', 'Y', 'N', 'N' },
                { 'N', 'N', 'N', 'Y', 'N' }, { 'N', 'N', 'N', 'N', 'Y' } };

        //        char[][] g1 = {};

        String[] friends = new String[4];

        friends[0] = "YYNN";
        friends[1] = "YYYN";
        friends[2] = "NYYN";
        friends[3] = "NNNY";

        System.out.println(findFriends(friends));

    }

    public static int findFriends(String[] friends) {

        if (friends == null || friends.length == 0) {
            return 0;
        }

        // 1. Since the friends can be directly or indirectly related, we can see which students
        // are connected to each other in a depth first search way.
        // 2. We can easily implement a DFS over the 2D interview.array here and return the count of
        // connected students.

        // Converting the interview.string interview.array into a 2D character interview.array for the easy traverse.
        int len = friends.length;
        char[][] friendsMatrix = new char[len][len];
        int k = 0;
        int l = 0;
        for (String s : friends) {
            if (s.length() != len) {
                return 0;
            }
            for (Character c : s.toCharArray()) {
                if (c == 'Y' || c == 'N') {
                    friendsMatrix[k][l++] = c;
                } else {
                    return 0;
                }
            }
            k++;
            l = 0;
        }

        // keep track of the students who are already considered in the direct/indirect connections
        int[] connectedStudents = new int[friendsMatrix.length];
        int count = 0;
        for (int i = 0; i < friendsMatrix.length; i++) {
            if (connectedStudents[i] == 0) {
                findFriends(friendsMatrix, connectedStudents, i);
                count++;
            }
        }
        return count;
    }

    static void findFriends(char[][] friendsMatrix, int[] connectedStudents, int i) {
        for (int j = 0; j < friendsMatrix.length; j++) {
            if (friendsMatrix[i][j] == 'Y' && connectedStudents[j] == 0) {
                connectedStudents[j] = 1;
                findFriends(friendsMatrix, connectedStudents, j);
            }
        }
    }
}
