public class Main {
    public static void main(String[] args) {
        Solutions sol = new Solutions();

        int[][] tests = {
            {1,1},
            {100,100},
            {1,100,100},
            {1,100,99,100},
            {100,1,100,100},
            {100,1,100,100,5},
        };
        
        for (int[] test : tests) {
            System.out.println(sol.scores100(test));
        }
    }
}
