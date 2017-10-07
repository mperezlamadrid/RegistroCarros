package com.example.manuelperez.carros;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearCarros extends AppCompatActivity {
    private String [] marca, modelo, color;
    private Spinner sMarca, sModelo, sColor;
    private EditText tPlaca, tPrecio;
    private Resources res;
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carros);

        sMarca = (Spinner) findViewById(R.id.cmbMarca);
        sModelo = (Spinner) findViewById(R.id.cmbModelo);
        sColor = (Spinner) findViewById(R.id.cmbColor);
        tPlaca = (EditText)findViewById(R.id.txtPlaca);
        tPrecio = (EditText)findViewById(R.id.txtPrecio);
        res = this.getResources();

        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

        marca = res.getStringArray(R.array.arr_marca);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,marca);
        sMarca.setAdapter(adapter);

        modelo = res.getStringArray(R.array.arr_modelo);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,modelo);
        sModelo.setAdapter(adapter1);

        color = res.getStringArray(R.array.arr_color);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,color);
        sColor.setAdapter(adapter2);
    }

    public void crear(View v){
        String placa;
        int precio, marca, modelo, color;

        placa = tPlaca.getText().toString();
        marca = sMarca.getSelectedItemPosition();
        modelo = sModelo.getSelectedItemPosition();
        color = sColor.getSelectedItemPosition();
        precio = Integer.parseInt(tPrecio.getText().toString());

        Carro c = new Carro(placa, marca, modelo, color, precio, Metodos.fotoAleatoria(fotos));
        c.guardar();

        Toast.makeText(this, res.getString(R.string.mensaje_guardado), Toast.LENGTH_SHORT).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    private void limpiar(){
        tPlaca.setText("");
        sMarca.setSelection(0);
        sModelo.setSelection(0);
        sColor.setSelection(0);
        tPrecio.setText("");

        tPlaca.requestFocus();
    }
}
