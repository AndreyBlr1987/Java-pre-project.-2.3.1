package web.Model;

import org.springframework.stereotype.Component;

@Component
public class User {

    private int id;

    private  String name ;

    private  String lastname ;

    private  String login ;

    public User() {
    }

    public User(int id, String name, String lastname, String login) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
