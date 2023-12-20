package pt.iade.ricardodias.atividade.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Random;

/*
* Uma classe modelo de uma nota chamada NoteItem. (2 pontos)
* Esta classe deverá conter obrigatoriamente os campos de title,*  content (corpo da nota),
* creationDate (data da criação da nota), modifiedDate (data da última alteração da nota).
* Também deverá conter métodos para listagem (List), obter uma nota (GetById), atualizar ou
* salvar uma nova nota (save) e remover uma nota (delete).
 */

public class NoteItem implements Serializable {
    private int id;
    private String title;
    private String content;
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    public NoteItem(){
        this.id = 0;
        this.title = "";
        this.content = "";
        this.creationDate = LocalDate.now(ZoneId.of("UTC"));
        this.modifiedDate = LocalDate.now(ZoneId.of("UTC"));
    }

    public NoteItem(int id, String title, String content, LocalDate createDate, LocalDate modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = LocalDate.now(ZoneId.of("UTC"));
        this.modifiedDate = LocalDate.now(ZoneId.of("UTC"));
    }
    //Code to be replaced for the web server version
    public static ArrayList<NoteItem> List(){
        ArrayList<NoteItem> notes = new ArrayList<>();
        notes.add(new NoteItem(1, "Note 1", "Note 1 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(2, "Note 2", "Note 2 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(3, "Note 3", "Note 3 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(4, "Note 4", "Note 4 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(5, "Note 5", "Note 5 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(6, "Note 6", "Note 6 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(7, "Note 7", "Note 7 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(8, "Note 8", "Note 8 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(9, "Note 9", "Note 9 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        notes.add(new NoteItem(10, "Note 10", "Note 10 content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC"))));
        return notes;
    }
    //Get a NoteItem by id from the web server version
    public static NoteItem GetById(int id){
        return new NoteItem(id, "Note " + id, "Note " + id + " content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC")));
    }
    //Until here
    public void save(){
        //TO DO: Save the note to the web server
        if(id == 0){
            //brand new object that needs to go to the database
            id = new Random().nextInt(1000) + 1;
        } else {
            //existing object that needs to be updated in the database
        }
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
