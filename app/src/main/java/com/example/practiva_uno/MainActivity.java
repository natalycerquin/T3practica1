package com.example.practiva_uno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rv_contacto = findViewById(R.id.recycler_view);
        rv_contacto.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_contacto.setLayoutManager(layoutManager);
        rv_contacto.setAdapter(new adaptadorContacto(getList(),this,MainActivity.this));

    }
    private List<contacto> getList(){

        List<contacto> contactos = new ArrayList<>();

        contacto  contacto1 = new contacto();
        contacto1.nombre = "Nataly Cerquin";
        contacto1.numero = "942341225";
        contactos.add(contacto1);

        contacto  contacto2 = new contacto();
        contacto2.nombre = "Pepito Perez";
        contacto2.numero = "942341225";
        contactos.add(contacto2);

        contacto  contacto3 = new contacto();
        contacto3.nombre = "Juan Perez";
        contacto3.numero = "942341225";
        contactos.add(contacto3);

        contacto  contacto4 = new contacto();
        contacto4.nombre = "Brayan Perez";
        contacto4.numero = "942341225";
        contactos.add(contacto4);

        contacto  contacto5 = new contacto();
        contacto5.nombre = "Juana Perez";
        contacto5.numero = "942341225";
        contactos.add(contacto5);

        contacto  contacto6 = new contacto();
        contacto6.nombre = "Paola Perez";
        contacto6.numero = "942341225";
        contactos.add(contacto1);

        contacto  contacto7 = new contacto();
        contacto7.nombre = "Tonny Perez";
        contacto7.numero = "942341225";
        contactos.add(contacto7);

        contacto  contacto8 = new contacto();
        contacto8.nombre = "Carlos Perez";
        contacto8.numero = "942341225";
        contactos.add(contacto8);

        contacto  contacto9 = new contacto();
        contacto9.nombre = "Luis Perez";
        contacto9.numero = "942341225";
        contactos.add(contacto9);

        contacto  contacto10 = new contacto();
        contacto10.nombre = "kevin Perez";
        contacto10.numero = "942341225";
        contactos.add(contacto10);

        return contactos;
    }
}