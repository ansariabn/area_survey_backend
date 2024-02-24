package com.dailycodework.sbrdemo.service;

import com.dailycodework.sbrdemo.model.Peoples;

import java.util.List;



public interface IPeopleService {

    Peoples addPeople(Peoples peoples);
    List<Peoples> getPeople();
    Peoples updatePeople(Peoples peoples, Long id);
    Peoples getPeopleById(Long id);
    void deletePeople(Long id);

}
