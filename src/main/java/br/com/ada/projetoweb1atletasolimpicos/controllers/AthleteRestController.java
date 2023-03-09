package br.com.ada.projetoweb1atletasolimpicos.controllers;

import br.com.ada.projetoweb1atletasolimpicos.model.Athlete;
import br.com.ada.projetoweb1atletasolimpicos.services.AthleteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/athletes")
public class AthleteRestController {

    @Autowired
    private AthleteServices athleteServices;

    @PostMapping("/save")
    public Athlete save(@RequestBody Athlete athlete){
        return athleteServices.save(athlete);
    }

    @GetMapping("/all")
    public List<Athlete> findAll(){
        return athleteServices.findAll();
    }

    @GetMapping("/id/{id}")
    public Athlete findById(@PathVariable UUID id){
        return athleteServices.findById(id);
    }

    @GetMapping("/name/{name}")
    public Athlete findByName(@PathVariable String name){
        return athleteServices.findByName(name);
    }

    @GetMapping("/federation/{federation}")
    public List<Athlete> findByFederation(@PathVariable String federation){
        return athleteServices.findByFederation(federation);
    }

    @GetMapping("/modality/{modality}")
    public List<Athlete> findByModality(@PathVariable String modality){
        return athleteServices.findByModality(modality);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable UUID id){
        athleteServices.deleteById(id);
    }

//    @PostMapping("/update")
//    public Athlete update(@RequestParam UUID id, @RequestBody Athlete athlete){
//        return athleteServices.update(id, athlete);
//    }

}
