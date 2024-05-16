package it.epicode.eserciziod4w1.service;


import it.epicode.eserciziod4w1.bean.Bevanda;
import it.epicode.eserciziod4w1.bean.Ingredienti;
import it.epicode.eserciziod4w1.repository.IngredientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientiService {

    @Autowired
    private IngredientiRepository ingredientiRepository;

    public void inserisciIngrediente(Ingredienti ingredienti){
        ingredientiRepository.save(ingredienti);
    }
    public List<Ingredienti> getIngredienti(){
        return ingredientiRepository.findAll();
    }
    public void cancellaIngrediente(int id){
       ingredientiRepository.deleteById(id);
    }

    public List<Ingredienti> cercaIngredientiPerNome(String nome) {
        return ingredientiRepository.findByNome(nome);
    }

}

