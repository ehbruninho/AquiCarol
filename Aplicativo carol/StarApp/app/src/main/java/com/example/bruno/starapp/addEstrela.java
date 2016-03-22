package com.example.bruno.starapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.bruno.starapp.Banco.BancoController;

public class addEstrela extends AppCompatActivity {
    EditText edtNome,edtAula;
    RatingBar rtEstrela;
    Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_estrela);
        BtSalvarEstrela();
    }

    public void BtSalvarEstrela(){

        btSalvar = (Button)findViewById(R.id.btSalvar);

            btSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // chamar o controlador do banco
                    BancoController crud = new BancoController(getBaseContext());
                    EditText etNome = (EditText) findViewById(R.id.edtNome);
                    EditText etAula = (EditText) findViewById(R.id.edtAula);
                    RatingBar rtEstrela = (RatingBar) findViewById(R.id.rtEstrelas);
                    String nomeAString = etNome.getText().toString();
                    String aulaString = etAula.getText().toString();
                    int numEstrelaInt = Integer.parseInt(Integer.toString(rtEstrela.getNumStars()));
                    String resultado;

                    resultado = crud.InserirDados(nomeAString, aulaString, numEstrelaInt);
                    if("id"!=null) {
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }
                    MenuPrincipal(v);

                }
            });
    }

    public void MenuPrincipal(View v){
        Intent i = new Intent(this.getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
