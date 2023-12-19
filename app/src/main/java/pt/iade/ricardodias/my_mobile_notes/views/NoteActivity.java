
package pt.iade.ricardodias.my_mobile_notes.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import pt.iade.ricardodias.my_mobile_notes.R;
import pt.iade.ricardodias.my_mobile_notes.models.NoteItem;

/*
* Uma Activity chamada NoteActivity onde o utilizador poderá visualizar, editar e criar uma nota. (5 pontos)
* Deverá ter um EditText para o título da nota, um MultilineEditText para o corpo da nota,
* um TextView para a data da última modificação.
 */

public class NoteActivity extends AppCompatActivity {
    protected EditText titleEdit;
    protected EditText contentEdit;
    protected TextView modifiedDateText;
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
        titleEdit = (EditText) findViewById(R.id.note_activity_title);
        contentEdit = (EditText) findViewById(R.id.note_activity_context);
        modifiedDateText = (TextView) findViewById(R.id.note_activity_date);

        //Populate the view with the data from the NoteItem
        populateView();
    }
    protected void populateView(){
        titleEdit.setText(item.getTitle());
        contentEdit.setText(item.getContent());
        modifiedDateText.setText(item.getModifiedDate().toString());

    }
    protected void commitView(){
        item.setTitle(titleEdit.getText().toString());
        item.setContent(contentEdit.getText().toString());
        item.setModifiedDate(LocalDate.now(ZoneId.of("UTC")));
    }
}