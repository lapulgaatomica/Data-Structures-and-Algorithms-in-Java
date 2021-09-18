package stacks;

import java.util.Arrays;

public class ArrayStackTest {
    public static void main(String[] args) {
        Stack<Integer> s = new ArrayStack<>(); // contents: ()
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

        Integer[] a = {4, 8, 15, 16, 23, 42};
        String[] ss = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("ss = " + Arrays.toString(ss));
        System.out.println("Reversing...");
        reverse(a);
        reverse(ss);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("ss = " + Arrays.toString(ss));
    }

    public static <E> void reverse(E[] a){
        Stack<E> buffer = new ArrayStack<>(a.length);
        for(int i = 0; i < a.length; i++){
            buffer.push(a[i]);
        }
        for(int i = 0; i < a.length; i++){
            a[i] = buffer.pop();
        }
    }
}
