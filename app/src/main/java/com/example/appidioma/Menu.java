package com.example.appidioma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void Frutas(View v) {
        Intent it = new Intent(Menu.this,Frutas.class);
        startActivity(it);
        finish();

    } public void Cores(View v) {
        Intent it = new Intent(Menu.this, Cores.class);
        startActivity(it);
        finish();


    } public void Animais(View v) {
        Intent it = new Intent(Menu.this, Animais.class);
        startActivity(it);
        finish();
    }
    public void DiasSem(View v) {
        Intent it = new Intent(Menu.this, DiasSemana.class);
        startActivity(it);
        finish();
    }
    public void Sair(View v){
        finish();
    }
}