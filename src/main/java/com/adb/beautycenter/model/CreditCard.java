package com.adb.beautycenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class CreditCard {

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

    @Column(nullable = false, length = 18)
    private String cardNumber;

    @Column(nullable = false, length = 100)
    private String cardholderName;

    @Column(nullable = false, length = 3)
    private String cvv;

    @Column(nullable = false, length = 5)
    private String expiryDate;

    @ManyToMany(mappedBy = "onlineCreditCards")
    private Set<Payment> onlinePayments;

}
