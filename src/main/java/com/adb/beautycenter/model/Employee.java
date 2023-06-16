package com.adb.beautycenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Employee {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String eName;

    @Column(nullable = false, length = 100)
    private String surname;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 100)
    private String eMail;

    @Column
    private Integer experience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beauty_center_id", nullable = false)
    private Beautycenter beautyCenter;

    @ManyToMany
    @JoinTable(
            name = "employee_role",
            joinColumns = @JoinColumn(name = "e_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> employeeRoleRoles;

    @OneToMany(mappedBy = "employeeUser")
    private Set<Manager> employeeUserManagers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_employee_user_id")
    private Manager managerEmployeeUser;

    @ManyToMany
    @JoinTable(
            name = "employee_certificate",
            joinColumns = @JoinColumn(name = "e_name"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Certificate> employeeCertificateCertificates;

    @ManyToMany
    @JoinTable(
            name = "employee_service",
            joinColumns = @JoinColumn(name = "e_name"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Service> employeeServiceServices;

    @OneToMany(mappedBy = "employeeUser")
    private Set<BookingTime> employeeUserBookingTimes;

    @OneToMany(mappedBy = "employeeUser")
    private Set<Appointment> employeeUserAppointments;

}
