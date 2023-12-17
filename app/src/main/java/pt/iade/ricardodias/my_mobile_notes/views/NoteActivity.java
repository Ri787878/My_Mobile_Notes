
package pt.iade.ricardodias.my_mobile_notes.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pt.iade.ricardodias.my_mobile_notes.R;

/*
* Uma Activity chamada NoteActivity onde o utilizador poderá visualizar, editar e criar uma nota. (5 pontos)
* Deverá ter um EditText para o título da nota, um MultilineEditText para o corpo da nota,
* um TextView para a data da última modificação.
 */

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        setupComponents();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.noteitem_activity_menu, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_save_item){
            //TO DO: ActionBar "SAVE" note button.


            return true;
        } else if (item.getItemId() == R.id.action_delete_item){
            //TO DO: ActionBar "DELETE" note button.
            finish();



            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setupComponents() {
        //Setup the Action Bar
        setSupportActionBar(findViewById(R.id.note_activity_toolbar));

    }

}