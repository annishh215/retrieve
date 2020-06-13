package com.example.retrieve;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private Button b1,b2;
    private String t1,t2;
    private String e;

    DatabaseReference dbu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et2 = (EditText) findViewById(R.id.et2);
        et1 = (EditText) findViewById(R.id.et1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        et2.setEnabled(false);
        et1.setEnabled(false);
        dbu = FirebaseDatabase.getInstance().getReference("user");




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e = b1.getText().toString();
                if (e.equals("Edit")){
                    et2.setEnabled(true);
                    et1.setEnabled(true);
                    b1.setText("Save");
                }if (e.equals("Save")){
                    add();
                    b1.setText("Edit");
                    et2.setEnabled(false);
                    et1.setEnabled(false);
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getBaseContext(), userdata.class);
                startActivity(s);
            }
        });
    }

    private void add() {

        t1 = et1.getText().toString();
        t2 = et2.getText().toString();
        String id = dbu.push().getKey();
        user u = new user(id,t1,t2);
        dbu.child(id).setValue(u);

    }


}


