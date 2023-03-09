package br.com.ada.projetoweb1atletasolimpicos.repositories;

import br.com.ada.projetoweb1atletasolimpicos.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, UUID> {
    Athlete findByName(String name);

    List<Athlete> findByFederation(String federation);

    List<Athlete> findByModality(String modality);
}
