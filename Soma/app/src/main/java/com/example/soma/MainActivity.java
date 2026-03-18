package com.example.soma;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    EditText edtPrimeiroNumero;
    EditText edtSegundoNumero;
    Button btnSomar;
    TextView txvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtPrimeiroNumero = findViewById(R.id.edtPrimeiroNumero);
        edtSegundoNumero = findViewById(R.id.edtSegundoNumero);
        btnSomar = findViewById(R.id.btnSomar);
        txvResultado = findViewById(R.id.txvResultado);

        btnSomar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Double n1 = Double.valueOf(edtPrimeiroNumero.getText().toString());
                Double n2 = Double.valueOf(edtSegundoNumero.getText().toString());
                Double resultado = n1 + n2;

                txvResultado.setText(resultado.toString());
            }
        });
    }
}