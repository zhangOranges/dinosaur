package com.zhang.dinosaur.event;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

/**
 * addCount event
 */
@Data
public class AddCountEvent {
    private AtomicLong count;

    public AddCountEvent(AtomicLong count) {
        this.count = count;
    }
}
