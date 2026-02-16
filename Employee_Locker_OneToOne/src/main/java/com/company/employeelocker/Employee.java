package com.company.employeelocker;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locker_id",
                nullable = false,
                unique = true)
    private Locker locker;

    public Employee() {}

    public Employee(String name, String department, Locker locker) {
        this.name = name;
        this.department = department;
        this.locker = locker;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Locker getLocker() {
        return locker;
    }
}
