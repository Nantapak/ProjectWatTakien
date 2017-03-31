package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource
//        ImageView img = (ImageView)findViewById(R.id.imageView14);
//        img.setBackgroundResource(R.drawable.splashlist);
//        // Get the background, which has been compiled to an AnimationDrawable object.
//        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default).
//        frameAnimation.start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }
}


