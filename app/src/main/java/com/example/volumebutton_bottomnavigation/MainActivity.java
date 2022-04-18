package com.example.volumebutton_bottomnavigation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
TextView tv;
int count=0;
RelativeLayout rl;
AnimationDrawable ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        tv=findViewById( R.id.maintextview1);
        rl=findViewById( R.id.gradientlayout );

        ad=(AnimationDrawable)rl.getBackground();
        ad.setEnterFadeDuration( 3000 );
        ad.setExitFadeDuration( 3000 );
        ad.start();

    }





    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN)
        {
            tv.setText( "count : "+String.valueOf( --count ) );
            Toast.makeText( getApplicationContext(),"Volume Down Button Pressed ",Toast.LENGTH_SHORT ).show();
            return true;
        }
        if(keyCode==KeyEvent.KEYCODE_VOLUME_UP)
        {
            tv.setText( "count : "+String.valueOf( ++count ) );
            Toast.makeText( getApplicationContext(),"Volume UpButton Pressed ",Toast.LENGTH_SHORT ).show();
            return true;
        }
        if(keyCode==KeyEvent.KEYCODE_POWER)
        {
            tv.setText( "power button presses :"+String.valueOf( ++count ) );
            Toast.makeText( getApplicationContext(),"you press on power button",Toast.LENGTH_SHORT ).show();
        event.startTracking();
        return true;
        }
       else
        {
            return super.onKeyDown( keyCode, event );
        }

    }
/////////////////////////// Location//////////////////////
    public void btnCurrentLocation(View view)
    {
        startActivity(new Intent(this,MapsActivity.class));
    }


}
