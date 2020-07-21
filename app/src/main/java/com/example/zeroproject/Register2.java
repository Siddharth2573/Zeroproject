package com.example.zeroproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class Register2 extends AppCompatActivity {

    EditText full,phone1;

    Spinner idspinner5, idspinner6, idspinner4;
    Button submitBtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ProgressBar progressBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Workers");
        full = (EditText) findViewById(R.id.full);
        phone1 = (EditText) findViewById(R.id.phone1);
        idspinner5 = (Spinner) findViewById(R.id.idspinner5);
        idspinner6 = (Spinner) findViewById(R.id.idspinner6);
        idspinner4 = (Spinner) findViewById(R.id.idspinner4);
        submitBtn = (Button) findViewById(R.id.submitBtn);


        String[] numbers = {"+977"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, numbers);
        idspinner4.setAdapter(adapter);

        String[] District1 = {"Location", "Achham ", "Arghakhanchi", "Baglung",
                "Baitadi", "Bajhang ", "Bajura", "Banke", "Banke", "Bara", "Bardiya", "Bhaktapur ", "Bhojpur", "Chitwan ", "Dadeldhura", " Dailekh", " Dang", " Deokhuri", "Darchula", " Dhading ", "Dhankuta", " Dhanusa ", "Dolakha", " Dolpa", " Doti ", "Gorkha", " Gulmi", " Humla ", "Ilam", " Jajarkot", " Jhapa ", "Jumla", " Kailali ", "Kalikot ", "Kanchanpur", " Kapilvastu", " Kaski ", "Kathmandu ", "Kavrepalanchok ", "Khotang", " Lalitpur", " Lamjung", " Mahottari ", "Makwanpur ", "Manang ", "Morang ", "Mugu", " Mustang ", "Myagdi ", "Nawalparasi", " Nuwakot", " Okhaldhunga", "Palpa", "Panchthar ", "Parbat ", "Parsa ", "Pyuthan ", "Ramechhap ", "Rasuwa ", "Rautahat ", "Rolpa ", "Rukum ", "Rupandehi ", "Salyan ", "Sankhuwasabha ", "Saptari ", "Sarlahi ", "Sindhuli ", "Sindhupalchok ", "Siraha ", "Solukhumbu ", "Sunsari ", "Surkhet ", "Syangja ", "Tanahu ", "Taplejung ", "Terhathum", "Udayapur", "other"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_layout, District1);
        idspinner6.setAdapter(adapter1);

        String[] Work = {"Work", "Achham ", "Arghakhanchi", "Baglung",
                "Baitadi", "Bajhang ", "Bajura", "Banke", "Banke", "Bara", "Bardiya", "Bhaktapur ", "Bhojpur", "Chitwan ", "Dadeldhura", " Dailekh", " Dang", " Deokhuri", "Darchula", " Dhading ", "Dhankuta", " Dhanusa ", "Dolakha", " Dolpa", " Doti ", "Gorkha", " Gulmi", " Humla ", "Ilam", " Jajarkot", " Jhapa ", "Jumla", " Kailali ", "Kalikot ", "Kanchanpur", " Kapilvastu", " Kaski ", "Kathmandu ", "Kavrepalanchok ", "Khotang", " Lalitpur", " Lamjung", " Mahottari ", "Makwanpur ", "Manang ", "Morang ", "Mugu", " Mustang ", "Myagdi ", "Nawalparasi", " Nuwakot", " Okhaldhunga", "Palpa", "Panchthar ", "Parbat ", "Parsa ", "Pyuthan ", "Ramechhap ", "Rasuwa ", "Rautahat ", "Rolpa ", "Rukum ", "Rupandehi ", "Salyan ", "Sankhuwasabha ", "Saptari ", "Sarlahi ", "Sindhuli ", "Sindhupalchok ", "Siraha ", "Solukhumbu ", "Sunsari ", "Surkhet ", "Syangja ", "Tanahu ", "Taplejung ", "Terhathum", "Udayapur", "other"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_layout, Work);
        idspinner5.setAdapter(adapter2);

        submitBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                addworker();
                startActivity(new Intent(getApplicationContext(),Listofworker.class));
            }
        });
    }


    private void addworker() {
        String mfull = full.getText().toString();
        String mphone = phone1.getText().toString();
        String work = idspinner5.getSelectedItem().toString();
        String Address = idspinner6.getSelectedItem().toString();
        if (!TextUtils.isEmpty(mfull)) {
            String id = databaseReference.push().getKey();
            Workerdata workerdata = new Workerdata(mfull, mphone, work, Address);
            databaseReference.child(id).setValue(workerdata);
            Toast.makeText(this, "Worker added", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Enter full name", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(mphone)){
            phone1.setError("Email is Required.");
            return;
        }
    }


}