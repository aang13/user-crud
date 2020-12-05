package com.moinul.userCrud.Service;

import com.moinul.userCrud.Common.ResourceNotFoundException;
import com.moinul.userCrud.Common.UserType;
import com.moinul.userCrud.Model.ParentChild;
import com.moinul.userCrud.Model.User;
import com.moinul.userCrud.Repository.ParentChildRepository;
import com.moinul.userCrud.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private ParentChildRepository parentChildRepository;

    @Autowired
    public UserService(UserRepository userRepository,ParentChildRepository parentChildRepository){
        this.userRepository=userRepository;
        this.parentChildRepository=parentChildRepository;
    }

    public User createChildUser(User user,Long parentId){

        User parent=userRepository.findById(parentId).orElseThrow(()->new ResourceNotFoundException("No user found with this id."));
        if(parent.getType().equals(UserType.CHILDREN)) throw new ResourceNotFoundException("Children id can not be parent");

        User savedUser=userRepository.save(user);
        ParentChild newChild=new ParentChild();
        newChild.setUser(savedUser);
        newChild.setParent(parent);
        parentChildRepository.save(newChild);
        return savedUser;
    }
    public User createParentUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No user with id: "+ id));
        if(user.getType().equals(UserType.CHILDREN)){
            ParentChild child=parentChildRepository.findOneByUser(user).orElseThrow(()->new ResourceNotFoundException("No student found with for this user "));
            parentChildRepository.delete(child);
        }
        userRepository.delete(user);
    }
}
