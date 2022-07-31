package ru.gavrilov.springdata.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Phone {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @NonNull
    @Column
    private String number;


    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
