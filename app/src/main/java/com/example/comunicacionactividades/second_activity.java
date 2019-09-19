package com.example.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class second_activity extends Activity {

    private TextView dato_mostrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //Se recoge el nombre pasado de la primera actividad y se muestra
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("usuario");
        dato_mostrar=(TextView)findViewById(R.id.mensaje);
        dato_mostrar.setText("Hola " + s + ", ¿aceptas las condiciones?");
    }

    public void lanzarMainActivity (View view) {
        //Cadena para devoler el resultado según el botón pulsado(ACEPTAR/RECHAZAR)
        String res="";

        Intent intent = new Intent(this, MainActivity.class);
        //Detectamos qué botón se pulsó y componemos la cadena a devolver
        switch (view.getId())
        {
            case R.id.b_aceptar:    //Se ha pulsado el botón aceptar --> Se devuelve la cadena "ACEPTAR"
                res="ACEPTAR";
                break;
            case R.id.b_rechazar:   //Se ha pulsado el botón rechazar --> Se devuelve la cadena "RECHAZAR"
                res="RECHAZAR";
                break;
        }
        intent.putExtra("resultado", res);
        setResult(RESULT_OK, intent);
        finish();
    }
}
