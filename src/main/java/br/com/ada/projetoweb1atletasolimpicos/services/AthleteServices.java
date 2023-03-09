package br.com.ada.projetoweb1atletasolimpicos.services;
import br.com.ada.projetoweb1atletasolimpicos.model.Athlete;
import br.com.ada.projetoweb1atletasolimpicos.repositories.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AthleteServices {

    @Autowired
    private AthleteRepository athleteRepository;

    public Athlete save(Athlete newAthlete) {
        Athlete updatedAthlete = newAthlete;
        if(athleteRepository.findAll().stream().anyMatch(athlete -> athlete.equals(newAthlete))) {
            updatedAthlete = athleteRepository.findAll().stream().filter(athlete -> athlete.equals(newAthlete)).map(athlete -> {
                newAthlete.setId(athlete.getId());
                return newAthlete;
            }).toList().get(0);
        }
        return athleteRepository.save(updatedAthlete);


    }

    public List<Athlete> findAll() {
        return  athleteRepository.findAll();
    }

    public Athlete findById(UUID id) {
        return athleteRepository.findById(id).orElse(null);
    }

    public Athlete findByName(String name) {
        return athleteRepository.findByName(name);
    }

    public List<Athlete> findByFederation(String federation) {
        return athleteRepository.findByFederation(federation);
    }

    public List<Athlete> findByModality(String modality) {
        return athleteRepository.findByModality(modality);
    }

    public void deleteById(UUID id) {
        athleteRepository.deleteById(id);
    }

}
