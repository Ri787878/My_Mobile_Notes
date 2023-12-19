package pt.iade.ricardodias.my_mobile_notes.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import pt.iade.ricardodias.my_mobile_notes.R;
import pt.iade.ricardodias.my_mobile_notes.adapters.NoteItemRowAdapter;
import pt.iade.ricardodias.my_mobile_notes.models.NoteItem;
/*
* Uma Activity principal chamada de MainActivity onde o utilizador terá uma lista (RecyclerView) de notas
* com título e um breve sumário de apenas uma linha do corpo da nota (basta copiar o layout que todas as aplicações
*  de notas seguem para a lista de notas). (5 pontos)
* Deverá conter uma Toolbar com um botão para criar uma nova nota.
* */

public class MainActivity extends AppCompatActivity {
    protected RecyclerView notesListView;
    protected NoteItemRowAdapter adapter;
    protected ArrayList<NoteItem> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the NoteItems from the web sarver
        notesList = NoteItem.List();
        setupComponents();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_menu, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuitem) {
        if (menuitem.getItemId() == R.id.action_new_note){
            //ActionBar "ADD" note button.
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);

            intent.putExtra("item", new NoteItem());
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(menuitem);
    }

    private void setupComponents() {
        //Setup the Action Bar
        setSupportActionBar(findViewById(R.id.main_activity_toolbar));

        //Setup the row Adapter for the RecyclerView with the NoteItems
        adapter = new NoteItemRowAdapter(this, notesList);

        //Setup the RecyclerView
        notesListView = (RecyclerView) findViewById(R.id.main_activity_notes_list);
        notesListView.setLayoutManager(new LinearLayoutManager(this));
        notesListView.setAdapter(adapter);

    }
}