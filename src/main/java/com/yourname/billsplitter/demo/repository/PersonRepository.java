package com.yourname.billsplitter.demo.repository;




import com.yourname.billsplitter.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}