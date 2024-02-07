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
public class UILoginClass {
    private String Username;
    private String Password;
    private String selection;
    public UILoginClass(String Username,String Password,String selection)
    {
        this.Username=Username;
        this.Password=Password;
        this.selection=selection;
    }
    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public boolean frmopen(){
        UIlogin l=new UIlogin();
        boolean check=false;
        switch(selection){
            case "Student":
            Student stu = new Student();
            stu.login(getUsername(), getPassword());
                
          
            break;

            case "Lecturer":
            Lecturer lect = new Lecturer();
            lect.login(getUsername(), getPassword());
         
           
            break;

            case "Admin":
            Admin admin = new Admin();
             
            admin.login(getUsername(), getPassword());
         
            break;
        }
    return true;
    }
}
