package ru.gavrilov.springdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gavrilov.springdata.entity.Address;
import ru.gavrilov.springdata.entity.Person;
import ru.gavrilov.springdata.repo.AddressRepository;
import ru.gavrilov.springdata.repo.PersonRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerRelationsTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void inverseEndTest() {
        List<Person> people = personRepository.findByFirstName("Anna");
        Person anna = people.get(0);
        anna.setLastName("Kuznetsova");
        anna.setAddresses(List.of(new Address("Vologda")));
        personRepository.save(anna);
    }

    @Test
    public void ownerTest() {
        List<Address> cities = addressRepository.findByCity("Samara");
        Address samara = cities.get(0);

        samara.setHouseNumber("17");
        samara.setPerson(new Person("Alex", "Semenov"));

        addressRepository.save(samara);
    }
}
