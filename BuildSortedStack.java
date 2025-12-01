package ex1;
import unit4.collectionsLib.Stack;
//מגיש: עידן דרור
public class BuildSortedStack {

    // Inserts a number into a sorted stack (smallest value at the top)
    // Implemented exactly as in exercise 18
    public static void smallOnTheTop(Stack<Integer> s, int num) {

        // Temporary stack used to shift elements while finding the correct position
        Stack<Integer> temp = new Stack<>();

        // Move all elements smaller than 'num' into the temporary stack
        while (!s.isEmpty() && s.top() < num) {
            temp.push(s.pop());
        }

        // Insert the new value in its sorted position
        s.push(num);

        // Restore all removed elements back into the original stack
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    // Builds and returns a sorted stack from input values until encountering -999
    public static Stack<Integer> buildSortedStack(int[] input) {

        Stack<Integer> s = new Stack<>();

        // Scan through the input using a regular for-loop
        for (int i = 0; i < input.length; i++) {

            // Stop reading when reaching the termination value
            if (input[i] == -999) {
                break;
            }

            // Insert each number into the sorted stack
            smallOnTheTop(s, input[i]);
        }

        return s;
    }

    // Prints the stack without modifying its logical content
    public static void printStack(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        System.out.print("[");
        boolean first = true;

        // Pop all elements for printing (store them temporarily)
        while (!s.isEmpty()) {
            int x = s.pop();
            temp.push(x);
            if (!first) System.out.print(", ");
            System.out.print(x);
            first = false;
        }

        System.out.println("]");

        // Restore all elements back to the original stack
        while (!temp.isEmpty()) s.push(temp.pop());
    }

    public static void main(String[] args) {

        int[] arr = {30, 10, 25, 5, 20, -999, 100, 200};

        Stack<Integer> result = buildSortedStack(arr);

        printStack(result);
        // expected output: [5, 10, 20, 25, 30]
    }
}


/*
סיבוכיות זמן:
הפעולה קוראת את כל האיברים בקלט עד ה
999-
עבור כל איבר מופעלת הפונקציה
smallOnTheTop 
אשר במקרה הגרוע 
מזיזה את כל איברי המחסנית O(n)

לכן
אם יש 
n 
איברים
מתקבל 
n 
פעמים 
O(n) 
ולכן סיבוכיות הזמן הכוללת היא 
O(n^2)

סיבוכיות מקום:
הפעולה 
smallOnTheTop 
משתמשת במחסנית עזר אחת 
שיכולה להגיע עד גודל 
n

בנוסף,
המחסנית הראשית יכולה להכיל עד 
n 
איברים

לכן סיבוכיות המקום הכוללת היא 
O(n)

*/
