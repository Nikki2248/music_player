package com.example.rocket.login_design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
         textView = (TextView) findViewById(R.id.signIn);
       //  textView.setOnClickListener(new View.OnClickListener() {
       //      @Override
       //      public void onClick(View view) {
          //       Intent intent = new Intent(MainActivity3.this,MainActivity.class);
           //      startActivity(intent);

          //   }
     //    });
    }




}
