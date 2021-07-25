package method;

import entity.Entitas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Control {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String sql=null;

    public Control(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scashier","root","");
            st=con.createStatement();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi kesalahaan Pada : \n"+a);
        }
    }

    public List tampil(){
        List logBarang = new ArrayList();  
//        sql="select no_jual from penjualan order by id_jual asc";
        sql="select no_jual from penjualan order by no_jual asc";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                Entitas eb=new Entitas();
                eb.setNoJual(rs.getString("no_jual"));               
                logBarang.add(eb);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan tampil, pada :\n"+a);
        }
        return logBarang;
    }
}
