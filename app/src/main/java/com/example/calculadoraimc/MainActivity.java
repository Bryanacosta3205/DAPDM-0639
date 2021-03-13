package com.example.calculadoraimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button calcular,nuevo,salir;
    private EditText estatura, peso;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.estatura = (EditText) findViewById(R.id.estatura);
        this.peso = (EditText) findViewById(R.id.peso);
        this.calcular = (Button) findViewById(R.id.calcular);
        this.nuevo = (Button) findViewById(R.id.nuevo);
        this.salir = (Button) findViewById(R.id.salir);
        this.imagen = (ImageView) findViewById(R.id.image);

    }

    public void calcularIMC(View v){
        String categoria;
        String cadena = estatura.getText().toString();
        float altura = Float.parseFloat(cadena);
        cadena = peso.getText().toString();
        float peso = Float.parseFloat(cadena);

        float imc = (float) (peso/Math.pow(altura,2));
        if (imc<18.5 ){
            categoria = "Tienes infrapeso";
            imagen.setImageResource(R.drawable.flaco);
            this.getResultado(imc,categoria);
        }else if(imc>18.5 && imc<24.9 ){
            categoria = "Peso normal";
            this.getResultado(imc,categoria);
            imagen.setImageResource(R.drawable.normal);
        }else if(imc>25 && imc<30){
            categoria = "Sobrepeso";
            this.getResultado(imc,categoria);
            imagen.setImageResource(R.drawable.fat);
        }else {
            categoria = "Obeso";
            this.getResultado(imc,categoria);
            imagen.setImageResource(R.drawable.superfat);
        }
    }

    private void getResultado(float valorImc,String msg){

        AlertDialog.Builder vent = new AlertDialog.Builder(this);
        vent.setMessage(String.valueOf(valorImc)+"\n"+msg);
        vent.setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                imagen.setImageResource(R.drawable.avatar_1);

            }
        });
        vent.create();
        vent.show();




    }

}