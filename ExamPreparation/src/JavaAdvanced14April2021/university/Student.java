package JavaAdvanced14April2021.university;

public class Student {
    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    public String firstName;
    public String lastName;
    public String bestSubject;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Student: ").append(String.format("%s %s, %s",this.firstName,this.lastName,this.bestSubject));
        return sb.toString().trim();
    }
}
