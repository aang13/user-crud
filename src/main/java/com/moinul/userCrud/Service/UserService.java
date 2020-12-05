package com.moinul.userCrud.Service;

import com.moinul.userCrud.Common.ResourceNotFoundException;
import com.moinul.userCrud.Common.UserType;
import com.moinul.userCrud.DTO.ChildDTO;
import com.moinul.userCrud.DTO.ParentDTO;
import com.moinul.userCrud.Model.ParentChild;
import com.moinul.userCrud.Model.User;
import com.moinul.userCrud.Repository.ParentChildRepository;
import com.moinul.userCrud.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private ParentChildRepository parentChildRepository;

    @Autowired
    public UserService(UserRepository userRepository,ParentChildRepository parentChildRepository){
        this.userRepository=userRepository;
        this.parentChildRepository=parentChildRepository;
    }

    public User createChildUser(ChildDTO childDTO,Long parentId){

        User parent=userRepository.findById(parentId).orElseThrow(()->new ResourceNotFoundException("No parent found with this id."));
        if(parent.getType().equals(UserType.CHILDREN)) throw new ResourceNotFoundException("Children id can not be parent");


        User savedUser=new User();
        processChildUser(childDTO,savedUser);

        ParentChild newChild=new ParentChild();
        newChild.setUser(savedUser);
        newChild.setParent(parent);
        parentChildRepository.save(newChild);
        return savedUser;
    }

    public User updateChildUser(ChildDTO childDTO){
//        User parent=userRepository.findById(childDTO.get()).orElseThrow(()->new ResourceNotFoundException("No parent found with this id."));
        User user=userRepository.findById(childDTO.getId()).orElseThrow(()->new ResourceNotFoundException("No user found with this id."));

        processChildUser(childDTO,user);
        return user;
    }

    public void processChildUser(ChildDTO childDTO,User user){
        user.setFirstName(childDTO.getFirstName());
        user.setLastName(childDTO.getLastName());
        user.setType(childDTO.getType());
        user=userRepository.save(user);
    }


    public User createParentUser(ParentDTO parentDTO){

        User user=new User();
        processParentUser(parentDTO,user);
        return userRepository.save(user);

    }

   public User updateParentUser(ParentDTO parentDTO){
       User user=userRepository.findById(parentDTO.getId()).orElseThrow(()->new ResourceNotFoundException("No user found with id: "+ parentDTO.getId()));

       processParentUser(parentDTO,user);
       return userRepository.save(user);
   }

   public void processParentUser(ParentDTO parentDTO,User user){
       user.setFirstName(parentDTO.getFirstName());
       user.setLastName(parentDTO.getLastName());
       user.setState(parentDTO.getState());
       user.setCity(parentDTO.getCity());
       user.setStreet(parentDTO.getStreet());
       user.setZip(parentDTO.getZip());
       user.setType(parentDTO.getType());

   }

    public void deleteUser(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No user with id: "+ id));
        if(user.getType().equals(UserType.CHILDREN)){
            ParentChild child=parentChildRepository.findOneByUser(user).orElseThrow(()->new ResourceNotFoundException("No student found with for this user "));
            parentChildRepository.delete(child);
        }
        else{
            List<ParentChild> children=parentChildRepository.findAllByParent(user);

            for (ParentChild child: children ) {
                User childToDelete=userRepository.findById(child.getUser().getId()).orElseThrow(()->new ResourceNotFoundException("No user with id: "+ child.getUser().getId()));
                parentChildRepository.delete(child);
                userRepository.delete(childToDelete);
            }
        }
        userRepository.delete(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
