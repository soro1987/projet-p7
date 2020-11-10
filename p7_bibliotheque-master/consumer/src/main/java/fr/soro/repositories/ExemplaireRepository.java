package fr.soro.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.soro.entities.Exemplaire;
@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {}
