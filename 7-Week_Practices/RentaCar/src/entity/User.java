package entity;

public class User {
    private int user_id;
    private String user_name;
    private String user_pass;
    private String user_role;


    public User() {
    }

    public User(int user_id, String user_name, String user_pass, String user_role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "ID : " + user_id + "\n" + "Name : " + user_name + "\n" + "Password : " + user_pass + "\n" + "Permmision : " + user_role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
}
