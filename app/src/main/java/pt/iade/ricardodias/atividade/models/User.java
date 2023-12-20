package pt.iade.ricardodias.atividade.models;

public class User {
    private int id;
    private String username;

    public User(String username,int id){
        this.username = username;
        this.id = id;
    }
    public String getUsername(){return username;}
    public int getId(){return id;}
    public void setUsername(String username){this.username = username;}
    public void setId(int id){this.id = id;}
}
