package com.example.prueba_2_carlos_leal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etContraseña;
    private Button btnIniciarSesion;
    private Button btnRegistrarse;
    private ProgressBar progressBar;

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.et_usuario);
        etContraseña = findViewById(R.id.et_contraseña);
        btnIniciarSesion = findViewById(R.id.btn_iniciar);
        progressBar = findViewById(R.id.progressBar);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String contraseña = etContraseña.getText().toString();

                if (ADMIN_USERNAME.equals(usuario) && ADMIN_PASSWORD.equals(contraseña)) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso para el administrador", Toast.LENGTH_SHORT).show();

                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Inicio de sesión fallido para el usuario " + usuario, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
