package com.moinul.userCrud.Service;

import com.moinul.userCrud.DTO.ParentDTO;
import com.moinul.userCrud.Model.ParentChild;
import com.moinul.userCrud.Model.User;
import com.moinul.userCrud.Repository.ParentChildRepository;
import com.moinul.userCrud.Repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository ;

    @Mock
    private ParentChildRepository parentChildRepository;


    @InjectMocks
    private UserService userService;

//    @BeforeEach
//    public void beforeEach(){
//        userService=new UserService(userRepository,parentChildRepository);
//    }



    @Test
    void createChildUser() {
    }

    @Test
    void updateChildUser() {
    }

    @Test
    public void createParentUser() {
//        User user=new User();
//        user.setId(1L);

//        ParentDTO parentDTO=new ParentDTO();
//        parentDTO.setId(2L);
//        Mockito.when(userRepository.save(new User())).thenReturn(new User());

//        User userFromService=userService.createParentUser(parentDTO);

//        assertEquals(new User(),userService.createParentUser(parentDTO));



    }

    @Test
    void updateParentUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getAllUser(){
        User user=new User();
        user.setId(1L);
        User user2=new User();
        user2.setId(2L);
        List<User> userList=new ArrayList<>();
        userList.add(user);
        userList.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        assertEquals(userList,userService.getAllUser());
    }



}
