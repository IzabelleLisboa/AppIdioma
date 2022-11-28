package com.example.appidioma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Traducao extends AppCompatActivity {


    private int[] cores = {R.drawable.azul,R.drawable.amarelo,R.drawable.cinza,R.drawable.laranja,R.drawable.rosa,R.drawable.roxo,R.drawable.verde,R.drawable.vermelho,R.drawable.vermelho};
    private String[] NomeCores = new String[]{"Azul","Amarelo","Cinza","Laranja","Rosa","Roxo","Verde","Vermelho","Preto"};

    private Spinner sp;
    private TextView nome;
    private ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traducao);

        nome = findViewById(R.id.txtnome);
        img1 = findViewById(R.id.img);
        sp = findViewById(R.id.spinner);

        ArrayAdapter<String> traducao = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Regioes);
        sp.setAdapter(traducao);

        //APLICAR O CÓDIGO AO EVENTO DE SELEÇÃO DAS AÇÕES
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    img1.setImageResource(cores[0]);
                    nome.setText(NomeCores[0]);
                }
                if (i == 1) {
                    img1.setImageResource(cores[0]);
                    nome.setText(NomeCores[0]);
                }

                Toast.makeText(Traducao.this, sp.getSelectedItem() + "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

            public void Voltar(View v) {
                Intent it = new Intent(Traducao.this, Menu.class);
                startActivity(it);
                finish();
            }
        }

