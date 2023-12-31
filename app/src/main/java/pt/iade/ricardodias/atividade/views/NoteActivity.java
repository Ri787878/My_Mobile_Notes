
package pt.iade.ricardodias.atividade.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.ZoneId;

import pt.iade.ricardodias.atividade.models.NoteItem;
import pt.iade.ricardodias.my_mobile_notes.R;

/*
* Uma Activity chamada NoteActivity onde o utilizador poderá visualizar, editar e criar uma nota. (5 pontos)
* Deverá ter um EditText para o título da nota, um MultilineEditText para o corpo da nota,
* um TextView para a data da última modificação.
 */

public class NoteActivity extends AppCompatActivity {
    protected EditText title;
    protected EditText content;
    protected TextView modifiedDate;
    protected NoteItem item;
    protected int listPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        //Get the NoteItem from the intent
        Intent intent = getIntent();
        listPosition = intent.getIntExtra("position", -1);
        item = (NoteItem) intent.getSerializableExtra("item");


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
            commitView();
            this.item.save();
            //Setup data to be sent back to the MainActivity
            Intent returnIntent = new Intent();
            returnIntent.putExtra("position", this.listPosition);
            returnIntent.putExtra("item", this.item);
            setResult(RESULT_OK, returnIntent);
            finish();
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

        //Get components into variables
        title = (EditText) findViewById(R.id.note_activity_title);
        content = (EditText) findViewById(R.id.note_activity_context);
        modifiedDate = (TextView) findViewById(R.id.note_activity_date);

        //Populate the view with the data from the NoteItem
        populateView();
    }
    protected void populateView(){
        title.setText(item.getTitle());
        content.setText(item.getContent());
        modifiedDate.setText(item.getModifiedDate().toString());

    }
    protected void commitView(){
        item.setTitle(title.getText().toString());
        item.setContent(content.getText().toString());
        item.setModifiedDate(LocalDate.now(ZoneId.of("UTC")));
    }
}