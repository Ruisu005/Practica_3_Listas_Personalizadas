package com.example.listaspersonalizadasfrutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String listFrutas[];
    double precios[];
    int listImagenes[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String [] listF, double[] precios, int [] imagenes){
        this.context = ctx;
        this.listFrutas = listF;
        this.precios = precios;
        this.listImagenes = imagenes;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listFrutas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    convertView =inflater.inflate(R.layout.elemento_lista, null);
    TextView textView = (TextView) convertView.findViewById(R.id.nombreF);
        TextView precioView = convertView.findViewById(R.id.precio);
        ImageView frutImagen = (ImageView) convertView.findViewById(R.id.imagenFruta);
        textView.setText(listFrutas[position]);
        precioView.setText("$" + String.valueOf(precios[position]));
        frutImagen.setImageResource(listImagenes[position]);
        return convertView;
    }
}
