package com.nate.demo.service;

import com.nate.demo.model.MessageResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MessageServiceTest {

    private final MessageService messageService = new MessageService();

    @Test
    void shouldReturnDeploymentMessage() {
        MessageResponse response = messageService.getMessage();

        assertNotNull(response);
        assertEquals(
                "CI/CD pipeline deployed successfully!",
                response.message()
        );
    }
}