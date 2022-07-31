package ru.gavrilov.springdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gavrilov.springdata.entity.Passport;
import ru.gavrilov.springdata.entity.Person;
import ru.gavrilov.springdata.repo.PassportRepository;
import ru.gavrilov.springdata.repo.PersonRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonRepositoryTest{

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PassportRepository passportRepository;

    @Test
    void findByFirstName() {
        List<Person> pers = personRepository.findByFirstName("Anna");

        assertThat(pers).hasSize(1);
        assertThat(pers.get(0).getLastName()).isEqualTo("Gavr");
    }

    @Test
    void findAllOrderedByFirstName() {
        List<Person> people = personRepository.findAllOrderedByFirstName();

        assertThat(people).hasSize(3);
        assertThat(people.get(2).getFirstName()).isEqualTo("Igor");
        assertThat(people.get(1).getFirstName()).isEqualTo("Anna");

    }

    @Test
    void deletePassport() {
        Passport passport = passportRepository.findByNumber("09876545");
        passportRepository.delete(passport);

        List<Person> people = personRepository.findAll();
        assertThat(people).hasSize(2);
    }
}
