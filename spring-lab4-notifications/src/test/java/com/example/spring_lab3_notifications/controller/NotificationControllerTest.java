package com.example.spring_lab3_notifications.controller;

import com.example.spring_lab3_notifications.model.entity.Notification;
import com.example.spring_lab3_notifications.model.entity.User;
import com.example.spring_lab3_notifications.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationController notificationController;

    @Test
    void shouldReturnAllNotifications() {
        User user = new User();
        user.setId(1L);

        Notification notification = new Notification();
        notification.setTitle("Тест");
        notification.setRecipient(user);

        when(notificationService.getAllNotifications()).thenReturn(List.of(notification));

        List<?> result = notificationController.getAllNotifications();

        assertEquals(1, result.size());
    }
}