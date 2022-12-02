package com.example.appidioma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Cores extends AppCompatActivity {


    private String[] Escolha= new String[]{"Laranja", "Amarelo", "Azul", "Cinza"};
    private String[] NomeCores = new String[]{"Πορτοκαλί", "Κίτρινο", "Μπλε", "Γκρι"};
    private String[] nomeSom = new String[]{"laranja", "amarelo", "azul", "cinza"};


    private int[] Cores = {R.drawable.laranja, R.drawable.amarelo, R.drawable.azul, R.drawable.cinza};


    private Spinner sp;
    private TextView nome;
    private ImageView img1;
    private int id;
    private  int pos;
    private MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cores);

        nome = findViewById(R.id.txtnome2);
        img1 = findViewById(R.id.img2);
        sp = findViewById(R.id.spinner2);

        ArrayAdapter<String> traducao = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Escolha);
        sp.setAdapter(traducao);

        //APLICAR O CÓDIGO AO EVENTO DE SELEÇÃO DAS AÇÕES
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                img1.setImageResource(Cores[i]);
                nome.setText(NomeCores[i]);
                pos=i;

                Toast.makeText(Cores.this, sp.getSelectedItem() + "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }


    public void ouvir (View v){
        String pkg = this.getPackageName();
        //obter o id da musica
        id = this.getResources().getIdentifier(nomeSom[pos], "raw", pkg);
        //associar musica com class MediaPlayer para ser reproduzido
        this.mp = MediaPlayer.create(this,id);
        mp.start();}


//-----------------------------------------------------------------------------------------------
    public void Voltar(View v) {
        Intent it = new Intent(Cores.this, Menu.class);
        startActivity(it);
        finish();
    }
}


