package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText e1=(EditText)findViewById(R.id.editText);
        final EditText e2=(EditText)findViewById(R.id.editText2);
        Button b1=(Button)findViewById(R.id.button);
        final String MyPREFERENCES = "MyPrefs" ;
        final String Email= "nameKey";
        final String Pass = "phoneKey";
        final SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = e1.getText().toString();
                String ph  = e2.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Email, n);
                editor.putString(Pass, ph);
                e1.getText().clear();
                e2.getText().clear();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_SHORT).show();
            }
        });

        Button b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedpreferences.contains(Email)) {
                    e1.setText(sharedpreferences.getString(Email, ""));
                }
                if (sharedpreferences.contains(Pass)) {
                    e2.setText(sharedpreferences.getString(Pass, ""));

                }
            }
        });



    }
}
