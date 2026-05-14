package com.example.spring_lab3_notifications.controller;

import com.example.spring_lab3_notifications.model.entity.User;
import com.example.spring_lab3_notifications.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void shouldReturnAllUsers() {
        User user = new User();
        user.setName("Иван");

        when(userService.getAllUsers()).thenReturn(List.of(user));

        List result = userController.getAllUsers();

        assertEquals(1, result.size());
    }
}