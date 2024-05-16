package it.epicode.eserciziod4w1.repository;

import it.epicode.eserciziod4w1.bean.Bevanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BevandaRepository extends JpaRepository<Bevanda, Integer> {
}
