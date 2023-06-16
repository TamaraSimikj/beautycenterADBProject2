package com.adb.beautycenter.model;

import com.adb.beautycenter.model.Appointment;
import com.adb.beautycenter.model.Employee;
import com.adb.beautycenter.model.Manager;
import com.adb.beautycenter.model.Price;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Service {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false, length = 100)
    private String serviceCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_employee_user_id", nullable = false)
    private Manager managerEmployeeUser;

    @OneToMany(mappedBy = "service")
    private Set<Price> servicePrices;

    @ManyToMany(mappedBy = "employeeServiceServices")
    private Set<Employee> employeeServiceEmployees;

    @ManyToMany(mappedBy = "appointmentServiceServices")
    private Set<Appointment> appointmentServiceAppointments;

}
