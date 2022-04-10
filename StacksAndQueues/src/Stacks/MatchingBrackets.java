package Stacks;
import java.util.Scanner;
import java.util.*;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  equation = scanner.nextLine();
        char ch;
        ArrayDeque<Integer> calculator = new ArrayDeque<>();

        for(int i=0; i< equation.toCharArray().length; i++){
            ch = equation.charAt(i);
            if(ch == '('){
                calculator.push(i);
            }else if(ch==')'){
                int startIndex = calculator.pop();
                String contents = equation.substring(startIndex, i+1);
                System.out.println(contents);
            }
        }
    }
}
