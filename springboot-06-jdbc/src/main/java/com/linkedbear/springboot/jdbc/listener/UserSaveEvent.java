package com.linkedbear.springboot.jdbc.listener;

import com.linkedbear.springboot.jdbc.entity.User;
import org.springframework.context.ApplicationEvent;

public class UserSaveEvent extends ApplicationEvent {
    
    public UserSaveEvent(User source) {
        super(source);
    }
}
