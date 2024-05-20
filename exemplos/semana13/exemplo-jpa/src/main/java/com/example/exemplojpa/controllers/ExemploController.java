package com.example.exemplojpa.controllers;

import com.example.exemplojpa.models.Weapon;
import com.example.exemplojpa.repositories.WeaponRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ExemploController {
    @Autowired
    private WeaponRepository weaponRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Weapon save(@RequestBody Weapon weapon ) {
        return weaponRepository.save(weapon);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Weapon> getAll(@RequestParam int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Weapon> weaponPage = weaponRepository.findAll(pageable);
        return weaponPage.stream().toList();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Weapon getOne(@PathVariable UUID id) {
        Weapon weapon = weaponRepository.findById(id).get();
        return weapon;
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Weapon update(@PathVariable UUID id, @RequestBody Weapon weaponChange) {
        Weapon weapon = weaponRepository.findById(id).get();
        weapon.setName(weaponChange.getName());
        weapon.setDamage(weaponChange.getDamage());
        weaponRepository.save(weapon);
        return weapon;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Weapon update(@PathVariable UUID id) {
        Weapon weapon = weaponRepository.findById(id).get();
        weaponRepository.delete(weapon);
        return weapon;
    }
}
