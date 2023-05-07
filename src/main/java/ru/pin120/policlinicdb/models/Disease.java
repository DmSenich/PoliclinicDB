package ru.pin120.policlinicdb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Disease {
    private int id;
    private int typeId;
    private String description;

    public Disease(int typeId, String description) {
        this.typeId = typeId;
        this.description = description;
    }
}
