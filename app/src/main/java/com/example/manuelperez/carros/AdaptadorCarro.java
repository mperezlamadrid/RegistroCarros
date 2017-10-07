package com.example.manuelperez.carros;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by manuelperez on 10/7/17.
 */

public class AdaptadorCarro extends BaseAdapter {
    private Context contexto;
    private ArrayList<Carro> carros;
    private Resources res;
    private String textMarca[], textModelo[], textColor[];

    public AdaptadorCarro(Context contexto, ArrayList<Carro> carros) {
        this.contexto = contexto;
        this.carros = carros;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        res = contexto.getResources();

        textMarca = res.getStringArray(R.array.arr_marca);
        textModelo = res.getStringArray(R.array.arr_modelo);
        textColor = res.getStringArray(R.array.arr_color);

        View v = view;

        LayoutInflater inf = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inf.inflate(R.layout.item_lista, null);

        Carro c = carros.get(i);

        ImageView foto = (ImageView)v.findViewById(R.id.imgFoto);
        TextView marca = (TextView)v.findViewById(R.id.lblMarca);
        TextView modelo = (TextView)v.findViewById(R.id.lblModelo);
        TextView color = (TextView)v.findViewById(R.id.lblColor);
        TextView placa = (TextView)v.findViewById(R.id.lblPlaca);
        TextView precio = (TextView)v.findViewById(R.id.lblPrecio);

        foto.setImageDrawable(ResourcesCompat.getDrawable(res, c.getFoto(), null));
        marca.setText(textMarca[c.getMarca()]);
        modelo.setText(textModelo[c.getModelo()]);
        color.setText(textColor[c.getColor()]);
        placa.setText(c.getPlaca());
        precio.setText("$ "+c.getPrecio());

        return v;
    }
}
