package com.moinul.userCrud.Model;

import com.moinul.userCrud.Common.UserType;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="state")
    private String state;

    @Column(name="city")
    private String city;

   @Column(name = "street")
    private Long street;

   @Column(name="zip")
    private Long zip;

    @Enumerated(EnumType.STRING)
   @Column(name="type")
    private UserType type;

    public User() {
        super();
    }


    public User(long id, String firstName, String lastName, String state, String city, long street, long zip, UserType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.type = type;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(Long street) {
        this.street = street;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public Long getStreet() {
        return street;
    }

    public Long getZip() {
        return zip;
    }

    public UserType getType() {
        return type;
    }
}
