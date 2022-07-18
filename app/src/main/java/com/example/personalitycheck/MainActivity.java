package com.example.personalitycheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personalitycheck.databinding.ActivityMainBinding;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE ="com.example.myfirstapp.MESSAGE" ;
    ActivityMainBinding binding;
    private long pressedTime;
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_main);




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
    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String getname=editText.getText().toString();
        if (getname.isEmpty() || getname.isEmpty()){
            Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show();
        }
        else{
        Intent intent = new Intent(this, finalpage.class);
         editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString().toUpperCase();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);}
    }

}