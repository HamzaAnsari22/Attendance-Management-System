/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;

/**
 *
 * @author Hamza
 */
public abstract class User {
    protected String Name;
    protected String  Password;
    
    public User(){
    
    }
    public User(String username, String password){
        this.Name = username;
        this.Password = password;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setPassword(String Password){
        this.Password = Password;
    }
    public String getName(){
        return Name;
    }
    public String getPassword(){
        return Password;
    }
    abstract void login(String username, String password);
    
    public void logout(){
    UIlogin login = new UIlogin();
    login.setVisible(true);
    
    }
}
