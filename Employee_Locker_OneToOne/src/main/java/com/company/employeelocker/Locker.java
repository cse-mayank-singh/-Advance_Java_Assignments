package com.company.employeelocker;
import jakarta.persistence.*;

@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lockerNumber;
    private int floor;

    public Locker() {}

    public Locker(String lockerNumber, int floor) {
        this.lockerNumber = lockerNumber;
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    public int getFloor() {
        return floor;
    }
}
