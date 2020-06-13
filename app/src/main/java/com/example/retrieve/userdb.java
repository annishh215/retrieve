package com.example.retrieve;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class userdb extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter a;
    private List<user> li;
    private TextView tv3;
    private TextView tv4;
    DatabaseReference dbu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdb);
        dbu = FirebaseDatabase.getInstance().getReference("user");

        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));


        dbu.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                li = new ArrayList<>();
                for (DataSnapshot postSnapShot: dataSnapshot.getChildren())
                {
                    user Li = new user("id: "+ postSnapShot.child("id").getValue().toString(),
                            "name: "+postSnapShot.child("name").getValue().toString(),
                            "calories: "+postSnapShot.child("cals").getValue().toString());
                    li.add(Li);
                }
                a = new adapter(li,getApplicationContext());
                rv.setAdapter(a);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







    }
}
