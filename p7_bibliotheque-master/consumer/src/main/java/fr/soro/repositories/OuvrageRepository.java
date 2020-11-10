package fr.soro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.soro.entities.Ouvrage;
@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {}
