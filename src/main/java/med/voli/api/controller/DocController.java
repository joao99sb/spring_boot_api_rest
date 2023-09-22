package med.voli.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.doctor.CreateDocData;
import med.voli.api.doctor.Doctor;
import med.voli.api.doctor.DoctorRepository;
import med.voli.api.doctor.DoctorReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class DocController{

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void createDoctor(@RequestBody @Valid CreateDocData json){
        repository.save(new Doctor(json));
    }

    @GetMapping
    public List<DoctorReturn> listDoctors(){
        return repository.findAll().stream().map(DoctorReturn::new).toList();
    }
}
