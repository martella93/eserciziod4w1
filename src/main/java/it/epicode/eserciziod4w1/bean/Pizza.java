package it.epicode.eserciziod4w1.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pizza extends VoceDiMenu{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany(mappedBy = "pizza", fetch = FetchType.EAGER)
    private List<Ingredienti> ingredienti = new ArrayList<>();

    private boolean xl;



}
