package student;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String personalCode;
    private String registrationDateTime;

    public Student(String firstName, String lastName, String email, String personalCode, String registrationDateTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationDateTime = registrationDateTime;
    }

    public String toCsv() {
        return firstName + "," +
           lastName + "," +
           email + "," +
           personalCode + "," +
           registrationDateTime;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDateTime() {
        return registrationDateTime;
    }

    public void editStudent(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
