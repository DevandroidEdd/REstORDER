package com.example.restorder;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView chat = findViewById(R.id.chat);
        ImageView kitchen = findViewById(R.id.kitchen);
        bottomNavigationView = findViewById(R.id.bottomnavigationview);

        getSupportFragmentManager().beginTransaction().replace(R.id.linearlay,new Home()).commit();


        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                v.setChecket(true);
//                chat.setImageResource(R.drawable.ic_chat2);
                Toast.makeText(MainActivity.this, "chat bo'limi ishladi", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.linearlay,new Chat()).commit();

            }
        });

        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "kitchen onclick", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.linearlay,new Kitchen()).commit();

            }

        });
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){


                case R.id.item1:
                    item.setChecked(true);

                    getSupportFragmentManager().beginTransaction().replace(R.id.linearlay,new Home()).commit();

                    break;
                case R.id.item2:

                    getSupportFragmentManager().beginTransaction().replace(R.id.linearlay,new Stol()).commit();
                    break;
            }
            return true;
        });

    }
}