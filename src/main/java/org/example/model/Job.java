package org.example.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Job")
@Table(name = "jobs ",
        uniqueConstraints = {
                @UniqueConstraint(name = "job_title_unique", columnNames = "job_title")
        })
public class Job {

    @Id
    @SequenceGenerator(
            name = "job_sequence",
            sequenceName = "job_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "job_sequence"
    )
    @Column(name = "job_id",
            updatable = false)
    private long id;

    @Column(name = "job_title", nullable = false, columnDefinition = "TEXT")
    public String jobTitle;

    @Column(name = "min_salary", precision = 2)
    public double minSalary;

    @Column(name = "max_salary", precision = 2)
    public double maxSalary;

    public Job() {

    }

    public Job(long id, String jobTitle, double minSalary, double maxSalary) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Job(String jobTitle, double minSalary, double maxSalary) {
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
