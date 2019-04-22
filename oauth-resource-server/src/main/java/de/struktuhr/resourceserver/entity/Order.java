package de.struktuhr.resourceserver.entity;

public class Order {

    private final String id;
    private final String name;
    private final String organization;

    public Order(String id, String name, String organization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrganization() {
        return organization;
    }
}
