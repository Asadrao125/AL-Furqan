package com.example.asadrao.islamicapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class prayer_times extends AppCompatActivity {

    TextView tvfajar, tvZohar, tvAsar, tvMaghrib, tvIsha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_times);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Prayer_Times");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String fajar = dataSnapshot.child("Fajar").getValue(String.class);
                String zohar = dataSnapshot.child("Zohar").getValue(String.class);
                String asar = dataSnapshot.child("Asar").getValue(String.class);
                String maghrib = dataSnapshot.child("Maghrib").getValue(String.class);
                String isha = dataSnapshot.child("Isha").getValue(String.class);

                tvfajar = findViewById(R.id.tvfajar);
                tvZohar = findViewById(R.id.tvZohar);
                tvAsar = findViewById(R.id.tvAsar);
                tvMaghrib = findViewById(R.id.tvMaghrib);
                tvIsha = findViewById(R.id.tvIsha);

                tvfajar.setText(fajar);
                tvZohar.setText(zohar);
                tvAsar.setText(asar);
                tvMaghrib.setText(maghrib);
                tvIsha.setText(isha);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
