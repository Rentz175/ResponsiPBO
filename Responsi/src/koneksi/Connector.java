/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
/**
 *
 * @author Lab Informatika
 */
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;

public class Connector {
    
    static Connection con;
    
    public static Connection connection(){
        if(con==null){
            MysqlDataSource data= new MysqlDataSource();
        data.setDatabaseName("perpustakaan");
        data.setUser("root");
        data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("Koneksi Berhasil");
                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Koneksi Gagal");
            }
        }
        return con;
    }
            
}
