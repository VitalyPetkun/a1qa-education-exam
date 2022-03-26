package models;

import lombok.Data;

@Data
public class Variant {

    private int value;

    public Variant(int value) {
        this.value = value;
    }
}
