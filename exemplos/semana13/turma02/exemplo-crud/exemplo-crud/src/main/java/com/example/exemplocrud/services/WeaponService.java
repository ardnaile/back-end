package com.example.exemplocrud.services;

import com.example.exemplocrud.dtos.WeaponDto;
import com.example.exemplocrud.mappers.WeaponMapper;
import com.example.exemplocrud.models.Weapon;
import com.example.exemplocrud.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WeaponService {
    @Autowired
    WeaponMapper weaponMapper;
    @Autowired
    WeaponRepository weaponRepository;

    public List<WeaponDto> getWeapons() {
        List<Weapon> listaWeapons = weaponRepository.findAll();
        return listaWeapons.stream().map(weaponMapper::toDto).toList();
    }

    public WeaponDto saveWeapon(WeaponDto weaponDto) {
        Weapon weapon = new Weapon();
        weapon.setNome(weaponDto.nome());
        weapon.setTipo(weaponDto.tipo());
        weapon.setDano(weaponDto.dano());
        weapon.setLocalizacao("Floresta");
        weaponRepository.save(weapon);
        return weaponMapper.toDto(weapon);
    }

    public WeaponDto updateWeapon(UUID id, WeaponDto weaponDto) {
        Weapon weapon = weaponRepository.findById(id).get();
        weapon.setNome(weaponDto.nome());
        weapon.setTipo(weaponDto.tipo());
        weapon.setDano(weaponDto.dano());
        weaponRepository.save(weapon);
        return weaponMapper.toDto(weapon);
    }

    public WeaponDto deleteWeapon(UUID id) {
        Weapon weapon = weaponRepository.findById(id).get();
        weaponRepository.delete(weapon);
        return weaponMapper.toDto(weapon);
    }
}
