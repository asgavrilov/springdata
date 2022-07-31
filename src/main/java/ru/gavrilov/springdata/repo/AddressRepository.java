package ru.gavrilov.springdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gavrilov.springdata.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCity(String city);
}
