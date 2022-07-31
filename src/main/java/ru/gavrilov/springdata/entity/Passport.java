package ru.gavrilov.springdata.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Passport {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String number;

    @OneToOne(mappedBy = "passport", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Person person;

}
