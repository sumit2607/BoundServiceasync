package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return new ServiceBinder();
    }


    public void play() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public  void pause() {
        if (mediaPlayer.isPlaying()) {


            mediaPlayer.pause();
        }
    }

     public  void stop() {
         if (mediaPlayer.isPlaying()) {
             mediaPlayer.stop();


         }
     }
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.ss);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    public class  ServiceBinder extends Binder{
        public MyService getService(){
            return  MyService.this;// return the service object
        }

    }
}