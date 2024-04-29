package com.afflorezc.controller;

import javax.swing.JLabel;

import com.afflorezc.util.HtmlFormatting;

public class TextAnimationPause extends Thread {

    private String monitor;
    private String text;
    private JLabel textLabel;
    private String fullText;
    private int index;
    private int totalChars;

    public TextAnimationPause(String fullText, JLabel textLabel, String monitor){
        
        this.monitor = monitor;
        this.fullText = fullText;
        this.textLabel = textLabel;
        this.totalChars = fullText.length();
        index = 1;
    }

     public String getText() {
        return text;
    }

    public void updateText(){
        String text = fullText.substring(0, index);
        text = HtmlFormatting.wrapInParragraph(text);
        text = HtmlFormatting.asHtml(text);
        textLabel.setText(text);
    }

    public void pause() throws InterruptedException{

        synchronized(monitor){

            while(index < totalChars){
                monitor.notify();  
                index++;
                updateText(); 
                Thread.sleep(50);
            }
        }
    }

    @Override
	public void run() {
        try{
            this.pause();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }

}
