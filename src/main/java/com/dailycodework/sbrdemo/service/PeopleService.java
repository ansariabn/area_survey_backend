package com.dailycodework.sbrdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodework.sbrdemo.exception.PeopleAlreadyExistsException;
import com.dailycodework.sbrdemo.exception.PeopleNotFoundException;
import com.dailycodework.sbrdemo.model.Peoples;
import com.dailycodework.sbrdemo.repository.PeopleRepository;

@Service
public class PeopleService implements IPeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

	@Override
    public List<Peoples> getPeople() {
        return peopleRepository.findAll();
    }
    @Override
    public Peoples addPeople(Peoples peoples) {
        if (PeopleAlreadyExists(peoples.getEmail())){
            throw  new PeopleAlreadyExistsException(peoples.getEmail()+ " already exists!");
        }
        return peopleRepository.save(peoples);
    }


    @Override
    public Peoples updatePeople(Peoples peoples, Long id) {
        return peopleRepository.findById(id).map(st -> {
            st.setFirstName(peoples.getFirstName());
            st.setLastName(peoples.getLastName());
            st.setEmail(peoples.getEmail());
            st.setAddress(peoples.getAddress());
            st.setMobileNumber(peoples.getMobileNumber());
            return peopleRepository.save(st);
        }).orElseThrow(() -> new PeopleNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Peoples getPeopleById(Long id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException("Sorry, no student found with the Id :" +id));
    }

    @Override

    public void deletePeople(Long id) {
        if (!peopleRepository.existsById(id)){
            throw new PeopleNotFoundException("Sorry, student not found");
        }
        peopleRepository.deleteById(id);
    }
    private boolean PeopleAlreadyExists(String email) {
        return peopleRepository.findByEmail(email).isPresent();
    }
}
