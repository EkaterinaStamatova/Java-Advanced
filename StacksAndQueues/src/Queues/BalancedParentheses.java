package Queues;
import java.util.Scanner;
import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char ch;
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        boolean areBalanced = false;

        for (int index = 0; index < input.toCharArray().length; index++) {
            char currentBracket = input.charAt(index);
            //проверка дали скобата е отворена -> {, [, (
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openBrackets.push(currentBracket);
            } //проверка дали скобата е затворена
            else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                //currentBracket -> затворена скоба
                //проверка дали тази затворена скоба съвпада с послендата отворена
                if (openBrackets.isEmpty()) { //нямам отворени скоби
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = openBrackets.pop(); //последната отворена скоба
                //отворена ( и затворена )
                if (lastOpenBracket == '(' && currentBracket == ')') {
                    //balance
                    areBalanced = true;
                }
                //отворена { и затворена }
                else if (lastOpenBracket == '{' && currentBracket == '}') {
                    //balance
                    areBalanced = true;
                }
                //отворена [ и затворена ]
                else if (lastOpenBracket == '[' && currentBracket == ']') {
                    //balance
                    areBalanced = true;
                } else {
                    //no balance
                    areBalanced = false;
                    break;
                }
            }
        }
        //проверка дали имаме баланс при всички скоби
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
