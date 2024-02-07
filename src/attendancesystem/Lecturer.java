/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;

import static attendancesystem.UIlect.jtbattendance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Hamza
 */
public class Lecturer extends User {
    boolean successful =false;
    private String address;
    private String phonenum;
    private String semester;
    private String Subject;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    public Lecturer(String Name,String Passport){
        super(Name, Passport);
    }
    
      public Lecturer(){
      
      }  
       public void setphonenum(String phonenum){
       this.phonenum = phonenum;
   }

    public String getphonenum(){
       return phonenum;
   }
      public void setaddress(String address){
          this.address = address;
      }
      public String getaddress(){
          return address;
      }
   
    @Override
     public void login(String username, String password){
         
         DB connect=new DB();
        try {      
             try (Connection con = connect.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "SELECT * FROM Teacher where username = '"+username+"'";
                 ResultSet rs = st.executeQuery(sql);
                 
                 while(rs.next()){
                     String ID=rs.getString("ID");
                     String Username = rs.getString("Username");
                     String Password1 = rs.getString("Password");
                     if(username.equals(Username) && password.equals(Password1))
                     {
                         String sql1 = "SELECT * FROM AddTeacher";
                         ResultSet rs1 = st.executeQuery(sql1);
                         while(rs1.next())
                         {
                             String ID1=rs1.getString("ID");
                             String Username1 = rs1.getString("TName");
                             String subject=rs1.getString("Subject");
                             if(ID.equals(ID1))
                             {
                                 UIlect lect = new UIlect();
                                 lect.setVisible(true);
                                 lect.jlname.setText(Username);
                                 lect.jlcourse.setText(subject);
                                 viewstu(subject);
                             }
                         }
                         successful=true;
                         break;}
                 }
                 if(successful==false)
                 {
                   Popup p=new Popup();
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
   //view all student
   public void viewstu(String sub){
       DB c=new DB();
        try {
           try (Connection con = c.setConnection()) {
               Statement st = con.createStatement();
               String sql = "SELECT * FROM "+sub;
               ResultSet rs = st.executeQuery(sql);
               DefaultTableModel dtm = new DefaultTableModel();
               dtm.addColumn("Student ID");
               dtm.addColumn("Student Name");
               dtm.addColumn("Attendance");
               while(rs.next()){
                   String ID=rs.getString(1);
                   String sName = rs.getString(2);
                   String attendance = rs.getString(3);
                   String[]temp={sName,ID,"PRESENT"};
                   if (temp[1].contains("(dropout)")) {
                       continue;
                   }
                   dtm.addRow(temp);
               }
               UIlect.jtbattendance.setModel(dtm);
               TableColumn att = UIlect.jtbattendance.getColumnModel().getColumn(2);
               JComboBox jcbatt = new JComboBox();
               jcbatt.addItem("PRESENT");
               jcbatt.addItem("ABSENT");
               att.setCellEditor(new DefaultCellEditor(jcbatt));
           }
              }catch(SQLException sqlEx){
                    System.out.println(sqlEx);
    } 
   }
   public void saveupdt()
   {
       String marking,sub,id;
    
        sub=UIlect.jlcourse.getText();
       
        DB c=new DB();
        
            try {              
        try (Connection con = c.setConnection()) {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM "+sub;
            ResultSet rs = st.executeQuery(sql);
            int i=0;
            while (rs.next()) {
                marking=String.valueOf(jtbattendance.getModel().getValueAt(i, 2)) ;
                id=String.valueOf(jtbattendance.getModel().getValueAt(i, 0));
                
                String mark= rs.getString(3);
                String absent=rs.getString(4);
                String idnum=rs.getString(1);
                String n1=rs.getString("SName");
                String tempat=rs.getString("tempatt");
               
                if(n1.contains("(dropout)"))
                {
                    i--;
                    continue;
                }
                
                   
                        if(tempat.equals(marking))
                        {
                                    
                        }
                        else if(marking.equals("PRESENT"))
                        {
                            int marki=Integer.parseInt(mark);
                            marki+=1;
                            mark=""+marki;
                            
                            String sql1 = "UPDATE "+sub+" SET Present=('"+mark+"') WHERE ID=('"+id+"')";
                            st.executeUpdate(sql1);
                            int markii=Integer.parseInt(absent);
                            markii-=1;
                            absent=""+markii;
                            String sql2 = "UPDATE "+sub+" SET Absent=('"+absent+"') WHERE ID=('"+id+"')";
                            st.executeUpdate(sql2);
                            String sql8 = "UPDATE "+sub+" SET tempatt=('"+marking+"') WHERE ID=('"+id+"')";
                            st.executeUpdate(sql8);
                        }
                    else
                    {
                            
                        int markii=Integer.parseInt(absent);
                        markii+=1;
                        absent=""+markii;
                        
                        String sql2 = "UPDATE "+sub+" SET Absent=('"+absent+"') WHERE ID=('"+id+"')";
                        st.executeUpdate(sql2);
                        int marki=Integer.parseInt(mark);
                        marki-=1;
                        mark=""+marki;
                        String sql1 = "UPDATE "+sub+" SET Present=('"+mark+"') WHERE ID=('"+id+"')";
                        st.executeUpdate(sql1);
                        String sql8 = "UPDATE "+sub+" SET tempatt=('"+marking+"') WHERE ID=('"+id+"')";
                        st.executeUpdate(sql8);
                            
                    }

                    
                        i++;
                        
                

            }
            
              DefaultTableModel dtm1 = new DefaultTableModel();
                Popup p=new Popup();
               UIlect.jtbattendance.setModel(dtm1);
                p.setlabel("SAVED");
                p.show();
           
           
        }
            }
              catch(NumberFormatException | SQLException sqlEx){
                    System.out.println(sqlEx);
    }
   }
   public void updateatt()
   {
         String marking,sub,id;

        sub=UIlect.jlcourse.getText();
        DB c=new DB();
        
            try {              
        try (Connection con = c.setConnection()) {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM "+sub;
            ResultSet rs = st.executeQuery(sql);
            int i=0;
               DefaultTableModel dtm = new DefaultTableModel();
               dtm.addColumn("Student ID");
               dtm.addColumn("Student Name");
               dtm.addColumn("Attendance");
            while (rs.next()) {
                String n1=rs.getString("SName");
                String id1=rs.getString("ID");
                String mark= rs.getString(3);
                String absent=rs.getString(4);
                String tempat=rs.getString("tempatt");
                String[]temp={id1,n1,tempat};
                
               
                if(n1.contains("(dropout)"))
                {
                    i--;
                    continue;
                }
                dtm.addRow(temp);
            }
             UIlect.jtbattendance.setModel(dtm);
            TableColumn att = UIlect.jtbattendance.getColumnModel().getColumn(2);
               JComboBox jcbatt = new JComboBox();
               jcbatt.addItem("PRESENT");
               jcbatt.addItem("ABSENT");
               att.setCellEditor(new DefaultCellEditor(jcbatt));

        }
            }
              catch(NumberFormatException | SQLException sqlEx){
                    System.out.println(sqlEx);
    }
   }
   //save attendance list
    public void markattendace() {
    String marking,sub,id;
    
        sub=UIlect.jlcourse.getText();
        DB c=new DB();
        
            try {              
        try (Connection con = c.setConnection()) {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM "+sub;
            ResultSet rs = st.executeQuery(sql);
            int i=0;
            while (rs.next()) {
                marking=String.valueOf(jtbattendance.getModel().getValueAt(i, 2)) ;
                id=String.valueOf(jtbattendance.getModel().getValueAt(i, 0));
                String mark= rs.getString(3);
                String absent=rs.getString(4);
                String idnum=rs.getString(1);
                String n1=rs.getString("SName");
                System.out.println(n1+" "+mark+" "+absent+"          "+marking);
                if(n1.contains("(dropout)"))
                {
                    
                    continue;
                }
                
                switch (marking) {
                    case "PRESENT":
                        int marki=Integer.parseInt(mark);
                        marki+=1;
                        mark=""+marki;
                        String sql1 = "UPDATE "+sub+" SET Present=('"+mark+"') WHERE ID=('"+id+"')";
                        st.executeUpdate(sql1);
                        String sql9 = "UPDATE "+sub+" SET tempatt=('"+marking+"') WHERE ID=('"+id+"')";
                        st.executeUpdate(sql9);
                        i++;
                        break;
                        
                    case "ABSENT":
                        marki=Integer.parseInt(absent);
                        marki+=1;
                        absent=""+marki;
                        System.out.println(marki);
                        System.out.println(mark+ " "+absent);
                        String sql2 = "UPDATE "+sub+" SET Absent=('"+absent+"') WHERE ID=('"+id+"')";
                        st.executeUpdate(sql2);
                        String sql8 = "UPDATE "+sub+" SET tempatt=('"+marking+"') WHERE ID=('"+id+"')";
                        st.executeUpdate(sql8);
                        i++;
                        break;
                        
                }
            }
            
              DefaultTableModel dtm1 = new DefaultTableModel();
                Popup p=new Popup();
               UIlect.jtbattendance.setModel(dtm1);
                p.setlabel("SAVED");
                p.show();
           
           
        }
            }
              catch(NumberFormatException | SQLException sqlEx){
                    System.out.println(sqlEx);
    }
  }

}
