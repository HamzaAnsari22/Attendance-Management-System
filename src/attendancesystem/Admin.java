/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;


import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hamza
 */
public class Admin extends User{
        public String fcb[]=new String [50];
        public boolean check=false;
        boolean successful =false;
        public Admin(String Username, String Password){
            super(Username, Password);
        }
        
        public Admin(){
        
        }
        @Override
    public void login(String username, String password){
         
        DB connect=new DB();
        try {
             try (Connection con = connect.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "SELECT * FROM Admin where username = '"+username+"'";
                 ResultSet rs = st.executeQuery(sql);    
                 while(rs.next())
                 {
                     String ID=rs.getString("ID");
                     String Username = rs.getString("Username");
                     String Password1 = rs.getString("Password");
                     if(username.equals(Username) && password.equals(Password1))
                     {   
                         UIadmin mstu = new UIadmin();
                         mstu.setVisible(true);
                         successful=true;
                         break;
                     }
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
   
    //register Student
    public void registerstu(String selection,String name, String Password,String address,String Semester,String Phonenum,boolean s1,boolean s2,boolean s3,boolean s4,boolean s5,boolean s6,boolean s7,boolean s8,boolean s9){
        String setid=null;
        String ap="0";
       boolean check1=false;
        DB c=new DB();
        Popup p=new Popup();
        Student stu = new Student();
        stu.setName(name);
        stu.setPassword(Password);
        stu.setAddress(address);
        stu.setSemester(Semester);
        stu.setPhonenum(Phonenum);
        String[] arr = new String[]{stu.getName(),stu.getPassword(),stu.getAddress(),stu.getSemester(),stu.getPhonenum()}; 
       
        if(name.equals("")||Password.equals("") ||address.equals("")||Semester.equals("") ||Phonenum.equals(""))
        {
            check=true;
            p.setlabel("Field Cannot Be Left Blank");
            p.show();
        }
         
        else if(s1==false&&s2==false&&s3==false&&s4==false&&s5==false&&s6==false&&s7==false&&s8==false&&s9==false)
         {
             check=true;
            p.setlabel("Atleast Select 1 Subject");
             p.show();
         
        }
        else{
            
            try{
            int n= Integer.parseInt(Semester);
            
            if(n>8)
            {
             check=true;
             check1=true;
            p.setlabel("Semester Number Is out Of Range");
            p.show();   
            }
            if(Phonenum.length()==11)
            {
            int ss=Integer.parseInt(Phonenum.substring(0, 8));
            int sl=Integer.parseInt(Phonenum.substring(8, 11));
            }
            else
            {
                check=true;
                check1=true;
                p.setlabel("PHONE NUMBER IS INVALID");
                p.show();
            }
        }
        catch(NumberFormatException e)
        {
            check=true;
            check1=true;
            p.setlabel("Please Enter Valid Semester or Phone Number");
            p.show();
           
        }
            if(check1==false){
             try {
                 try (Connection con = c.setConnection())
                 {
                     Statement st = con.createStatement();
                     String sql = "INSERT into AddStudent(ID,StuName,Password,Address,Semester,PhoneNumber) VALUES('"+"3"+"','"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"','"+arr[4]+"')";
                     st.executeUpdate(sql);
                     String sql3="SELECT * FROM AddStudent WHERE ([StuName]) =  ('" +arr[0]+ "') and ([Password]) = ('" +arr[1]+ "')";
                     ResultSet rs=st.executeQuery(sql3);
                     while(rs.next())
                     {
                         setid=rs.getString(1);
                     }
                     String sql2="INSERT into Student(ID,Username,Password) VALUES('"+setid+"','"+arr[0]+"','"+arr[1]+"')";
                     st.executeUpdate(sql2);
                 }
                }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
        if(s1==true){     
         try {
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into OOP(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
       }
          if(s2==true){             
         try {
              
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into MVC(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
       }   if(s3==true){             
         try {
              
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into DiscreteMaths(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
       }   if(s4==true){            
         try {
              
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into Pakstudies(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
       }   if(s5==true){             
         try {             
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into OOPLab(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
       }   if(s6==true){          
         try {            
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into DLD(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
       }   if(s7==true){             
         try {
              
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into DLDLab(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
       }   if(s8==true){
              
         try {             
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into Calculus(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
       }   if(s9==true){
         try {            
             try (Connection con = c.setConnection()) {
                 Statement st = con.createStatement();
                 String sql = "INSERT into English(ID,SName,Present,Absent,tempatt) VALUES('"+setid+"','"+arr[0]+"','"+ap+"','"+ap+"','"+"PRESENT"+"')";
                 st.executeUpdate(sql);
             }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
         }
        }
       }else{}
        }
    }
    //filling value for comboxbox (Lecturer)
    public void fillcombobox()
    {
        DB c=new DB();
           try {         
            try (Connection con = c.setConnection()) {
                Statement st = con.createStatement();
                String sql="Select * from Courses";
                ResultSet rs=st.executeQuery(sql);
                int i=0;
                while(rs.next())
                {
                    fcb[i]=rs.getString(2);
                    i++;
                }
            }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        } 
    }
    //register Lecturer
    public void registerlect(String selection,String name,String Password,String address,String semester, String phonenum,String subject){
        DB c=new DB();
        boolean check1=false;
        Popup p=new Popup();
        Lecturer lect = new Lecturer();
        lect.setPassword(Password);
        lect.setSemester(semester);
        lect.setSubject(subject);
        lect.setName(name);
        lect.setaddress(address);
        lect.setphonenum(phonenum);
        String[] arr = new String[]{lect.getName(),lect.getPassword(),lect.getaddress(),lect.getSemester(),lect.getphonenum(),lect.getSubject()}; 
        
         if(name.equals("")||Password.equals("") ||address.equals("")||semester.equals("") ||phonenum.equals(""))
        {
            check=true;
            p.setlabel("Field Cannot Be Left Blank");
            p.show();
        }
     
         else{
             try{
            if(phonenum.length()==11)
            {
            int ss=Integer.parseInt(phonenum.substring(0, 8));
            int sl=Integer.parseInt(phonenum.substring(8, 11));
            }
            else
            {
                check=true;
                check1=true;
                p.setlabel("PHONE NUMBER IS INVALID");
                p.show();
            }    
            
            }
          
        
        catch(NumberFormatException e)
        {
            check=true;
            check1=true;
            p.setlabel("Please Enter Valid Semester or Phone Number");
            p.show();
         }
             if(check1==false){
        try { 
            try (Connection con = c.setConnection()) {
                Statement st = con.createStatement();
                String sql = "INSERT into AddTeacher(ID,TName,Password,Address,Semester,PhoneNumber,Subject) VALUES('"+"3"+"','"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"','"+arr[4]+"','"+arr[5]+"')";
                st.executeUpdate(sql);
                String sql3="SELECT * FROM AddTeacher WHERE ([TName]) = ('" +arr[0]+ "') and ([Password]) = ('" +arr[1]+ "')" ;
                ResultSet rs=st.executeQuery(sql3);
                String setid=null;
            while(rs.next())
            {
                 setid=rs.getString(1);
            }
            String sql2="INSERT into Teacher(ID,Username,Password) VALUES('"+setid+"','"+arr[0]+"','"+arr[1]+"')";
            st.executeUpdate(sql2);
            }
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        } }else{} 
    }
}
    public void checkfeedback() {
        String line="";
      Scanner s = null;
        try {
            s = new Scanner (new File ("feedback.txt"));
        } catch (IOException e) {  
        Popup p=new Popup();
        p.setlabel("FILE DOESN'T EXIST");
        p.show();
        }
           while (s.hasNext()) {
            line+=s.nextLine()+"\n";
        } 
        UIstufeedback fb = new UIstufeedback();
        fb.setVisible(true);
         UIstufeedback.jtxtfeedback.append(line);
    }
    
    public void deletestu(){
     DB c=new DB();
     boolean found =false;
            try {            
         try (Connection con = c.setConnection()) {
             Statement st = con.createStatement();
             String sql = "SELECT * FROM AddStudent";
             ResultSet rs = st.executeQuery(sql);
            String name = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 1));
            String id = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 0));
            String line = "";
             while (rs.next()) {
                 String ID=rs.getString(1);
                 String userName = rs.getString(2);
                 String password = rs.getString(3);
                 String add=rs.getString(4);
                 String sem=rs.getString(5);
                 String Pn=rs.getString(6);
                 String[]temp={ID,userName,password,add,sem,Pn};
                 if (temp[1].equals(name)&&temp[0].equals(id)) {
                    if(name.contains(("(dropout)")))
                    {
                        Popup p=new Popup();
                        p.setlabel("RECORD IS ALREADY DELETED");
                        p.show();
                        
                    }
                else {
                         st.executeUpdate("DELETE FROM Student WHERE ([Username]) = ('" +name+ "')");
                         name+="(dropout)";
                         String sql1 = "UPDATE AddStudent SET StuName=('"+name+"') WHERE ID=('"+temp[0]+"')";
                         st.executeUpdate(sql1);
                         String []sub={"OOP","MVC","DLD","DLDLab","Pakstudies","English","Calculus","DiscreteMaths","OOPLab"};
                        for (String sub1 : sub) {
                            name+="(dropout)";
                            String sql4 = "UPDATE " + sub1 + " SET SName=('" + name + "') WHERE ID=('" + temp[0] + "')";
                            st.executeUpdate(sql4);
                        }
                found=true;
    
    
                DefaultTableModel dtm1 = new DefaultTableModel();
                Popup p=new Popup();
                UIadmin.jtblect.setModel(dtm1);
                p.setlabel("RECORD SUCCESSFULLY DELETED");
                p.show();
                    } 
                 }
                 else {}
             }
           }
        } 
              catch(SQLException sqlEx){
                    System.out.println(sqlEx); } 
 }
    
    public void deletelect() {
            DB c=new DB();
             boolean found =false;
            try {
                
                try (Connection con = c.setConnection()) {
                    Statement st = con.createStatement();
                    String sql = "SELECT * FROM AddTeacher";
                    ResultSet rs = st.executeQuery(sql);
                    String name = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 1));
                    String id = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 0));
                    String line = "";
                    while (rs.next()) {
                        String ID=rs.getString(1);
                        String userName = rs.getString(2);
                        String password = rs.getString(3);
                        String add=rs.getString(4);
                        String sem=rs.getString(5);
                        String Pn=rs.getString(6);
                        String sub=rs.getString(7);
                        String[]temp={ID,userName,password,add,sem,Pn,sub};
                        if (temp[1].equals(name)&&temp[0].equals(id)) {
                        if(name.contains(("(resigned)")))
                        {
                            Popup p=new Popup();
                            p.setlabel("RECORD IS ALREADY DELETED");
                            p.show();
                         }
                        else {
                         st.executeUpdate("DELETE FROM Teacher WHERE ([Username]) = ('" +name+ "')");
                         name+="(resigned)";
                         String sql1 = "UPDATE AddTeacher SET TName=('"+name+"') WHERE ID=('"+temp[0]+"')";
                         st.executeUpdate(sql1);
                         found=true;
                         DefaultTableModel dtm1 = new DefaultTableModel();
                         Popup p=new Popup();
                         UIadmin.jtblect.setModel(dtm1);
                         p.setlabel("RECORD SUCCESSFULLY DELETED");
                         p.show();        
                        }
                    }else {}
                        }
                    }
        } 
              catch(SQLException sqlEx){
                    System.out.println(sqlEx);
    } 
}
    
//    public void checkattendace(){
//        File file = new File("attendance.txt");
//        String s = null;
//        
//
//        try {
//            FileReader fr = new FileReader(file);
//            BufferedReader bufr = new BufferedReader(fr);
//            DefaultTableModel dtm = new DefaultTableModel();
//            dtm.addColumn("ID");
//            dtm.addColumn("Name");
//            dtm.addColumn("Attendance");
//            // 
//            // 
//
//            while ((s = bufr.readLine()) != null) {
//                String[] temp = s.split("\t");
//                String[] row = {temp[0], temp[1], temp[2]};
//                dtm.addRow(row);
//                UIadmin.jtblect.setModel(dtm);
//            }
//            TableColumn att = UIadmin.jtblect.getColumnModel().getColumn(2);
//            JComboBox jcbatt = new JComboBox();
//            jcbatt.addItem("ABSENT WITH REASON");
//            att.setCellEditor(new DefaultCellEditor(jcbatt));
//        } 
//        catch (IOException e) {
//        }
//    }
//    
    
    public void viewstu(){
        DB c=new DB();
        try {
              Connection con = c.setConnection();    
              Statement st = con.createStatement();
              String sql = "SELECT * FROM AddStudent";
              ResultSet rs = st.executeQuery(sql);
              DefaultTableModel dtm = new DefaultTableModel();
                    dtm.addColumn("ID");
                    dtm.addColumn("Name");
                    dtm.addColumn("Password");
                    dtm.addColumn("Address");
                    dtm.addColumn("Semester");
                    dtm.addColumn("Phone Num");
                  while(rs.next()){
                  String ID=rs.getString(1);
                  String userName = rs.getString(2);
                  String password = rs.getString(3);
                  String add=rs.getString(4);
                  String sem=rs.getString(5);
                  String Pn=rs.getString(6);
                  String[]temp={ID,userName,password,add,sem,Pn};
                 if (temp[1].contains("(dropout)")) {
                    continue;
                } 
                 dtm.addRow(temp); 
              }
              UIadmin.jtblect.setModel(dtm);
              con.close();
              }catch(SQLException sqlEx){
                    System.out.println(sqlEx);
    } 
}
    
    public void viewlect(){
         DB c=new DB();
        try {
              Connection con = c.setConnection();    
              Statement st = con.createStatement();
              String sql = "SELECT * FROM AddTeacher";
              ResultSet rs = st.executeQuery(sql);
          DefaultTableModel dtm = new DefaultTableModel();
                    dtm.addColumn("ID");
                    dtm.addColumn("Name");
                    dtm.addColumn("Password");
                    dtm.addColumn("Address");
                    dtm.addColumn("Semester");
                    dtm.addColumn("Phone Num");
                    dtm.addColumn("Subject");        
              while(rs.next()){
                  String ID=rs.getString(1);
                  String userName = rs.getString(2);
                  String password = rs.getString(3);
                  String add=rs.getString(4);
                  String sem=rs.getString(5);
                  String Pn=rs.getString(6);
                  String sub=rs.getString(7);
                  String[]temp={ID,userName,password,add,sem,Pn,sub};
                     if (temp[1].contains("(resigned)")) {
                    continue;
                } 
                    dtm.addRow(temp);
                   }
              UIadmin.jtblect.setModel(dtm);
              con.close();
              }catch(SQLException sqlEx){
                    System.out.println(sqlEx);
    } 
    }
    
    public void modifystu(){
         DB c=new DB();
     boolean found =false;
            try {            
         try (Connection con = c.setConnection()) {
             Statement st = con.createStatement();
             String sql = "SELECT * FROM AddStudent";
             ResultSet rs = st.executeQuery(sql);
            String id =   String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 0));
            String name = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 1));
            String pass = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 2));
            String addr = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 3));
            String sems = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 4));
            String phn =  String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 5));
         
             while (rs.next()) {
                 String ID=rs.getString(1);
                 String userName = rs.getString(2);
                 String password = rs.getString(3);
                 String add=rs.getString(4);
                 String sem=rs.getString(5);
                 String Pn=rs.getString(6);
                 String[]temp={ID,userName,password,add,sem,Pn};
              
                 if (temp[0].equals(id)) {
                   
                         st.executeUpdate("UPDATE Student SET Username=('"+name+"') , Password=('"+password+"') WHERE ([ID]) = ('" +temp[0]+ "')");
                         String sql1 = "UPDATE AddStudent SET StuName=('"+name+"') , Password=('"+password+"') , Address=('"+addr+"') , Semester=('"+sems+"') , PhoneNumber=('"+phn+"') WHERE ID=('"+temp[0]+"')";
                         st.executeUpdate(sql1);
                         String []sub={"OOP","MVC","DLD","DLDLab","Pakstudies","English","Calculus","DiscreteMaths","OOPLab"};
                        for (String sub1 : sub) {
                           
                            String sql4 = "UPDATE " + sub1 + " SET SName=('" + name + "') WHERE ID=('" + temp[0] + "')";
                            st.executeUpdate(sql4);
                        }
                found=true;
    
    
                DefaultTableModel dtm1 = new DefaultTableModel();
                Popup p=new Popup();
                UIadmin.jtblect.setModel(dtm1);
                p.setlabel("RECORD SUCCESSFULLY UPDATED");
                p.show();
                     
                 }
                 else {}
             }
           }
        } 
              catch(SQLException sqlEx){
                    System.out.println(sqlEx); }

    }
    
    public void modifylect() {
    
              DB c=new DB();
     boolean found =false;
            try {            
         try (Connection con = c.setConnection()) {
             Statement st = con.createStatement();
             String sql = "SELECT * FROM AddTeacher";
             ResultSet rs = st.executeQuery(sql);
            String id =   String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 0));
            String name = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 1));
            String pass = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 2));
            String addr = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 3));
            String sems = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 4));
            String phn =  String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 5));
            String subj = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 6));
           
            
             while (rs.next()) {
                 String ID=rs.getString(1);
                 String userName = rs.getString(2);
                 String password = rs.getString(3);
                 String add=rs.getString(4);
                 String sem=rs.getString(5);
                 String Pn=rs.getString(6);
                 String sb=rs.getString(7);
                 String[]temp={ID,userName,password,add,sem,Pn,sb};
              
                 if (temp[0].equals(id)) {
                   
                         st.executeUpdate("UPDATE Teacher SET Username=('"+name+"') , Password=('"+password+"') WHERE ([ID]) = ('" +temp[0]+ "')");
                         String sql1 = "UPDATE AddTeacher SET TName=('"+name+"') , Password=('"+password+"') , Address=('"+addr+"') , Semester=('"+sems+"') , PhoneNumber=('"+phn+"') , Subject=('"+subj+"') WHERE ID=('"+temp[0]+"')";
                         st.executeUpdate(sql1);
                       
                found=true;
    
    
                DefaultTableModel dtm1 = new DefaultTableModel();
                Popup p=new Popup();
                UIadmin.jtblect.setModel(dtm1);
                p.setlabel("RECORD SUCCESSFULLY UPDATED");
                p.show();
                     
                 }
                 else {}
             }
           }
        } 
              catch(SQLException sqlEx){
                    System.out.println(sqlEx); }
       
    }
    
    public void searchstu() {
        DB c=new DB();        
            boolean found =false;
            String s = UIadmin.jtxtsearch.getText();
            try {
            try (Connection con = c.setConnection()) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM AddStudent";
                ResultSet rs = st.executeQuery(sql);
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addColumn("ID");
                dtm.addColumn("Name");
                dtm.addColumn("Password");
                dtm.addColumn("Address");
                dtm.addColumn("Semester");
                dtm.addColumn("Phone Num");
                dtm.addColumn("PRESS");
                while(rs.next()){
                    String ID=rs.getString(1);
                    String userName = rs.getString(2);
                    String password = rs.getString(3);
                    String add=rs.getString(4);
                    String sem=rs.getString(5);
                    String Pn=rs.getString(6);
                    String[]temp={ID,userName,password,add,sem,Pn,"++++SAVE++++"};
                    String s1=s+"(dropout)";
                    if(s.equals(ID)||s.equalsIgnoreCase(userName)||s1.equalsIgnoreCase(userName))
                    {
                        dtm.addRow(temp);
                         found = true;
                    }
                }
                UIadmin.jtblect.setModel(dtm);
                if(!found)
                {
                    DefaultTableModel dtm1 = new DefaultTableModel();
                    Popup p=new Popup();
                    UIadmin.jtblect.setModel(dtm1);
                    p.setlabel("NO RECORD FOUND");
                    p.show();
                }
            }
              }catch(SQLException sqlEx){
                    System.out.println(sqlEx);
    }  UIadmin.jtblect.getColumn("PRESS").setCellRenderer(
        new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, 
                                                           Object value, 
                                                           boolean isSelected, 
                                                           boolean hasFocus, 
                                                           int row, 
                                                           int column) {
                setText(value.toString());
                setBackground( Color.GREEN);
               
                return this;
            }
        });
}
    
    public void searchlect() {
             DB c=new DB();        
             boolean found =false;
         String s = UIadmin.jtxtsearch.getText();
        try {
                 try (Connection con = c.setConnection()) {
                     Statement st = con.createStatement();
                     String sql = "SELECT * FROM AddTeacher";
                     ResultSet rs = st.executeQuery(sql);
                     DefaultTableModel dtm = new DefaultTableModel();
                     dtm.addColumn("ID");
                     dtm.addColumn("Name");
                     dtm.addColumn("Password");
                     dtm.addColumn("Address");
                     dtm.addColumn("Semester");
                     dtm.addColumn("Phone Num");
                     dtm.addColumn("Subject");
                     dtm.addColumn("PRESS");
                     while(rs.next()){
                         String ID=rs.getString(1);
                         String userName = rs.getString(2);
                         String password = rs.getString(3);
                         String add=rs.getString(4);
                         String sem=rs.getString(5);
                         String Pn=rs.getString(6);
                         String sub=rs.getString(7);
                         String[]temp={ID,userName,password,add,sem,Pn,sub,"+++SAVE+++"};
                         String s1=s+"(resigned)";
                         if(s.equals(ID)||s.equalsIgnoreCase(userName)||s1.equalsIgnoreCase(userName))
                         {
                             dtm.addRow(temp);
                            
                             found = true;
                         }
                     }
                     UIadmin.jtblect.setModel(dtm);
                     if(!found)
                     {
                         DefaultTableModel dtm1 = new DefaultTableModel();
                         Popup p=new Popup();
                         UIadmin.jtblect.setModel(dtm1);
                         p.setlabel("NO RECORD FOUND");
                         p.show();
                     }
                 }
              }catch(SQLException sqlEx){
                    System.out.println(sqlEx);
    } 
        UIadmin.jtblect.getColumn("PRESS").setCellRenderer(
        new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, 
                                                           Object value, 
                                                           boolean isSelected, 
                                                           boolean hasFocus, 
                                                           int row, 
                                                           int column) {
                setText(value.toString());
                setBackground(Color.GREEN);
               
                return this;
            }
        });
}
}
