package it.epicode.eserciziod4w1.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Menu {

    @Autowired
    private List<Ingredienti> ingredienti;
    @Autowired
    private List<Bevanda> bevande;
    @Autowired
    private List<Pizza> pizze;

    public void stampaMenu(){
        System.out.println("Menu");
        System.out.println("Bevande");
        bevande.forEach(bevanda -> System.out.println(bevanda.getNome() + " ml " + bevanda.getMl()+
                bevanda.getCalorie() + "   prezzo: " + bevanda.getPrezzo()));

        System.out.println();
        System.out.println("Ingredienti");
        ingredienti.forEach(ingrediente -> System.out.println(ingrediente.getNome() +
                ingrediente.getCalorie() + "   prezzo: " + ingrediente.getPrezzo()));

        System.out.println();
        System.out.println("Pizze");
        pizze.forEach(pizza -> System.out.println(pizza.getNome() +
                 pizza.getCalorie() + "   prezzo: " + pizza.getPrezzo()));;
    }
}
