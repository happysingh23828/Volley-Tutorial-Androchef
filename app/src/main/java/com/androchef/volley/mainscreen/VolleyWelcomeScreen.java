package com.androchef.volley.mainscreen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androchef.volley.R;
import com.androchef.volley.normalvolleycall.MainActivity;

public class VolleyWelcomeScreen extends AppCompatActivity {

    TextView btnFetchList,btnPostData,cacheingData,androchefWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_welcome_screen);
        init();
        onClicks();
    }

    private void onClicks() {
        btnFetchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VolleyWelcomeScreen.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnPostData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VolleyWelcomeScreen.this,"Please wait until next tutorial..",Toast.LENGTH_SHORT).show();
            }
        });

        cacheingData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VolleyWelcomeScreen.this,"Please wait until next tutorial..",Toast.LENGTH_SHORT).show();

            }
        });

        androchefWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://androchef.com/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

    }

    private void init() {
        btnFetchList = findViewById(R.id.btn_fetch_data);
        btnPostData = findViewById(R.id.btn_post_data);
        cacheingData = findViewById(R.id.btn_cache_data);
        androchefWebsite = findViewById(R.id.textview_go_to_website);
    }
}
