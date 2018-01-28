package com.kovalenkovolodymyr.observer.subject.impl;

import com.kovalenkovolodymyr.observer.IObserver;
import com.kovalenkovolodymyr.observer.subject.ISubject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Messenger implements ISubject {
    private static List<MessageType> messageTypes;
    private List<IObserver> observers;

    public Messenger() {
        observers = new ArrayList<>();
        messageTypes = new ArrayList<>();
    }

    public static List<MessageType> getMessageTypes() {
        return messageTypes;
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void trigger() {
        observers.forEach(IObserver::update);
    }

    public void startReceivingMessages() {
        ScheduledThreadPoolExecutor scheduler = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        scheduler.scheduleWithFixedDelay(this::receiveMessage, 0, 1, TimeUnit.SECONDS);
    }

    private void receiveMessage() {
        messageTypes.add(MessageType.randomMessageType());
        trigger();
    }
}
