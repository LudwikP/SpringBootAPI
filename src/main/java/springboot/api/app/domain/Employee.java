package springboot.api.app.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    private Long employeeId;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private String jobId;
    private double salary;
    private double commissionPct;
    private int managerId;
    private int departmentId;

}
