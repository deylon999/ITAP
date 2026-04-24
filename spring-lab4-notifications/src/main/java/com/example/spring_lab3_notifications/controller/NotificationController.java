package com.example.spring_lab3_notifications.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.spring_lab3_notifications.model.dto.NotificationDto;
import com.example.spring_lab3_notifications.model.entity.Notification;
import com.example.spring_lab3_notifications.model.enums.NotificationChannel;
import com.example.spring_lab3_notifications.model.enums.NotificationStatus;
import com.example.spring_lab3_notifications.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    private NotificationDto mapToDto(Notification response) {
        return NotificationDto.builder()
                .title(response.getTitle())
                .message(response.getMessage())
                .channel(response.getChannel())
                .status(response.getStatus())
                .createdAt(response.getCreatedAt())
                .sentAt(response.getSentAt())
                .recipientId(response.getRecipient().getId())
                .build();
    }

    @PostMapping("/add")
    public NotificationDto createNotification(@RequestBody @Valid NotificationDto request) {
        return mapToDto(notificationService.createNotification(request));
    }

    @GetMapping("/all")
    public List<NotificationDto> getAllNotifications() {
        return notificationService.getAllNotifications().stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public NotificationDto getNotificationById(@PathVariable Long id) {
        return mapToDto(notificationService.getNotificationById(id));
    }

    @PutMapping("/{id}")
    public NotificationDto updateNotification(@PathVariable Long id, @RequestBody @Valid NotificationDto request) {
        return mapToDto(notificationService.updateNotification(id, request));
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "Уведомление удалено";
    }

    @GetMapping("/status/{status}")
    public List<NotificationDto> getByStatus(@PathVariable NotificationStatus status) {
        return notificationService.getNotificationsByStatus(status).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/channel/{channel}")
    public List<NotificationDto> getByChannel(@PathVariable NotificationChannel channel) {
        return notificationService.getNotificationsByChannel(channel).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/recipient/{recipientId}")
    public List<NotificationDto> getByRecipientId(@PathVariable Long recipientId) {
        return notificationService.getNotificationsByRecipientId(recipientId).stream()
                .map(this::mapToDto)
                .toList();
    }
}