public class Main {
    public static void main(String[] args) {
        CodingBat cb = new CodingBat();
        LeetCode lc = new LeetCode();

        System.out.println(lc.isValid("()"));
        System.out.println(lc.isValid("()[]{}"));   
        System.out.println(lc.isValid("(]"));
        System.out.println(lc.isValid("([])"));
        System.out.println(lc.isValid("([)]"));
        System.out.println(lc.isValid("["));
        System.out.println(lc.isValid("(("));
        System.out.println(lc.isValid("){"));

    }
}
