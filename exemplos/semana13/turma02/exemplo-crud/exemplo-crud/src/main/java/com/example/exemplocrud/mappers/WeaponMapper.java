package com.example.exemplocrud.mappers;

import com.example.exemplocrud.dtos.WeaponDto;
import com.example.exemplocrud.models.Weapon;
import org.springframework.stereotype.Component;

@Component
public class WeaponMapper {
    public WeaponDto toDto(Weapon weapon) {
        return new WeaponDto(
                weapon.getId(),
                weapon.getNome(),
                weapon.getTipo(),
                weapon.getDano()
        );
    }
}
