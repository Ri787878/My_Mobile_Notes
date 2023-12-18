package pt.iade.ricardodias.my_mobile_notes.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

/*
* Uma classe modelo de uma nota chamada NoteItem. (2 pontos)
* Esta classe deverá conter obrigatoriamente os campos de title,*  content (corpo da nota),
* creationDate (data da criação da nota), modifiedDate (data da última alteração da nota).
* Também deverá conter métodos para listagem (List), obter uma nota (GetById), atualizar ou
* salvar uma nova nota (save) e remover uma nota (delete).
 */

public class NoteItem {
    private int id;
    private String title;
    private String content;
    private LocalDate creationDate;
    private LocalDate modifiedDate;

    public NoteItem(int id, String title, String content, LocalDate createDate, LocalDate modifiedDate){
        this.id = id;
        this.title = "";
        this.content = "";
        this.creationDate = LocalDate.now(ZoneId.of("UTC"));
        this.modifiedDate = LocalDate.now(ZoneId.of("UTC"));
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
