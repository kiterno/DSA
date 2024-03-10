package design.pattern.builder;

public class App {
    public static void main(String[] args) {
        Person person = new Person.Builder("Dheerendra", "dheerendra@gmail.com").setAge(25).build();
        System.out.println(person);
        System.out.println();

        Student student = new Student.Builder("Dheerendra", "IIT Dhanbad").setAge(25).build();
        System.out.println(student);

        Company company = new Company.Builder("Expedia", "Flight").setTurnover(2200).build();
        System.out.println(company);

        Department department = new Department.Builder(1).setName("Electronics").setDescription("ECE branch").build();
        System.out.println(department);
    }
}
