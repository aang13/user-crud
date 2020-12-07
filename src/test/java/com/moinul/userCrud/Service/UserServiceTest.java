package com.moinul.userCrud.Service;

import com.moinul.userCrud.Common.UserType;
import com.moinul.userCrud.DTO.ChildDTO;
import com.moinul.userCrud.DTO.ParentDTO;
import com.moinul.userCrud.Model.User;
import com.moinul.userCrud.Repository.ParentChildRepository;
import com.moinul.userCrud.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ParentChildRepository parentChildRepository;


    @InjectMocks
    private UserService userService;


    @Test
    void createChildUser() {
//        User user=new User();
//        user.setId(1L);
//
//        User parent=new User();
//        parent.setId(2L);
//        parent.setType(UserType.PARENT);
//        userRepository.save(parent);
//
//        ChildDTO childDTO=new ChildDTO();
//        childDTO.setId(1L);
//        childDTO.setType(UserType.CHILDREN);
//        Mockito.when(userRepository.save(isA(User.class))).thenAnswer(invocation->(User) invocation.getArguments()[0]);
//        User returnedUser=userService.createChildUser(childDTO,2L);
//
//        ArgumentCaptor<User>savedUserArgument=ArgumentCaptor.forClass(User.class);
//
//        verify(userRepository,times(1)).save(savedUserArgument.capture());
//        verifyNoMoreInteractions(userRepository);
    }

    @Test
    void updateChildUser() {
        User user = new User();
        user.setId(1L);
        Mockito.when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));
        ChildDTO childDTO = new ChildDTO();
        childDTO.setId(user.getId());
        userService.updateChildUser(childDTO);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void createParentUser() {
        User user = new User();
        user.setId(1L);

        ParentDTO parentDTO = new ParentDTO();
        parentDTO.setId(1L);
        parentDTO.setType(UserType.PARENT);
        Mockito.when(userRepository.save(isA(User.class))).thenAnswer(invocation -> (User) invocation.getArguments()[0]);
        User returnedUser = userService.createParentUser(parentDTO);

        ArgumentCaptor<User> savedUserArgument = ArgumentCaptor.forClass(User.class);

        verify(userRepository, times(1)).save(savedUserArgument.capture());
        verifyNoMoreInteractions(userRepository);

    }

    @Test
    void updateParentUser() {
        User user = new User();
        user.setId(1L);
        Mockito.when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));
        ParentDTO parentDTO = new ParentDTO();
        parentDTO.setId(user.getId());
        userService.updateParentUser(parentDTO);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void deleteUser() {
        User user = new User();
        user.setId(1L);
        user.setType(UserType.PARENT);

        Mockito.when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));
        userService.deleteUser(1L);
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    void getAllUser() {
        User user = new User();
        user.setId(1L);
        User user2 = new User();
        user2.setId(2L);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        assertEquals(userList, userService.getAllUser());
    }


}
