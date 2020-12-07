package com.moinul.userCrud.Controller;

import com.moinul.userCrud.DTO.ChildDTO;
import com.moinul.userCrud.DTO.ParentDTO;
import com.moinul.userCrud.Model.User;
import com.moinul.userCrud.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "user/create/parent", produces = MediaType.APPLICATION_JSON_VALUE)
    public User createParentUser(@Validated @RequestBody ParentDTO parentDTO) {
        return userService.createParentUser(parentDTO);
    }

    @PostMapping(value = "user/create/child", produces = MediaType.APPLICATION_JSON_VALUE)
    public User createChildUser(@Validated @RequestBody ChildDTO childDTO) {
        return userService.createChildUser(childDTO);
    }

    @PutMapping(value = "user/update/parent", produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateParentUser(@Validated @RequestBody ParentDTO parentDTO) {
        return userService.updateParentUser(parentDTO);
    }

    @PutMapping(value = "user/update/child", produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateChildUser(@Validated @RequestBody ChildDTO childDTO) {
        return userService.updateChildUser(childDTO);
    }

    @DeleteMapping(value = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }


    @GetMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }


}
