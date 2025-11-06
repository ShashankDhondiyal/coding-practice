public class Main {
    public static void main(String[] args) {
        Solutions sol = new Solutions();

        int[][] tests = {
            {1,2},
            {1,2,3,4,5},
            {5,4,3,2,1},
        };
        
        for (int[] test : tests) {
            System.out.println(sol.scoresIncreasing(test));
        }
    }
}
