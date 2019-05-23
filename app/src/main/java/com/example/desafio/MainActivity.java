package com.example.desafio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> lista = new ArrayList<>();
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View v) {
        EditText nome = findViewById(R.id.nome);
        EditText matricula = findViewById(R.id.matricula);
        EditText rg = findViewById(R.id.rg);
        EditText curso = findViewById(R.id.curso);

        person = new Person(nome.getText().toString(), rg.getText().toString(), matricula.getText().toString(), curso.getText().toString());

        lista.add(person);
    }

    public void show(View v) {
        LinearLayout showPanel = findViewById(R.id.showPanel);
        LinearLayout editPanel = findViewById(R.id.editPanel);

        list();

        showPanel.setVisibility(View.VISIBLE);
        editPanel.setVisibility(View.INVISIBLE);
    }

    public void back(View v) {
        LinearLayout showPanel = findViewById(R.id.showPanel);
        LinearLayout editPanel = findViewById(R.id.editPanel);

        showPanel.setVisibility(View.INVISIBLE);
        editPanel.setVisibility(View.VISIBLE);
    }

    public void list() {
        LinearLayout listPanel = findViewById(R.id.listPanel);

        for (Person p : lista) {

            TextView nome = new TextView(this);
            TextView matricula = new TextView(this);
            TextView rg = new TextView(this);
            TextView curso = new TextView(this);
            TextView empty = new TextView(this);

            nome.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            nome.setHeight(30);
            nome.setText("Nome: " + p.nome);

            matricula.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            matricula.setHeight(30);
            matricula.setText("Matrícula: " + p.matricula);

            rg.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            rg.setHeight(30);
            rg.setText("RG: " + p.rg);

            curso.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            curso.setHeight(30);
            curso.setText("Curso: " + p.curso);

            empty.setHeight(30);

            listPanel.addView(nome);
            listPanel.addView(matricula);
            listPanel.addView(rg);
            listPanel.addView(curso);
            listPanel.addView(empty);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        Context context = MainActivity.this;

        LinearLayout showPanel = findViewById(R.id.showPanel);
        LinearLayout editPanel = findViewById(R.id.editPanel);

        if (menuId == R.id.create) {
            Toast.makeText(context, "Create", Toast.LENGTH_LONG).show();
            showPanel.setVisibility(View.INVISIBLE);
            editPanel.setVisibility(View.VISIBLE);
        } else if (menuId == R.id.read) {
            Toast.makeText(context, "Read", Toast.LENGTH_LONG).show();
            list();
            showPanel.setVisibility(View.VISIBLE);
            editPanel.setVisibility(View.INVISIBLE);
        } else if (menuId == R.id.update) {
            Toast.makeText(context, "Update", Toast.LENGTH_LONG).show();
        } else if (menuId == R.id.delete) {
            Toast.makeText(context, "Delete", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}