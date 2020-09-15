package edu.txstate.ess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_password);
       Button acceptPassword =findViewById(R.id.btnMain);
       Button createPassword= findViewById(R.id.btnCreateAccount);

       createPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainPassword.this, PasswordToCreateAccount.class);
               startActivity(intent);
           }
       });

       acceptPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainPassword.this, MainActivity.class);
               startActivity(intent);
           }
       });
    }
}
