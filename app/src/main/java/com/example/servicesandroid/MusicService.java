package com.example.servicesandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MusicService extends Service {

MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //unbounded service ko start karny k liye onStartCommand use karty
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

    mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI );

    mp.setLooping(true);//loop main chala rha takay pta lagay k bar bar run ho g
        mp.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mp.stop();
        super.onDestroy();
    }

}
