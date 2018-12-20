package com.ch1.spring.springhibernate.ch18.dao;

import com.ch1.spring.springhibernate.ch18.model.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person p);

    List<Person> list();
}
