package com.example.taskscheduling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
EditText editText;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler=new Handler();
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.extView);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editTextTextPersonName);

//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.this,"sorabh is legend ",Toast.LENGTH_SHORT).show();
//                handler.postDelayed(this,10000);
//            }
//        };
//        runnable.run();

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int time=Integer.parseInt(editText.getText().toString())*60000;
        new CountDownTimer(time,1000) {
            int i=0;
            @Override
            public void onTick(long millisUntilFinished) {

                textView.setText(String.valueOf(millisUntilFinished/1000)+" second finshed");
            }

            @Override
            public void onFinish() {
                textView.setText("your time over");
            }
        }.start();
    }
});
   }
}