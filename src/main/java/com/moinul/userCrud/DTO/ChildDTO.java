package com.moinul.userCrud.DTO;

import com.moinul.userCrud.Common.UserType;
import com.moinul.userCrud.Model.User;
import javax.validation.constraints.Size;

public class ChildDTO {

    public Long id;

    @Size(max=25)
    private String firstName;

    @Size(max=25)
    private String lastName;
    private UserType type;
    private Long parentId;

    public ChildDTO() {
    }



    public ChildDTO(Long id, String firstName, String lastName, UserType type, Long parentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.parentId = parentId;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
