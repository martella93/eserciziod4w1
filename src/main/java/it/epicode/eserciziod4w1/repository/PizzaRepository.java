package it.epicode.eserciziod4w1.repository;

import it.epicode.eserciziod4w1.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    public List<Pizza> findByNome(String nome);
}
