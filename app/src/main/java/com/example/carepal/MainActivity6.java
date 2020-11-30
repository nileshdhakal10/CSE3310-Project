package com.example.carepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MainActivity6 extends AppCompatActivity {
    EditText name, age, height, weight, gender, dname, dnum, ddate, kin, knum;
    Button updateinfo, displayinfo;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        name = findViewById(R.id.name1);
        age = findViewById(R.id.age1);
        height = findViewById(R.id.height1);
        weight = findViewById(R.id.weight1);
        gender = findViewById(R.id.gender1);
        dname = findViewById(R.id.dname1);
        dnum = findViewById(R.id.doc_num1);
        ddate = findViewById(R.id.ddate1);
        kin = findViewById(R.id.kin1);
        knum = findViewById(R.id.kin_num1);
        updateinfo = findViewById(R.id.updateinfo1);
        member = new Member();

        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        updateinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                member.setName(name.getText().toString().trim());
                member.setAge(age.getText().toString().trim());
                member.setHeight(height.getText().toString().trim());
                member.setWeight(weight.getText().toString().trim());
                member.setGender(gender.getText().toString().trim());
                member.setDname(dname.getText().toString().trim());
                member.setDnum(dnum.getText().toString().trim());
                member.setDdate(ddate.getText().toString().trim());
                member.setKin(kin.getText().toString().trim());
                member.setKnum(knum.getText().toString().trim());
                reff.child(name.getText().toString().trim()).child("personalInfo").setValue(member);
                Toast.makeText(MainActivity6.this, "Information Updated", Toast.LENGTH_LONG).show();
                Intent backTomenu = new Intent(MainActivity6.this, MainActivity4.class);
                startActivity(backTomenu);
            }
        });


    }
}
