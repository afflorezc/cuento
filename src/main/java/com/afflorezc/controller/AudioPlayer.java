package com.afflorezc.controller;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayer {

    private Media audioClip;
    private MediaPlayer player;
    private double volume;

    public AudioPlayer(String path, double volume) {
        
        this.volume = volume;
        
        File audioFile = new File(path);
        try {
            audioClip = new Media(audioFile.toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            player = new MediaPlayer(audioClip);
            player.setVolume(volume);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void play() {
        if(player != null){
            player.play();
        }
        
    }

    public void pause(){
        if(player != null){
            player.pause();
        }
        
    }

    public void loop() {
        if(player != null){
            player.setCycleCount(MediaPlayer.INDEFINITE);
            player.play();
        }
       
    }

    public void stop() {
        if(player != null){
            player.stop();
        }
        
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
