package JavaRetakeExam16Dec.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name){
        return this.employees.removeIf(c -> c.getName().equals(name));
    }

    public Employee getOldestEmployee(){
        Employee employee = this.employees.stream()
                .max(Comparator.comparingInt(Employee::getAge)).orElse(null);
        return employee;
    }

    public Employee getEmployee(String name){
        return this.employees
                .stream()
                .filter(e-> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){return this.employees.size();}

    public String report(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Employees working at Bakery ")).append(this.name).append(":").append(String.format("%n"));

        this.employees
                .forEach(employee -> sb
                        .append(employee)
                        .append(System.lineSeparator()));
    return sb.toString();
    }
}
