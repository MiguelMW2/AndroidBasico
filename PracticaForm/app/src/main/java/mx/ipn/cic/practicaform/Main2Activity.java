package mx.ipn.cic.practicaform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        if(intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String escuela = intent.getStringExtra("escuela");
            Integer edad = intent.getIntExtra("edad", -1);
            String hobby = intent.getStringExtra("hobby");
            String mensaje = String.format("Yo soy %s.\nEstudio en %s.\nTengo %d años.\nY me gusta %s.", nombre, escuela, edad, hobby);

            TextView tvTitle = findViewById(R.id.tvInformacion);
            tvTitle.setText(mensaje);

        }
    }
}
