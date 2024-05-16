package it.epicode.eserciziod4w1.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Bevanda extends VoceDiMenu{

    @Id
    @GeneratedValue
    private int id;

    private int ml;
    private String nome;
    private int gradoAlcohol;


}
