import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(fibonacci(number+1));

    }

    static int fibonacci(int n)
    {
        if (n <= 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}


