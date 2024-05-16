package it.epicode.eserciziod4w1.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class Tavolo {

    private int numeroTavolo;
    private int numeroCopertiMax;
    private boolean occupato;
    private double coperto;

    // Lista degli ordini associati a questo tavolo
    private List<Ordine> ordini;

}
