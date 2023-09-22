package med.voli.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.doctor.CreateDocData;
import med.voli.api.doctor.Doctor;
import med.voli.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class DocController{

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void createMed(@RequestBody @Valid CreateDocData json){
        repository.save(new Doctor(json));
    }
}
