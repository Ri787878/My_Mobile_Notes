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
    public static final int EDITOR_ACTIVITY_RETURN_ID = 1;
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

            intent.putExtra("position", -1);
            intent.putExtra("item", new NoteItem());
            startActivityForResult(intent,EDITOR_ACTIVITY_RETURN_ID);

            return true;
        }
        return super.onOptionsItemSelected(menuitem);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                if (requestCode == EDITOR_ACTIVITY_RETURN_ID){
                    if (resultCode == AppCompatActivity.RESULT_OK){
                        //Get the data from the intent and the position of the item
                        int position = data.getIntExtra("position", -1);
                        NoteItem updatedItem = (NoteItem) data.getSerializableExtra("item");

                        if(position == -1){
                            //Add the new item to the list and notify the adapter
                            notesList.add(updatedItem);
                            adapter.notifyItemInserted(notesList.size() - 1);
                        } else {
                            //Update the item in the list and notify the adapter
                            notesList.set(position, updatedItem);
                            adapter.notifyItemChanged(position);
                        }
                    }
                }
    }

    private void setupComponents() {
        //Setup the Action Bar
        setSupportActionBar(findViewById(R.id.main_activity_toolbar));

        //Setup the row Adapter for the RecyclerView with the NoteItems
        adapter = new NoteItemRowAdapter(this, notesList);
        adapter.setClickListener(new NoteItemRowAdapter.OnNoteItemClickListener() {


            @Override
            public void onNoteItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("item", notesList.get(position));
                startActivity(intent);

            }
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);

                intent.putExtra("item", notesList.get(position));
                startActivity(intent);
            }

        });

        //Setup the RecyclerView
        notesListView = (RecyclerView) findViewById(R.id.main_activity_notes_list);
        notesListView.setLayoutManager(new LinearLayoutManager(this));
        notesListView.setAdapter(adapter);

    }
}