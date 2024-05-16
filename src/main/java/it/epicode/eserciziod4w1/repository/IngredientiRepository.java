package it.epicode.eserciziod4w1.repository;

import it.epicode.eserciziod4w1.bean.Ingredienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientiRepository extends JpaRepository<Ingredienti, Integer> {

    @Query("SELECT i FROM Ingredienti i WHERE i.nome = :nome")
    public List<Ingredienti> findByNome(String nome);
}
