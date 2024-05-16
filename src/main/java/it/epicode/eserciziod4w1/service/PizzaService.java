package it.epicode.eserciziod4w1.service;

import it.epicode.eserciziod4w1.bean.Pizza;
import it.epicode.eserciziod4w1.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public void inserisciPizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }

    public List<Pizza> getPizza(){
        return pizzaRepository.findAll();
    }

    public void cancellaPizza(int id){
        pizzaRepository.deleteById(id);
    }

    public List<Pizza> getPizzaByNome(String nome){
        return pizzaRepository.findByNome(nome);
    }
}
