package com.example.spring_lab3_notifications.service;

import com.example.spring_lab3_notifications.model.dto.RegisterRequest;
import com.example.spring_lab3_notifications.model.entity.User;
import com.example.spring_lab3_notifications.model.enums.UserRole;
import com.example.spring_lab3_notifications.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    @Test
    void shouldRegisterUser() {
        RegisterRequest request = new RegisterRequest();
        request.setName("Иван");
        request.setEmail("ivan@example.com");
        request.setPassword("qwerty123");

        when(passwordEncoder.encode(anyString())).thenReturn("$2a$10$hashedPassword");
        when(userRepository.save(any(User.class))).thenReturn(new User());

        authService.register(request);

        verify(userRepository, times(1)).save(any(User.class));
        verify(passwordEncoder, times(1)).encode("qwerty123");
    }

    @Test
    void shouldEncodePassword() {
        RegisterRequest request = new RegisterRequest();
        request.setName("Иван");
        request.setEmail("ivan@example.com");
        request.setPassword("qwerty123");

        when(passwordEncoder.encode("qwerty123")).thenReturn("$2a$10$hashedPassword");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            return user;
        });

        authService.register(request);

        verify(passwordEncoder).encode("qwerty123");
    }

    @Test
    void shouldSetRoleUser() {
        RegisterRequest request = new RegisterRequest();
        request.setName("Иван");
        request.setEmail("ivan@example.com");
        request.setPassword("qwerty123");

        when(passwordEncoder.encode(anyString())).thenReturn("$2a$10$hashedPassword");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User user = invocation.getArgument(0);
            return user;
        });

        authService.register(request);

        verify(userRepository).save(argThat(user ->
                user.getRole() == UserRole.ROLE_USER));
    }
}