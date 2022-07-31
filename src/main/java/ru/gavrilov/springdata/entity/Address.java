package ru.gavrilov.springdata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @NonNull
    private String city;
    private String street;
    private String houseNumber;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "person_id")
    private Person person;


}
