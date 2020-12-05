package com.moinul.userCrud.Controller;

import com.moinul.userCrud.Model.User;
import com.moinul.userCrud.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping(value ="user/create/parent", produces = MediaType.APPLICATION_JSON_VALUE)
    public User createParentUser(@Validated  @RequestBody User user)
    {
        return userService.createParentUser(user);
    }

    @PostMapping(value ="user/create/child/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User createChildUser(@Validated  @RequestBody User user, @PathVariable(name = "id")long parentId)
    {
        return userService.createChildUser(user,parentId);
    }

    @PutMapping(value ="user/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@Validated  @RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping(name="user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }




}
