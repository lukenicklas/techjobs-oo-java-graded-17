package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Location {

    private int id;
    private static int nextId = 1;
    private String value;

    public Location() { //creating new locations and keeping track of a unique ID for each location.
        id = nextId;
        nextId++;
    }

    // TODO: Add a constructor that takes a string as a parameter and assigns it to the 'value' field. The
    //  constructor should also call the empty constructor in order to initialize the 'id' field.
    public Location(String value) { //declares public constructor with string parameter named value
        this(); //calls the empty constructor
        this.value = value; //assigns the value parameter to the value field
    }


    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getId() == location.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
