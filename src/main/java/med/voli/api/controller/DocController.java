package med.voli.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        Doctor newDoctor = new Doctor(json);
        repository.save(newDoctor);
    }

    @GetMapping
    public Page<DoctorReturn> listDoctors( @PageableDefault(size = 1, sort = {"name"}) Pageable pagination){
        // return repository.findAll(pagination).stream().map(DoctorReturn::new).toList();
        // se colocar um nome especifico o sprong boot ja entende qual aquery que é para ser feita
        return  repository.findAllByActiveTrue(pagination).map(DoctorReturn::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateDoctorData json){
        Doctor doc = repository.getReferenceById(json.id());
        doc.updateInfos(json);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id ){
        Doctor doctor = repository.getReferenceById(id);
        doctor.inactive();
    }


}
