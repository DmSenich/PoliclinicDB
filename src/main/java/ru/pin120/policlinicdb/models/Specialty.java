package ru.pin120.policlinicdb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Specialty {
    private int id;
    private String name;

    public Specialty(String name) {
        this.name = name;
    }
}
