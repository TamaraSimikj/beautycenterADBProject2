package com.adb.beautycenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Client {

    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String cName;

    @Column(nullable = false, length = 100)
    private String surname;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 100)
    private String eMail;

    @Column
    private Integer numberOfApp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "clientUser")
    private Set<LoyaltyClub> clientUserLoyaltyClubs;

    @OneToMany(mappedBy = "clientUser")
    private Set<Appointment> clientUserAppointments;

    @OneToMany(mappedBy = "clientUser")
    private Set<Review> clientUserReviews;

}
