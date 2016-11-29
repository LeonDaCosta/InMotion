package com.lroxima.app.inmotion;

/**
 * Created by leon on 29/11/16.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.Locale;

public class TTSManager {
    private TextToSpeech myTTS;
    private boolean readyToSpeak = false;
    private Context context;

    public TTSManager(Context baseContext)
    {
        this.context = baseContext;
    }

    public void initOrInstallTTS()
    {
        myTTS = new TextToSpeech(context, new OnInitListener()
        {
            @Override
            public void onInit(int status)
            {
                if (status == TextToSpeech.SUCCESS)
                {
                    // TODO This needs to be set by device
                    myTTS.setLanguage(Locale.UK);
                    readyToSpeak = true;
                }
                else
                    installTTS();
            }
        });
    }

    private void installTTS()
    {
        Intent installIntent = new Intent();
        installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
        context.startActivity(installIntent);
    }

    public void speak(String text)
    {
        if (readyToSpeak){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                myTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
            } else {
                myTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
            
    }

}


}
