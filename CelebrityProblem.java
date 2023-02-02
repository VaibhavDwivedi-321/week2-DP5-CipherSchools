import java.util.Stack;

public class CelebrityProblem {
    public static int findCelebrity(int[][] relations) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < relations.length; i++) {
            stack.push(i);
        }
        int a = 0, b = 0;
        while (stack.size() > 1) {
            a = stack.pop();
            b = stack.pop();
            if (knows(relations, a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int c = stack.pop();
        for (int i = 0; i < relations.length; i++) {
            if (i != c && (knows(relations, c, i) || !knows(relations, i, c))) {
                return -1;
            }
        }
        return c;
    }
    
    private static boolean knows(int[][] relations, int a, int b) {
        return relations[a][b] == 1;
    }
    public static void main(String[] args) {
        int[][] relations = {{0, 0, 1, 0}, 
                             {0, 0, 1, 0}, 
                             {0, 0, 0, 0}, 
                             {0, 0, 1, 0}};
        int celebrity = CelebrityProblem.findCelebrity(relations);
        if (celebrity == -1) {
            System.out.println("No Celebrity Found");
        } else {
            System.out.println("Celebrity: " + celebrity);
        }
    }
    
}
