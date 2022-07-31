package ru.gavrilov.springdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gavrilov.springdata.entity.Address;
import ru.gavrilov.springdata.entity.Passport;
import ru.gavrilov.springdata.entity.Person;
import ru.gavrilov.springdata.entity.Phone;
import ru.gavrilov.springdata.repo.PassportRepository;
import ru.gavrilov.springdata.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Person anna = new Person("Anna", "Gavr", "Samara");
        Person igor = new Person("Igor", "Gavr", "Moscow");

        Passport passportAnna = new Passport("12443576");
        Passport passportIgor = new Passport("09876545");

        Address address1 = new Address("Samara");
        Address address2 = new Address("Spb");
        Address address3 = new Address("Novosibisrk");
        Address address4 = new Address("Moscow");

        Phone phoneAnna1 = new Phone("123-444-555");
        Phone phoneAnna2 = new Phone("123-444-666");

        Phone phoneIgor1 = new Phone("123-333-777");
        Phone phoneIgor2 = new Phone("123-333-888");

        anna.setPassport(passportAnna);
        anna.setPhones(List.of(phoneAnna1, phoneAnna2));
        anna.setAddresses(List.of(address1, address2));

        igor.setPassport(passportIgor);
        igor.setPhones(List.of(phoneIgor1, phoneIgor2));
        igor.setAddresses(List.of(address3, address4));

        List<Person> personList = List.of(anna, igor);
        personRepository.saveAll(personList);

        log.info(">>>>>" + personRepository.findAll());

    }
}
