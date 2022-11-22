package fr.tom.kittenproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.tom.kittenproject.entities.Kitten;
import fr.tom.kittenproject.repositories.KittenRepository;


@RestController
public class KittenController {

    @Autowired
    KittenRepository kittenRepository;

    @GetMapping("/kittensall")
    public List<Kitten> getAll() {
        return this.kittenRepository.findAll();
    }
    
    @GetMapping("/kittens")
    public List<Kitten> findAllKittensByIsAdopted(Boolean isAdopted) {
        return this.kittenRepository.findAllKittensByIsAdopted(isAdopted);
    }
    
    @GetMapping("/kittens/{id}")
    public Kitten getKitten(@PathVariable Integer id) {
        return kittenRepository.findById(id).get();
    }

    @PostMapping("/kittens")
    public Kitten create(@RequestBody Kitten kitten) { return kittenRepository.save(kitten); }

    @DeleteMapping("kittens/{id}")
    public boolean delete(@PathVariable Integer id) {
        kittenRepository.deleteById(id);
        return true;
    }
}
