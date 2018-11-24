package mx.ipn.cic.practicaform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etNombre = findViewById(R.id.etNombre);
        final EditText etEscuela = findViewById(R.id.etEscuela);
        final EditText etEdad = findViewById(R.id.etEdad);
        final EditText etHobby = findViewById(R.id.etHobby);

        Button btnLimpiar = findViewById(R.id.btnLimpiar);
        Button btnArmar = findViewById(R.id.btnArmar);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNombre.getText().clear();
                etEscuela.getText().clear();
                etEdad.getText().clear();
                etHobby.getText().clear();
            }
        });

        btnArmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( etNombre.getText().toString().isEmpty() ||
                        etEscuela.getText().toString().isEmpty() ||
                        etEdad.getText().toString().isEmpty() ||
                        etHobby.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Se deben completar todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i("TAG", "Intent");
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("nombre", etNombre.getText().toString());
                    intent.putExtra("escuela", etEscuela.getText().toString());
                    intent.putExtra("edad", Integer.parseInt(etEdad.getText().toString()));
                    intent.putExtra("hobby", etHobby.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
