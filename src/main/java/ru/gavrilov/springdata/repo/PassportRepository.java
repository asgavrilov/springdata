package ru.gavrilov.springdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrilov.springdata.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
    Passport findByNumber(String number);
}
