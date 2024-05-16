package it.epicode.eserciziod4w1.bean;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class Ordine {

    private int numeroOrdine;
//    private StatoOrdine statoOrdine;
    private int coperti;
    private LocalDateTime oraAcquisizione;
    private Tavolo tavolo;


    private List<Bevanda> bevanda;
    private List<Pizza> pizza;
    private List<Ingredienti> ingredienti;

    public double prezzoTotale(){
        double totale = bevanda.stream().mapToDouble(bevande -> bevande.getPrezzo()).sum();
        totale += ingredienti.stream().mapToDouble(Ingredienti :: getPrezzo).sum();
        totale += pizza.stream().mapToDouble(Pizza :: getPrezzo).sum();
        totale += tavolo.getCoperto() * coperti;
        return totale;
    }

    public Ordine(int coperti, Tavolo tavolo) {
        if (coperti <= tavolo.getNumeroCopertiMax()){
            this.coperti = coperti;
            this.tavolo = tavolo;
        }
        else {
            System.out.println("ciao");
        }
    }
    public void stampaOrdine(){
    System.out.println("Ordine:" + numeroOrdine);
        System.out.println("Bevande");
        bevanda.forEach(bevanda -> System.out.println(bevanda.getNome() + " ml " + bevanda.getMl()+
             "   prezzo: " + bevanda.getPrezzo()));

        System.out.println();
        System.out.println("Ingredienti");
        ingredienti.forEach(ingrediente -> System.out.println(ingrediente.getNome() +
            "   prezzo: " + ingrediente.getPrezzo()));

        System.out.println();
        System.out.println("Pizze");
        pizza.forEach(pizza -> System.out.println(pizza.getNome() +
             "   prezzo: " + pizza.getPrezzo()));

        System.out.println();
        System.out.println("Prezzo totale: " + prezzoTotale());
}

}
