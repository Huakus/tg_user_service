package com.tourguide.user.utils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import com.tourguide.user.enums.Role;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Set<Role>, String> {

    @Override
    public String convertToDatabaseColumn(Set<Role> attribute) {
        return attribute.stream()
                        .map(Role::name)
                        .collect(Collectors.joining(","));
    }

    @Override
    public Set<Role> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(","))
                     .map(Role::valueOf)
                     .collect(Collectors.toSet());
    }
}

