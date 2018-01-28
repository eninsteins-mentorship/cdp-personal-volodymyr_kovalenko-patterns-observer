package com.kovalenkovolodymyr;

import com.kovalenkovolodymyr.observer.impl.TextMessageObserver;
import com.kovalenkovolodymyr.observer.impl.VideoMessageObserver;
import com.kovalenkovolodymyr.observer.impl.VoiceMessageObserver;
import com.kovalenkovolodymyr.observer.subject.impl.Messenger;

public class Main {
    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        messenger.addObserver(new TextMessageObserver());
        messenger.addObserver(new VoiceMessageObserver());
        messenger.addObserver(new VideoMessageObserver());
        messenger.startReceivingMessages();
    }
}
