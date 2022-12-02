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

public class Animais extends AppCompatActivity {
    private String[] Escolha = new String[]{"Abelha","Gato","Vaca","Elefante"};
    private String[] NomeAnimais = new String[]{"Μέλισσα", "Γάτα", "Αγελάδα", "Ελέφαντας"};
    private String[] nomeSom = new String[]{"abelha", "gato", "vaca", "elefante"};
    private int[] animais = {R.drawable.bee,R.drawable.cat,R.drawable.cow,R.drawable.elephant};


    private Spinner sp;
    private TextView nome;
    private ImageView img1;
    private int id;
    private  int pos;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais);

        nome = findViewById(R.id.txtnomean);
        img1 = findViewById(R.id.imgan);
        sp = findViewById(R.id.sp2);

        ArrayAdapter<String> traducao = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Escolha);
        sp.setAdapter(traducao);

        //APLICAR O CÓDIGO AO EVENTO DE SELEÇÃO DAS AÇÕES
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                img1.setImageResource(animais[i]);
                nome.setText(NomeAnimais[i]);
                pos=i;


                Toast.makeText(Animais.this, sp.getSelectedItem() + "", Toast.LENGTH_LONG).show();
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
    //---------------------------------------------------------------------
    public void Voltar(View v) {
        Intent it = new Intent(Animais.this, Menu.class);
        startActivity(it);
        finish();
    }
}