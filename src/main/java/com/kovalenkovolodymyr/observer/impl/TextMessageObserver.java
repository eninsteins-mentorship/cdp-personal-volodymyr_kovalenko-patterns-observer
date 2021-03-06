package com.kovalenkovolodymyr.observer.impl;

import com.kovalenkovolodymyr.observer.IObserver;
import com.kovalenkovolodymyr.observer.subject.impl.MessageType;
import com.kovalenkovolodymyr.observer.subject.impl.Messenger;
import com.kovalenkovolodymyr.sound.SoundPlayer;

public class TextMessageObserver implements IObserver {
    @Override
    public void update() {
        if (Messenger.getMessageTypes().get(Messenger.getMessageTypes().size() - 1).equals(MessageType.TEXT)) {
            System.out.println("New text message");
            SoundPlayer.playTextMessageSound();
        }
    }
}
