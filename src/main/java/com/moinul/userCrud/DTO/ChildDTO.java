package com.moinul.userCrud.DTO;

import com.moinul.userCrud.Common.UserType;
import com.moinul.userCrud.Model.User;

public class ChildDTO {

    public Long id;
    private String firstName;
    private String lastName;
    private UserType type;

    public ChildDTO() {
    }

    public ChildDTO(long id, String firstName, String lastName, UserType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

}
