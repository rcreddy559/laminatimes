package com.lamina.user.service;

import com.lamina.user.controller.User;
import com.lamina.user.controller.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doNothing;

//@SpringBootTest
//public class UserServiceTest {
//
//    @Autowired
//    UserService userService;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    User userMock = new User( "First name","Last Name","27-03-1981","Thalapual Palli","9611115506","eamil@example.com");
//    UserDto userDtoMock = new UserDto( "First name","Last Name","27-03-1981","Thalapual Palli","9611115506","eamil@example.com");
//
//    @Test
//    @DisplayName("Test findById Success")
//    void test_Find_By_Id() {
//        doReturn(Optional.of(userMock)).when(userRepository).findById(1);
//        Optional<UserDto> returnedWidget = userRepository.findById(1);
//
//        // Assert the response
//        Assertions.assertTrue(returnedWidget.isPresent(), "Widget was not found");
//        Assertions.assertSame(returnedWidget.get(), userMock, "The widget returned was not the same as the mock");
//    }
//
//    @Test
//    @DisplayName("Test findById Success")
//    void test_get_users() {
//        List<User> users = new ArrayList<>();
//        for (int i=0;i<10;i++) {
//            users.add(userMock);
//        }
//        doReturn(users).when(userRepository).findAll();
//        List<UserDto> userList = userRepository.findAll();
//
//        // Assert the response
//        Assertions.assertEquals(userList.size(), users.size());
//    }
//
//    void test_save() {
//        doReturn(userDtoMock).when(userRepository).save(userDtoMock);
//        User user = userService.save(userMock);
//        System.out.println(user.toString());
//        Assertions.assertEquals(user.getFirstName(), userMock.getFirstName());
//
//    }
//
//    @Test
//    @DisplayName("Test Delete user Success")
//    void test_delete() {
//        doNothing().when(userRepository).deleteById(1);
//        userService.delete(1);
//    }
//}
