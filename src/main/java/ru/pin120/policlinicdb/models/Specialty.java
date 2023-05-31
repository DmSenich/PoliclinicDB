package ru.pin120.policlinicdb.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Specialty {
    private int id;
    private String name;

    public Specialty(String name) {
        this.name = name;
    }
}
