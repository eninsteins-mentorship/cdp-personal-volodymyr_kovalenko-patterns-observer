package com.kovalenkovolodymyr.sound;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;

public class SoundPlayer {
    private static final String VOICE_MESSAGE_MP3 = "src/main/resources/voiceMessage.mp3";
    private static final String TEXT_MESSAGE_MP3 = "src/main/resources/textMessage.mp3";
    private static final String VIDEO_MESSAGE_MP3 = "src/main/resources/videoMessage.mp3";

    public static void playVoiceMessageSound() {
        playSound(VOICE_MESSAGE_MP3);
    }

    public static void playTextMessageSound() {
        playSound(TEXT_MESSAGE_MP3);
    }

    public static void playVideoMessageSound() {
        playSound(VIDEO_MESSAGE_MP3);
    }

    private static void playSound(String filePath) {
        try (FileInputStream audioFileStream = new FileInputStream(filePath)) {
            Player player = new Player(audioFileStream);
            player.play();
        } catch (IOException e) {
            System.out.println("Failed to find file");
        } catch (JavaLayerException e) {
            System.out.println("Failed to play a sound");
        }
    }
}
