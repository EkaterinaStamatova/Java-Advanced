package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new LinkedList<>();
        HashMap<String, List<Employee>> departments = new HashMap<>();
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] employeeInformation = scanner.nextLine().split(" ");

            String name = employeeInformation[0];
            double salary = Double.parseDouble(employeeInformation[1]);
            String position = employeeInformation[2];
            String department = employeeInformation[3];
            String email = "n/a";
            int age = -1;
            Employee employee = null;


            if (employeeInformation.length >= 5) {
                email = employeeInformation[4];
            }
            if (employeeInformation.length == 6) {
                age = Integer.parseInt(employeeInformation[5]);
            }

            employee = new Employee(name, salary, position, department, email, age);

            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }

            String maxAverageSalaryDepartment = departments.entrySet()
                    .stream()
                    .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                    .get()
                    .getKey();

            System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);
            List<Employee> employeeList = departments.get(maxAverageSalaryDepartment);
            employeeList.sort(Comparator.comparingDouble(emp->emp.getSalary()));
            Collections.reverse(employeeList);

            for (Employee e:
                 employeeList) {
                System.out.println(e);
            }
        }
    public static double getAverageSalary(List<Employee> employees){
        int sum = 0;
        for (Employee employee:
             employees) {
            sum+=employee.getSalary();
        }
        return sum/employees.size();
    }
}
