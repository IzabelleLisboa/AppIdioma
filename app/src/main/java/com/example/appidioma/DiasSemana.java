package com.example.appidioma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DiasSemana extends AppCompatActivity {


    private String[] Escolha= new String[]{"Segunda-Feira","Terça-Feira","Quarta-Feira","Quinta-Feira","Sexta-Feira","Sábado","Domingo"};
    private  int[] diassemana = {R.drawable.seg,R.drawable.ter,R.drawable.quar,R.drawable.quin,R.drawable.sex,R.drawable.sabado,R.drawable.dom};
    private String[] NomeDiasSem = new String[]{"Δευτέρα","Τρίτη","Τετάρτη","Πέμπτη","Παρασκευή","Σάββατο","Κυριακή"};
    private String[] nomeSom = new String[]{"seg","ter","quar","quin","sex","sab","dom"};


    private Spinner sp;
    private TextView nome;
    private ImageView img1;
    private int id;
    private  int pos;
    private MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias_semana);

        nome = findViewById(R.id.txtnome3);
        img1 = findViewById(R.id.img3);
        sp = findViewById(R.id.spinner3);

        ArrayAdapter<String> traducao = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Escolha);
        sp.setAdapter(traducao);

        //APLICAR O CÓDIGO AO EVENTO DE SELEÇÃO DAS AÇÕES
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                img1.setImageResource(diassemana[i]);
                nome.setText(NomeDiasSem[i]);
                pos=i;

                Toast.makeText(DiasSemana.this, sp.getSelectedItem() + "", Toast.LENGTH_LONG).show();
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
//--------------------------------------------------------------------------
    public void Voltar(View v) {
        Intent it = new Intent(DiasSemana.this, Menu.class);
        startActivity(it);
        finish();
    }
}