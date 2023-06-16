package com.adb.beautycenter.model;

import com.adb.beautycenter.model.Appointment;
import com.adb.beautycenter.model.CreditCard;
import com.adb.beautycenter.model.InStore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Payment {

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

    @Column
    private String paymentInfo;

    @ManyToMany
    @JoinTable(
            name = "online",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "credit_card_id")
    )
    private Set<CreditCard> onlineCreditCards;

    @OneToMany(mappedBy = "payment")
    private Set<InStore> paymentInStores;

    @OneToMany(mappedBy = "payment")
    private Set<Appointment> paymentAppointments;

}
