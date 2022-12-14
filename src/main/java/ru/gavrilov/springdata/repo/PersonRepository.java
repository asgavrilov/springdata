package ru.gavrilov.springdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gavrilov.springdata.entity.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFirstName(String firstName);

    @Query("select p from Person p order by firstName")
    List<Person> findAllOrderedByFirstName();
}
