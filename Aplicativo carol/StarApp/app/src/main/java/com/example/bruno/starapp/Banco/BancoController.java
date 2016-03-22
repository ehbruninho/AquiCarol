package com.example.bruno.starapp.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bruno on 09/03/2016.
 */
public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController (Context context){
        banco = new CriaBanco(context);
        //utiliza funçoes da classe Cria Banco
    }

    public String InserirDados (String nome, String tipoAula, int numEstrelas){
        ContentValues valores; // variavel armazena valores
        long resultado;

        db = banco.getWritableDatabase(); // Cria ou abre o banco
        valores = new ContentValues();
        valores.put("nomeAluno", nome);
        valores.put("aula", tipoAula);
        valores.put("numEstrelas",numEstrelas);

        resultado = db.insert("estrelas", null, valores);
        db.close();// muito importante fechar banco após operação

        if(resultado==-1)
            return "Erro ao inserir registro";
                else
                    return "Registro inserido com sucesso";

    }
    public Cursor carregaDados(){
        Cursor cursor;
        db = banco.getReadableDatabase();
        //Comando para pesquisar na tabela, todos nomes de aluno
        cursor = db.rawQuery("SELECT * FROM estrelas",null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
