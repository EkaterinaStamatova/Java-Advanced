package CompanyRoster;

public class Employee {
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    private String name;
    private String position;
    private String department;
    private String email;

    private double  salary;

    private int age;


    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(name + " ").append(String.format("%.2f",salary) + " ").append(email + " ").append(age);

        return builder.toString();
    }


}
