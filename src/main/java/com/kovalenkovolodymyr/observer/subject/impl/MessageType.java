package com.kovalenkovolodymyr.observer.subject.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MessageType {
    TEXT, VOICE, VIDEO;
    private static final List<MessageType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MessageType randomMessageType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
