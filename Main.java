public class Main {
    public static void main(String[] args) {
        Solutions sol = new Solutions();

        String[] test = {"a", "bb", "b", "ccc"};
        System.out.println(sol.wordsCount(test, 1));
        System.out.println(sol.wordsCount(test, 3));
        System.out.println(sol.wordsCount(test, 4));
    }
}
