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
        User user=new User();
        user.setId(1L);
        user.setFirstName("a");
        user.setLastName("r");

        ParentDTO parentDTO=new ParentDTO();
        parentDTO.setFirstName("a");
        parentDTO.setId(1L);

        Mockito.when(userRepository.save(user)).thenReturn(user);
        Mockito.when(userService.processParentUser(parentDTO,user))

        User userFromService=userService.createParentUser(parentDTO);

//        Mockito.verify(userRepository,Mockito.times(1));



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
