package ru.job4j.professions;

public class Doctor extends Professions {
    Doctor(String name, String profession) {
        super(name, profession);
    }

    public Diagnose heal(Patient pacient) {
        return null;
    }
}
