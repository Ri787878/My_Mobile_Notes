package pt.iade.ricardodias.my_mobile_notes.models;

import java.util.Date;

/*
* Uma classe modelo de uma nota chamada NoteItem. (2 pontos)
* Esta classe deverá conter obrigatoriamente os campos de title,*  content (corpo da nota),
* creationDate (data da criação da nota), modifiedDate (data da última alteração da nota).
* Também deverá conter métodos para listagem (List), obter uma nota (GetById), atualizar ou
* salvar uma nova nota (save) e remover uma nota (delete).
 */

public class NoteItem {
    private int id;
    private int userId;
    private String title;
    private String content;
    private Date creationDate;
    private Date modifiedDate;

    public NoteItem(int id, String title, String content, Date createDate, Date modifiedDate, int userId){
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = createDate;
        this.modifiedDate = modifiedDate;
        this.userId = userId;
    }
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getContent(){return content;}
    public int getUserId(){return userId;}
    public Date getCreateDate(){return creationDate;}
    public Date getModifiedDate(){return modifiedDate;}
    public void setId(int id){this.id = id;}
    public void setTitle(String title){this.title = title;}
    public void setContent(String content){this.content = content;}
    public void setUserId(int userId){this.userId = userId;}
    public void setCreateDate(Date createDate){this.creationDate = createDate;}
    public void setModifiedDate(Date modifiedDate){this.modifiedDate = modifiedDate;}
    public void List(){System.out.println(id + " " + title + " " + content + " " + creationDate + " " + modifiedDate + " " + userId);}
    public void GetByID(int id){System.out.println(id + " " + title + " " + content + " " + creationDate + " " + modifiedDate + " " + userId);}
}
