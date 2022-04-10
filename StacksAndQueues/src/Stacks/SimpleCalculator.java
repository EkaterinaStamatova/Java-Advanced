package Stacks;
import java.util.Scanner;
import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] equation = scanner.nextLine().split(" ");

        ArrayDeque<String> calculator = new ArrayDeque<>();
        Collections.addAll(calculator,equation);

        while(calculator.size()>1){
            int firstNumber = Integer.parseInt(calculator.pop());
            String operator = calculator.pop();
            int secondNumber = Integer.parseInt(calculator.pop());
            int result = 0;

            if(operator.equals("+")){
                result=firstNumber+secondNumber;
            }else{
                result=firstNumber-secondNumber;
            }
            calculator.push(String.valueOf(result));
        }
        System.out.println(calculator.peek());
    }
}
