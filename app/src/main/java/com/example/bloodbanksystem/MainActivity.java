package com.example.bloodbanksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 5000 ;

    //variables
    Animation topAnime, bottomAnime;
    ImageView image;
    TextView title, subtitle;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnime = AnimationUtils.loadAnimation(this,R.animator.top_animation);
        bottomAnime = AnimationUtils.loadAnimation(this,R.animator.bottom_animation);

        //Hooks
        image = findViewById(R.id.imageView);
        title = findViewById(R.id.textView);
        subtitle = findViewById(R.id.textView2);

        image.setAnimation(topAnime);
        title.setAnimation(bottomAnime);
        subtitle.setAnimation(bottomAnime);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);





    }
}