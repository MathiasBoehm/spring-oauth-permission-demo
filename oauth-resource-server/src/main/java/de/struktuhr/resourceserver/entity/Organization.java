package de.struktuhr.resourceserver.entity;

public class Organization {

    private final String id;

    private final String name;

    public Organization(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
