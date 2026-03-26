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
    Button btnSubtrair;
    Button btnMultiplicar;
    Button btnDividir;
    TextView txvResultado;

    public void executar(String op)
    {
        Double resultado = 0.0;

        try
        {
            Double n1 = Double.valueOf(edtPrimeiroNumero.getText().toString());
            Double n2 = Double.valueOf(edtSegundoNumero.getText().toString());
            if (op == "+")
                resultado = n1 + n2;
            if (op == "-")
                resultado = n1 - n2;
            if (op == "*")
                resultado = n1 * n2;
            if (op == "/")
            {
                if (n2 == 0)
                    txvResultado.setText("Divisão por zero");
                else
                {
                    resultado = n1 / n2;
                    txvResultado.setText(resultado.toString());
                }
            }
            else
            {
                txvResultado.setText(resultado.toString());
            }
        }
        catch (Exception e)
        {
            txvResultado.setText("Digite números válidos");
        }

    }

    public void configuracoes()
    {
        edtPrimeiroNumero = findViewById(R.id.edtPrimeiroNumero);
        edtSegundoNumero = findViewById(R.id.edtSegundoNumero);
        btnSomar = findViewById(R.id.btnSomar);
        btnSubtrair = findViewById(R.id.btnSubtrair);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        txvResultado = findViewById(R.id.txvResultado);
    }

    public void eventos()
    {
        btnDividir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                executar("/");
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                executar("*");
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                executar("-");
            }
        });

        btnSomar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                executar("+");
            }
        });
    }

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

        configuracoes();
        eventos();

    }
}