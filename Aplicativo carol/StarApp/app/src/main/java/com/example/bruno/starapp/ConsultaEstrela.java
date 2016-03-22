package com.example.bruno.starapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.bruno.starapp.Banco.BancoController;


public class ConsultaEstrela extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{"id","nomeAluno","numEstrelas"};
        int[] idView = new int[] {R.id.txtId,R.id.txtNome, R.id.txtNumEstrelas};


        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this,
                R.layout.lista_estrelas,cursor,nomeCampos,idView, 0);

        lista=(ListView)findViewById(R.id.ltvDados);
        lista.setAdapter(adaptador);
    }
}
