package com.example.listaspersonalizadasfrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int cantidadProductos = 0;
    double precioTotal = 0.0;

    String listFrutas[] = {"Manzana \n$4.00", "Platano \n$5.00", "Melon \n$23.00", "Sandia \n$25.00", "Kiwi \n$6.00", "Pera \n$5.00", "Uva \n$10.00", "Coco \n$15.00", "Papaya \n$18.00", "Mandarina \n$3.50"};

    double precios[] = {4.00, 5.00, 23.00, 25.00, 6.00, 5.00, 10.00, 15.00, 18.00, 3.00};
    int FrutasImages[] = {R.drawable.manzana, R.drawable.platano, R.drawable.melon, R.drawable.sandia, R.drawable.kiwi, R.drawable.pera, R.drawable.uva, R.drawable.coco, R.drawable.papaya, R.drawable.mandarina};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.detallesListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), listFrutas, precios, FrutasImages);
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("", "Haz Seleccionado" + position);
                Toast.makeText(getApplicationContext(), "Se Agrego al Carrito " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                String nombreFruta = listFrutas[position];
                double precioFruta = precios[position];
                int imagenFruta = FrutasImages[position];

                SharedPreferences sharedPreferences = getSharedPreferences("DetallesFruta", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nombre", nombreFruta);
                editor.putString("precioTotal", String.valueOf(precioTotal));
                editor.putInt("imagen", imagenFruta);
                editor.apply();

                cantidadProductos++;
                precioTotal += precioFruta;

            }
        });
    }

    public void Carrito (View view){
        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        startActivity(intent);
    }
}
