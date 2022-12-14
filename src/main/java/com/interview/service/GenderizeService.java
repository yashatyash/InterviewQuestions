package com.interview.service;

import com.interview.model.Genderize;

import java.util.List;

public interface GenderizeService {

    //create
    Genderize createNew(Genderize genderize);

    //get all
    List<Genderize> getAll();

    //get by Id
    Genderize getById(Integer id);

    //get by Name
    Genderize getByName(String name);

    void getDataFromApi();
}
