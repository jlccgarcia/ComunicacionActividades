package com.example.comunicacionactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView dato_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarSecondActivity (View view) {
        //Se recoge el nombre introducido en el EditText
        EditText cuadro1=(EditText)findViewById(R.id.valor_nombre);
        String nombre=cuadro1.getText().toString();

        //Se "carga" la intención con el valor recogido
        Intent intent = new Intent(this, second_activity.class);
        intent.putExtra("usuario",  nombre);

        //Se llama a la nueva actividad esperando aquí el resultado que devuelva esa segunda actividad
        //llamada a startActivityForResult en vez de a startActivity (que se llamaría si la 2ª act no devolviera resultado)
        startActivityForResult(intent, 1234); //1234 - código de solicitud que identifica MI solicitud
    }

    //Para recoger el resultado devuelto por la segunda actividad
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==1234 && resultCode==RESULT_OK) {
            String res = data.getExtras().getString("resultado");
            dato_resultado=(TextView)findViewById(R.id.resultado);
            dato_resultado.setText("Resultado: " + res);
        }

    }

}
