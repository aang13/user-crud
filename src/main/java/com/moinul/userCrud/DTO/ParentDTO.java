package com.moinul.userCrud.DTO;

import com.moinul.userCrud.Common.UserType;

public class ParentDTO {

    public Long id;
    private String firstName;
    private String lastName;
    private String state;
    private String city;
    private Long street;
    private Long zip;
    private UserType type;

    public ParentDTO() {
    }

    public ParentDTO(long id, String firstName, String lastName, String state, String city, long street, long zip, UserType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getStreet() {
        return street;
    }

    public void setStreet(long street) {
        this.street = street;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
