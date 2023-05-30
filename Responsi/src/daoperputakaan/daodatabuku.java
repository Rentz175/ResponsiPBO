/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoperputakaan;

import java.util.List;
import model.databuku;
import java.sql.*;
import java.util.ArrayList;
import koneksi.Connector;
/**
 *
 * @author Lab Informatika
 */
public class daodatabuku implements daoimplement{
    
    Connection connection;
    
    String select = "select * from dataperpus;";
    String insert = "insert into dataperpus (id, judul, genre, penulis, penerbit, lokasi, stock) values (?,?,?,?,?,?,?);";
    String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?";
    String delete = "delete from dataperpus where id=?";
    String cari = "select * from data perpus where id=?";
    
    public daodatabuku(){
        connection = Connector.connection();
        PreparedStatement statement = null;
    }
            

    @Override
    public void simpan(databuku p) {
        connection = Connector.connection();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, p.getJudul());
            st.setString(2, p.getGenre());
            st.setString(3, p.getPenulis());
            st.setString(4, p.getPenerbit());
            st.setString(6, p.getLokasi());
            st.setInt(7, p.getStock());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            try {
                st.close();;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
 
    }

    @Override
    public void ubah(databuku p) {
        connection = Connector.connection();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(update);
            st.setString(1, p.getJudul());
            st.setString(2, p.getGenre());
            st.setString(3, p.getPenulis());
            st.setString(4, p.getPenerbit());
            st.setString(6, p.getLokasi());
            st.setInt(7, p.getStock());
            st.setInt(8, p.getId());
            st.executeUpdate();
        
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            try {
                st.close();;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void hapus(int id) {
       connection = Connector.connection();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(delete);
            st.setInt(1, id);
            
            st.executeUpdate();
        
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            try {
                st.close();;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void cari(databuku p) {
        connection = Connector.connection();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(cari);
            st.setString(1, p.getJudul());
            st.setString(2, p.getGenre());
            st.setString(3, p.getPenulis());
            st.setString(4, p.getPenerbit());
            st.setString(6, p.getLokasi());
            st.setInt(7, p.getStock());
            st.setInt(8, p.getId());
            st.executeUpdate();
        
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            try {
                st.close();;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<databuku> getAll() {
        List<databuku> db = null;
        try {
            db = new ArrayList<databuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                databuku buk = new databuku();
                buk.setId(rs.getInt("id"));
                buk.setJudul(rs.getString("judul"));
                buk.setGenre(rs.getString("genre"));
                buk.setPenulis(rs.getString("penulis"));
                buk.setPenerbit(rs.getString("penerbit"));
                buk.setStock(rs.getInt("stock"));
                db.add(buk);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return db;
    }

    @Override
    public void cari(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
