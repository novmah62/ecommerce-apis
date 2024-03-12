package com.novmah.userservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"user"})
public class Address extends AbstractMappedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "full_address", unique = true)
    private String fullAddress;

    @Column(name = "postal_code")
    private String postalCode;

    private String city;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
