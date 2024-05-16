package it.epicode.eserciziod4w1.service;

import it.epicode.eserciziod4w1.bean.Bevanda;
import it.epicode.eserciziod4w1.repository.BevandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BevandaService {

    @Autowired
    private BevandaRepository bevandaRepository;

    public void inserisciBevanda(Bevanda bevanda){
        bevandaRepository.save(bevanda);
    }
    public List<Bevanda> getBevande(){
        return bevandaRepository.findAll();
    }
    public void cancellaBevanda(int id){
        bevandaRepository.deleteById(id);
    }
}
