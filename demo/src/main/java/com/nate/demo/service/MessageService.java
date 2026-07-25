package com.nate.demo.service;

import com.nate.demo.model.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public MessageResponse getMessage() {
        return new MessageResponse(
                "CI/CD pipeline deployed successfully!"
        );
    }
}