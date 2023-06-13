package com.example.listaspersonalizadasfrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {

    ListView detallesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        detallesListView = findViewById(R.id.detallesListView);

        SharedPreferences sharedPreferences = getSharedPreferences("DetallesFruta", Context.MODE_PRIVATE);
        String nombreFruta = sharedPreferences.getString("nombre", "");
        String precioTotal = sharedPreferences.getString("precio", "");
        int imagenFruta = sharedPreferences.getInt("imagen", Integer.parseInt(""));

        ArrayList<String> detallesList = new ArrayList<>();
        detallesList.add(""+ imagenFruta);
        detallesList.add("Nombre: " + nombreFruta);
        detallesList.add("Precio: $" + precioTotal);

        ArrayAdapter<String> detallesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, detallesList);
        detallesListView.setAdapter(detallesAdapter);
    }
}