package pt.iade.ricardodias.my_mobile_notes.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

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
        return notes;
    }
    //Get a NoteItem by id from the web server version
    public static NoteItem GetById(int id){
        return new NoteItem(id, "Note " + id, "Note " + id + " content", LocalDate.now(ZoneId.of("UTC")), LocalDate.now(ZoneId.of("UTC")));
    }
    //Until here

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

}
