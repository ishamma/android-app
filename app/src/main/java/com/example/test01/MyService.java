package com.example.test01;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.view.DragStartHelper;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    MediaPlayer media;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Start Service",Toast.LENGTH_LONG).show();
        media = MediaPlayer.create(this , Settings.System.DEFAULT_RINGTONE_URI);
        media.setLooping(true);
        media.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Destroy Service",Toast.LENGTH_LONG).show();
        media.stop();
        super.onDestroy();
    }
}
