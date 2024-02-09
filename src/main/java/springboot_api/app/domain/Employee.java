package springboot_api.app.domain;

import javax.persistence.*;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employees_sq",
            sequenceName = "employees_sq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employees_sq"
    )
    @Column(name = "id",
            updatable = false)
    private Long employeeId;

    @Column(name = "last_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "first_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT")
    private String email;

    @Column(name = "phone_number",
            nullable = false,
            columnDefinition = "TEXT")
    private String phoneNumber;

    @Column(name = "hire_date")
    private String hireDate;

    @Column(name = "job_id",
            insertable = false,
            updatable = false)
    private int jobId;

    @Column(name = "salary")
    private double salary;

    @Column(name = "job_id")
    private int managerId;

    @Column(name = "department_id")
    private int departmentId;

    public Employee(String lastName, String firstName, String email, String phoneNumber, String hireDate, int jobId, double salary, int managerId, int departmentId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
