package mx.ipn.cic.activitiesexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener referencias de UI al código Java
        etUser = this.findViewById(R.id.etUser);
        etPassword = this.findViewById(R.id.etPassword);
        btnLogin = this.findViewById(R.id.btnLogin);

        //Asignar un comportamiento
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluarCamops();
            }
        });
    }

    private void evaluarCamops() {
        Log.i("TAG", "Hola mundo");
        if (etUser.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()) {
            //Mostrar un mensaje al usuario
            Toast.makeText(MainActivity.this, //getApplicationContext()
                    "Ambos campos deben completarse",
                    Toast.LENGTH_SHORT).show();
        } else {
            //Evaluar si es un usuario válido
            if (etUser.getText().toString().equals("Usuario") && etPassword.getText().toString().equals("123")) {
                //Usuario válido
                Toast.makeText(MainActivity.this, "Usuario válido", Toast.LENGTH_SHORT).show();

                //Mostrar otra interfaz
                Intent intent = new Intent(this, Main2Activity.class);

                //Envio de parámetros
                intent.putExtra("unEntero",5);
                intent.putExtra("unFlotante",4.2f);
                intent.putExtra("unaCadena","Hola Mundo!");

                startActivity(intent);

            } else {
                //Usuario invalido
                Toast.makeText(MainActivity.this, "Usuario inválido", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
