public class Main {
    public static void main(String[] args) {
        CodingBat cb = new CodingBat();
        LeetCode lc = new LeetCode();

        TreeNode myTree = new TreeNode(2);
        myTree.left = new TreeNode(1);
        myTree.right = new TreeNode(3, new TreeNode(0), new TreeNode(1));

        TreeNode myTree2 = new TreeNode(0);

        TreeNode myTree3 = new TreeNode(3);
        myTree3.left = new TreeNode(1);
        myTree3.right = new TreeNode(3, new TreeNode(0), new TreeNode(0));

        System.out.println(lc.evaluateTree(myTree));
        System.out.println(lc.evaluateTree(myTree2));
        System.out.println(lc.evaluateTree(myTree3));
    }
}
