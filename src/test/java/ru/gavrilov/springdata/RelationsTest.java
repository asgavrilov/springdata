package ru.gavrilov.springdata;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gavrilov.springdata.entity.Address;
import ru.gavrilov.springdata.entity.Person;
import ru.gavrilov.springdata.repo.AddressRepository;
import ru.gavrilov.springdata.repo.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RelationsTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test(expected = LazyInitializationException.class)
    public void lazyLoadingException() throws Exception {
        List<Person> anna = personRepository.findByFirstName("Anna");
        //session closed

        log.info(anna.get(0).getPhones().toString());
    }

    @Test
    @Transactional
    public void lazyLoadingTransactional() {
        List<Person> anna = personRepository.findByFirstName("Anna");


        log.info(anna.get(0).getPhones().toString());
    }

    @Test
    public void deleteAddress() {
        List<Address> cities = addressRepository.findByCity("Samara");
        assertThat(cities).hasSize(1);
        addressRepository.delete(cities.get(0));

        List<Person> people = personRepository.findAll();
        assertThat(people).hasSize(2);
    }

    @Test
    public void deletePerson() {
        List<Person> igor = personRepository.findByFirstName("Igor");
        personRepository.delete(igor.get(0));
        List<Address> addresses = addressRepository.findAll();
        assertThat(addresses).hasSize(2);
    }

    @Test
    public void fetchTypeLoading(){
        List<Person> people = personRepository.findAll();
    }}
