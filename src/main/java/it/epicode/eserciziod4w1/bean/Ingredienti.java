package it.epicode.eserciziod4w1.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ingredienti extends VoceDiMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

}
