/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hamza
 */
public class Student extends User {
   
    String fcb[];
    boolean successful=false;
    private String ID;
    private String Attendance;
    private String Course;
    private String Address;
    private String Semester;
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }
    private String Phonenum;

    public Student() {
        this.fcb = new String[10];
    }

    public Student(String Name, String ID, String Password, String Attendance) {
        super(Name, Password);
        this.fcb = new String[10];
        this.ID = ID;
        this.Attendance = Attendance;
    }

    public void setPhonenum(String phonenum) {
        this.Phonenum = phonenum;
    }

    public String getPhonenum() {
        return Phonenum;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getID() {
        return ID;
    }
  
    public void setAttendance(String attendance){
       this.Attendance = attendance;
   }

    public String getAttendance(){
       return Attendance;
   }
    public void setCourse(String course){
        Course = course;
    }
    public String getCourse(){
        return Course;
    }
    @Override
      public void login(String username, String password){
        
        DB connect=new DB();
        try {
              
             try (Connection con = connect.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "SELECT * FROM Student where username = '"+username+"'";
                 ResultSet rs = st.executeQuery(sql);
                 while(rs.next()){
                     String ID=rs.getString("ID");
                     String Username = rs.getString("Username");
                     String Password = rs.getString("Password");
                     if(username.equals(Username) && password.equals(Password))
                     {
                        String sql1 = "SELECT * FROM AddStudent";
                         ResultSet rs1 = st.executeQuery(sql1);
                         while(rs1.next())
                         {
                             String ID1=rs1.getString("ID");
                             String Username1 = rs1.getString("StuName");
                             String Address1=rs1.getString("Address");
                             String Semester1=rs1.getString("Semester");
                             String PhnNUM=rs1.getString("PhoneNumber");
                             if(ID.equals(ID1))
                             {
                                 UIstu stu = new UIstu();
                                 stu.setVisible(true);
                                 UIstu.jlname.setText(Username1);
                                 UIstu.id.setText(ID);
                                 UIstu.name.setText(Username1);
                                 UIstu.add.setText(Address1);
                                 UIstu.sem.setText(Semester1);
                                 UIstu.pnum.setText(PhnNUM);
                             }
                         }
                         successful=true;
                         break;
                     }
                 }
                 if(successful==false)
                 {
                    
                     Popup p= new Popup();
                     p.setlabel("Please check your username and Password");
                     p.show();
                     UIlogin l=new UIlogin();
                     l.show();
                    
                 }
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }   
      }
    //Student check attendance
    public void checkattendance(String n,String i){
        DB c=new DB();
        String credit_hour="3";
        int ch= Integer.parseInt(credit_hour);
           Attendance a=new Attendance();
           UIstu s=new UIstu();
            String []sub={"OOP","MVC","DLD","DLDLab","Pakstudies","English","Calculus","DiscreteMaths","OOPLab"};
              try {
              Connection con = c.setConnection();    
              Statement st = con.createStatement();
              DefaultTableModel dtm = new DefaultTableModel();
                    dtm.addColumn("Course Name");
                    dtm.addColumn("Credit Hours");
                    dtm.addColumn("Presents");
                    dtm.addColumn("Absents");
                    dtm.addColumn("Attendance");
            for (String sub1 : sub) {
                if (sub1.equals("Pakstudies") || sub1.equals("English")) {
                    credit_hour="2";
                    ch= Integer.parseInt(credit_hour);
                }
                if (sub1.equals("OOPLab") || sub1.equals("DLDLab")) {
                    credit_hour="1";
                    ch=Integer.parseInt(credit_hour);
                }
                String sql = "SELECT * FROM " + sub1;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    String ID1=rs.getString(1);
                    String SName = rs.getString(2);
                    String presents=rs.getString(3);
                    String absents=rs.getString(4);
                    if (n.equals(ID1)&&i.equals(SName)) {
                    int attendancei=Integer.parseInt(presents);
                    if (attendancei<17&&ch==1) {
                            attendancei=(attendancei*100)/(ch*16);
                            String att=""+attendancei;
                            String[] temp = {sub1, credit_hour, presents, absents, att+"%"};
                            dtm.addRow(temp);
                            break;
                        }
                        if (attendancei<33&&ch==2) {
                            attendancei=(attendancei*100)/(ch*16);
                            String att=""+attendancei;
                            String[] temp = {sub1, credit_hour, presents, absents, att+"%"};
                            dtm.addRow(temp);
                            break;
                        } 
                         if (attendancei<49&&ch==3) {
                            attendancei=(attendancei*100)/(ch*16);
                            String att=""+attendancei;
                            String[] temp = {sub1, credit_hour, presents, absents, att+"%"};
                            dtm.addRow(temp);
                            break;
                         }
                         else {
                            String[] temp = {sub1, credit_hour, presents, absents, "Course Completed"};
                            dtm.addRow(temp);
                            break;
                        }
                    }
                }
            }
             a.jTable1.setModel(dtm);
             a.show();
        }
              catch(SQLException e)
        {
            System.out.println(e);
        }
    } 
    public void feedback(){
        String feedback = UIstu.jtxtareafeedback.getText();
        String stuname = UIstu.jlname.getText();
        File file = new File("feedback.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bufw = new BufferedWriter(fw);
            bufw.write(stuname + ":");
            bufw.write(feedback);
            UIstu.jtxtareafeedback.setText("");
            bufw.newLine();
            bufw.flush();
            fw.flush();
        } catch (IOException ex) {}
    }
}
