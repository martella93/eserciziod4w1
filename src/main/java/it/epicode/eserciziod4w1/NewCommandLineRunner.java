package it.epicode.eserciziod4w1;

import it.epicode.eserciziod4w1.bean.*;
import it.epicode.eserciziod4w1.service.BevandaService;
import it.epicode.eserciziod4w1.service.IngredientiService;
import it.epicode.eserciziod4w1.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NewCommandLineRunner implements CommandLineRunner {

    @Autowired
    private BevandaService bevandaService;

    @Autowired
    private IngredientiService ingredientiService;

    @Autowired
    private PizzaService pizzaService;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Eserciziod4w1Application.class);

        Menu menu = ctx.getBean(Menu.class);
        menu.stampaMenu();

        Tavolo tavolo1 = ctx.getBean("tavolo1", Tavolo.class);

        Ordine ordine = new Ordine(4,tavolo1);

        ordine.setNumeroOrdine(1);
        ordine.setOraAcquisizione(LocalDateTime.now());
        ordine.setBevanda(List.of(menu.getBevande().get(0), menu.getBevande().get(1)));
        ordine.setIngredienti(List.of(menu.getIngredienti().get(0), menu.getIngredienti().get(1)));
        ordine.setPizza(List.of(menu.getPizze().get(0), menu.getPizze().get(0),menu.getPizze().get(1), menu.getPizze().get(1)));

        ordine.stampaOrdine();

        Pizza pizza1 = ctx.getBean("margherita", Pizza.class);
        pizzaService.inserisciPizza(pizza1);

        Ingredienti ingredienti1 = ctx.getBean("pomodoro", Ingredienti.class);
        ingredientiService.inserisciIngrediente(ingredienti1);

        Bevanda bevanda1 = ctx.getBean("acqua", Bevanda.class);
        bevandaService.inserisciBevanda(bevanda1);

        System.out.println(pizzaService.getPizzaByNome("margherita"));
        System.out.println(ingredientiService.cercaIngredientiPerNome("pomodoro"));


    }
}
