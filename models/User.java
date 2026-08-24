package models;

public class User {
    private Integer userId;
    private String username;
    private String email;

    // Constructor
    public User(Integer userId, String username, String email ){
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    // Getters
    public Integer getId(){
        return userId;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    // Setters
    public void setId(Integer userId){
        this.userId = userId;
    } 

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }    
}
