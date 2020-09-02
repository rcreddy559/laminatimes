package com.lamina.user.controller;

import antlr.collections.impl.IntRange;
import com.lamina.user.service.UserRepository;
import com.lamina.user.service.UserService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;



//@SpringBootTest
//public class UserControllerTest {
//
//    @Autowired
//    UserController userController;
//
//    @InjectMocks
//    UserService userService;
//
//    @Mock
//    UserRepository repository;
//
//    final int id = 1;
//
//    @BeforeEach
//    public void beforeTest() {
//
//    }
//
////    @Test
//    void testGetUser() {
//        when(userService.get(id)).thenReturn(new User(id, "te","","","","",""));
//        User user = userController.get(id);
//        assertEquals(id, user.getId());
//    }
//
////    @Test
//    void testGetUsers() {
//        List<User> users = new ArrayList<>(10);
//        for(int i=0;i<10;i++) {
//            users.add(new User(id+i, "te"+i,"","","","",""));
//        }
//        when(userService.getUsers()).thenReturn(users);
//        List<User>  userList = userController.getUsers();
//        assertEquals( users.size(), userList.size());
//    }
//
//    @Test
//    void test_save() {
//        User userMock = new User( "te","","","","","");
//        when(userService.save(any(User.class))).thenReturn(userMock);
//        User user = userController.save(userMock);
//        System.out.println(user.toString());
//        assertEquals("te", user.getFirstName());
//    }
//}
