package com.example.personalitycheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalitycheck.databinding.ActivityFinalpageBinding;
import com.example.personalitycheck.databinding.ActivityMainBinding;

import java.util.Random;

public class finalpage extends AppCompatActivity {
ActivityFinalpageBinding binding;
    private long pressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFinalpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_finalpage);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        Random random = new Random();
        int anger= random.nextInt(100);
        int love=random.nextInt(100);
        int care=random.nextInt(100);
        int money=random.nextInt(100);
        int intelligent=random.nextInt(100);
        int goodlooking=random.nextInt(100);
       binding.textView1.setText("ANGER 😠  :"+anger);
       binding.textView2.setText("LOVE ❤   :"+love);
       binding.textView3.setText("CARE 😊   :"+care);
       binding.textView4.setText("MONEY 🤑   :"+money);
       binding.textView5.setText("GOOD LOOKING 😎  :"+goodlooking);
       binding.textView6.setText("INTELLIGENT 😆  :"+intelligent);



    }
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}