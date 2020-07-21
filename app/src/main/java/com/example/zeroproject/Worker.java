package com.example.zeroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

public class Worker extends AppCompatActivity {
    Spinner spinner2;
    SearchView mysearchview;
    ListView mylist;
    Button button1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        mylist = (ListView) findViewById(R.id.list);
        mysearchview = (SearchView) findViewById(R.id.search);
        button1 = (Button) findViewById((R.id.button1));

        spinner2 = findViewById(R.id.idspinner3);
        String[] District={"District","Achham ","Arghakhanchi","Baglung" ,
                "Baitadi", "Bajhang ","Bajura","Banke","Banke","Bara","Bardiya", "Bhaktapur ","Bhojpur", "Chitwan ","Dadeldhura"," Dailekh"," Dang"," Deokhuri","Darchula"," Dhading ","Dhankuta"," Dhanusa ","Dolakha"," Dolpa"," Doti ","Gorkha"," Gulmi"," Humla ","Ilam"," Jajarkot"," Jhapa ","Jumla"," Kailali ","Kalikot ","Kanchanpur"," Kapilvastu"," Kaski ","Kathmandu ","Kavrepalanchok ","Khotang"," Lalitpur"," Lamjung"," Mahottari ","Makwanpur ","Manang ","Morang ","Mugu"," Mustang ","Myagdi ","Nawalparasi"," Nuwakot"," Okhaldhunga","Palpa","Panchthar ","Parbat ","Parsa ","Pyuthan ","Ramechhap ","Rasuwa ","Rautahat ","Rolpa ","Rukum ","Rupandehi ","Salyan ","Sankhuwasabha ","Saptari ","Sarlahi ","Sindhuli ","Sindhupalchok ","Siraha ","Solukhumbu ","Sunsari ","Surkhet ","Syangja ","Tanahu ","Taplejung ","Terhathum","Udayapur","other"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,District);
        spinner2.setAdapter(adapter1);

        String[] District1={"Achham ","Arghakhanchi","Baglung" ,
                "Baitadi", "Bajhang ","Bajura","Banke","Banke","Bara","Bardiya", "Bhaktapur ","Bhojpur", "Chitwan ","Dadeldhura"," Dailekh"," Dang"," Deokhuri","Darchula"," Dhading ","Dhankuta"," Dhanusa ","Dolakha"," Dolpa"," Doti ","Gorkha"," Gulmi"," Humla ","Ilam"," Jajarkot"," Jhapa ","Jumla"," Kailali ","Kalikot ","Kanchanpur"," Kapilvastu"," Kaski ","Kathmandu ","Kavrepalanchok ","Khotang"," Lalitpur"," Lamjung"," Mahottari ","Makwanpur ","Manang ","Morang ","Mugu"," Mustang ","Myagdi ","Nawalparasi"," Nuwakot"," Okhaldhunga","Palpa","Panchthar ","Parbat ","Parsa ","Pyuthan ","Ramechhap ","Rasuwa ","Rautahat ","Rolpa ","Rukum ","Rupandehi ","Salyan ","Sankhuwasabha ","Saptari ","Sarlahi ","Sindhuli ","Sindhupalchok ","Siraha ","Solukhumbu ","Sunsari ","Surkhet ","Syangja ","Tanahu ","Taplejung ","Terhathum","Udayapur","other"};

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,District1);
        mylist.setAdapter(adapter2);


        mysearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                adapter2.getFilter().filter(newText);

                return false;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register2.class));
            }
        });

    }
}