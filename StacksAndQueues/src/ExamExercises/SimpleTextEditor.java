package ExamExercises;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Arrays;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();

        for (int i = 0; i < numberOfOperations; i++) {
            String command = scanner.nextLine();

            //"1 {string}".split(" ") -> ["1", "{string}"]
            //"2 {count}".split(" ") -> ["2", "{count}"]
            //"3 {index}".split(" ") -> ["3", "{index}"]
            //"4".split(" ") -> ["4"]

            int commandNumber = Integer.parseInt(command.split("\\s+")[0]);// 1, 2, 3, 4
            switch (commandNumber) {
                case 1:
                    textStack.push(currentText.toString());
                    String stringForAppend = command.split("\\s+")[1];
                    //трябва да добавя stringForAppend към сегашния текст
                    currentText.append(stringForAppend);
                    break;
                case 2:
                    textStack.push(currentText.toString());
                    int countElementsForDelete = Integer.parseInt(command.split("\\s+")[1]);
                    //изтриваме countElementsForDelete брой елементи
                    //"abcd"
                    int startIndexForDelete = currentText.length() - countElementsForDelete;
                    currentText.delete(startIndexForDelete, currentText.length());
                    break;
                case 3:
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    //печатаме елемента на дадения индекс
                    System.out.println(currentText.charAt(index - 1));
                    break;
                case 4:
                    if (!textStack.isEmpty()) {
                        currentText = new StringBuilder(textStack.pop());
                    }
                    break;
            }
        }
    }
}
