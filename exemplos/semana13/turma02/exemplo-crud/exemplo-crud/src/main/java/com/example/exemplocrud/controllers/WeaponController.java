package com.example.exemplocrud.controllers;

import com.example.exemplocrud.dtos.WeaponDto;
import com.example.exemplocrud.services.WeaponService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/weapons")
public class WeaponController {
    @Autowired
    WeaponService weaponService;

    @GetMapping
    public List<WeaponDto> getAllWeapons() {
        return weaponService.getWeapons();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WeaponDto saveWeapon(@RequestBody @Valid WeaponDto weaponDto){
        return weaponService.saveWeapon(weaponDto);
    }

    @PatchMapping("/{id}")
    public WeaponDto patchWeapon(@PathVariable UUID id, @RequestBody WeaponDto weaponDto) {
        return weaponService.updateWeapon(id, weaponDto);
    }

    @DeleteMapping("/{id}")
    public WeaponDto deleteWeapon(@PathVariable UUID id) {
        return weaponService.deleteWeapon(id);
    }
}
