package it.epicode.eserciziod4w1.AppConfig;


import it.epicode.eserciziod4w1.bean.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

@Configuration
@PropertySource("application.properties")
public class AppConfing {

    @Bean
    public Bevanda birra(){
        Bevanda birra = new Bevanda();
        birra.setNome("birra");
        birra.setMl(33);
        birra.setGradoAlcohol(5);
        birra.setCalorie(200);
        birra.setPrezzo(2);
        return birra;
    }

    @Bean("acqua")
    public Bevanda acqua(){
        Bevanda acqua = new Bevanda();
        acqua.setNome("acqua");
        acqua.setMl(50);
        acqua.setGradoAlcohol(0);
        acqua.setCalorie(0);
        acqua.setPrezzo(1);
        return acqua;
    }

    @Bean
    public Bevanda cocaCola(){
        Bevanda cocaCola = new Bevanda();
        cocaCola.setNome("cocaCola");
        cocaCola.setMl(33);
        cocaCola.setGradoAlcohol(0);
        cocaCola.setCalorie(200);
        cocaCola.setPrezzo(2);
        return cocaCola;
    }

    @Bean
    public Ingredienti mozzarella(){
        Ingredienti mozzarella = new Ingredienti();
        mozzarella.setNome("mozzarella");
        mozzarella.setCalorie(100);
        mozzarella.setPrezzo(1);
        return mozzarella;
    }

    @Bean("pomodoro")
    public Ingredienti pomodoro(){
        Ingredienti pomodoro = new Ingredienti();
        pomodoro.setNome("pomodoro");
        pomodoro.setCalorie(100);
        pomodoro.setPrezzo(1);
        return pomodoro;
    }

    @Bean("salame")
    public Ingredienti salame(){
        Ingredienti salame = new Ingredienti();
        salame.setNome("salame");
        salame.setCalorie(100);
        salame.setPrezzo(1);
        return salame;
    }

    //@Bean
    //@Scope("prototype")
    public Pizza base(){
        Pizza base = new Pizza();
        ArrayList<Ingredienti> ingredienti = new ArrayList<>();
        ingredienti.add(mozzarella());
        base.setIngredienti(ingredienti);
        return base;
    }

    @Bean("margherita")
    public Pizza margherita(){
        Pizza margherita = base();
        margherita.setNome("margherita");
        margherita.setCalorie(400);
        margherita.setPrezzo(3.5);
        margherita.getIngredienti().add(pomodoro());
        return margherita;
    }

    @Bean("diavola")
    public Pizza diavola(){
        Pizza diavola = base();
        diavola.setNome("diavola");
        diavola.setCalorie(500);
        diavola.setPrezzo(5);
        diavola.getIngredienti().add(pomodoro());
        diavola.getIngredienti().add(salame());
        return diavola;
    }
   // @Bean
    public Menu menu(){
        Menu menu = new Menu();

        ArrayList<Bevanda> bevande = new ArrayList<>();
        bevande.add(acqua());
        bevande.add(cocaCola());
        bevande.add(birra());

        ArrayList<Ingredienti> ingredienti = new ArrayList<>();
        ingredienti.add(mozzarella());
        ingredienti.add(pomodoro());
        ingredienti.add(salame());

        ArrayList<Pizza> pizze = new ArrayList<>();
        pizze.add(margherita());
        pizze.add(diavola());

        menu.setBevande(bevande);
        menu.setIngredienti(ingredienti);
        menu.setPizze(pizze);

        return menu;
    }

    @Bean("tavolo1")
    public Tavolo tavolo1(@Value("${tavolo1.coperto}") Double coperto){
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(1);
        tavolo.setNumeroCopertiMax(5);
        tavolo.setCoperto(coperto);
        return tavolo;
    }

    @Bean("tavolo2")
    public Tavolo tavolo2(@Value("${tavolo2.coperto}") Double coperto){
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(2);
        tavolo.setNumeroCopertiMax(7);
        tavolo.setCoperto(coperto);
        return tavolo;
    }

    @Bean("tavolo3")
    public Tavolo tavolo3(@Value("${tavolo3.coperto}") Double coperto){
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroTavolo(3);
        tavolo.setNumeroCopertiMax(4);
        tavolo.setCoperto(coperto);
        return tavolo;
    }
}
