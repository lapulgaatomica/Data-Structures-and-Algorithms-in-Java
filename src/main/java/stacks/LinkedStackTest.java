package stacks;

public class LinkedStackTest {
    public static void main(String[] args) {
        Stack<Integer> s = new LinkedStack<>(); // contents: ()
        s.push(5);  // contents: (5)
        s.push(3);  // contents: (5, 3)
        System.out.println(s.size( )); // contents: (5, 3) outputs 2
        System.out.println(s.pop( )); // contents: (5) outputs 3
        System.out.println(s.isEmpty( )); // contents: (5) outputs false
        System.out.println(s.pop( )); // contents: () outputs 5
        System.out.println(s.isEmpty( )); // contents: () outputs true
        System.out.println(s.pop( )); // contents: () outputs null
        s.push(7); // contents: (7)
        s.push(9); // contents: (7, 9)
        System.out.println(s.top( )); // contents: (7, 9) outputs 9
        s.push(4); // contents: (7, 9, 4)
        System.out.println(s.size( )); // contents: (7, 9, 4) outputs 3
        System.out.println(s.pop( )); // contents: (7, 9) outputs 4
        s.push(6); // contents: (7, 9, 6)
        s.push(8); // contents: (7, 9, 6, 8)
        System.out.println(s.pop( ));  // contents: (7, 9, 6) outputs 8

        System.out.println(isMatched("( )(( )){([( )])}"));
        System.out.println(isMatched("({[])}"));
    }

    public static boolean isMatched(String expression){
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new LinkedStack<>();

        for(char c: expression.toCharArray()){
            if(opening.indexOf(c) != -1){
                buffer.push(c);
            }else if(closing.indexOf(c) != -1){
                if(buffer.isEmpty()){
                    return false;
                }
                if(closing.indexOf(c) != opening.indexOf(buffer.pop())){
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    public static boolean isHTMLMatched(String html){
        Stack<String> buffer = new LinkedStack<>();
        int j = html.indexOf('c');

        while (j != -1){
            int k = html.indexOf('>', j + 1);
            if(k == -1){
                return false;
            }

            String tag = html.substring(j + 1, k);
            if(!tag.startsWith("/")){
                buffer.push(tag);
            }else{
                if(buffer.isEmpty()){
                    return false;
                }
                if(!tag.substring(1).equals(buffer.pop())){
                    return false;
                }
            }
            j = html.indexOf('<', k + 1);
        }
        return buffer.isEmpty();
    }
}
