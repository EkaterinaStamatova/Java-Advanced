package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    private String name;
    private int capacity;

    public void addEmployee(Employee employee){
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        return this.employees.removeIf(c -> c.getName().equals(name));
    }

    public Employee getOldestEmployee(){
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
    }

    public Employee getEmployee(String name){
        return this.employees
                .stream()
                .filter(e-> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:%n",this.name));
        this.employees
                .forEach(e-> sb
                        .append(String.format("Employee: %s", e))
                .append(System.lineSeparator()));
        return sb.toString();
    }



}
