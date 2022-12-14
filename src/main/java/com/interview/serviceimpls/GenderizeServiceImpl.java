package com.interview.serviceimpls;

import com.interview.exceptions.ApiException;
import com.interview.exceptions.ResourceNotFoundException;
import com.interview.model.Genderize;
import com.interview.repo.GenderizeRepository;
import com.interview.service.GenderizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class GenderizeServiceImpl implements GenderizeService {

    @Autowired
    private GenderizeRepository repository;

    @Override
    public Genderize createNew(Genderize genderize) {
        if (genderize!=null)
            return this.repository.save(genderize);
        else
            throw new ApiException("Data not created, something went wrong !!");
    }

    @Override
    @Scheduled(cron = "*/5 * * * * *")
    public void getDataFromApi() {
        String uri = "http://localhost:8080/genderize/get/data";
        Genderize genderize = new RestTemplate().getForObject(uri, Genderize.class);
        System.out.println(genderize.toString() + " DateTime: " + new Date());
    }

    @Override
    public List<Genderize> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Genderize getById(Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genderize", "id", id));
    }

    @Override
    public Genderize getByName(String name) {
        return this.repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Genderize","name",name));
    }
}
