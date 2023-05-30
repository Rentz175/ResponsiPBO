/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import daoperputakaan.daodatabuku;
import daoperputakaan.daoimplement;
import java.util.List;
import model.databuku;
import model.mtabelbuku;
import responsi.Responsi;
import view.perputakaanView;

/**
 *
 * @author Lab Informatika
 */
public class bukucontroler {
    perputakaanView frame;
    daoimplement impdata;
    List<databuku> db;

    public bukucontroler(perputakaanView frame) {
        this.frame = frame;
        impdata = new daodatabuku();
        db = impdata.getAll();
    }
    
    public void tampil(){
        db = impdata.getAll();
        mtabelbuku mt = new mtabelbuku(db);
        frame.getJtabel().setModel(mt);
        
    }
    
    public void insert(){
        databuku db = new databuku();
        int stock = Integer.parseInt(frame.getJtextStock().getText());
        db.setJudul(frame.getJtextJudul().getText());
        db.setGenre(frame.getJtextGenre().getText());
        db.setPenulis(frame.getJtextPenulis().getText());
        db.setPenerbit(frame.getJtextPenerbit().getText());
        db.setLokasi(frame.getJtextLokasi().getText());
        db.setStock(stock); 
        impdata.simpan(db);
   }
    
    public void update(){
        databuku db = new databuku();
        int stock = Integer.parseInt(frame.getJtextStock().getText());
        db.setJudul(frame.getJtextJudul().getText());
        db.setGenre(frame.getJtextGenre().getText());
        db.setPenulis(frame.getJtextPenulis().getText());
        db.setPenerbit(frame.getJtextPenerbit().getText());
        db.setLokasi(frame.getJtextLokasi().getText());
        db.setStock(stock); 
        impdata.ubah(db);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJtextID().getText());
        impdata.hapus(id);
        
    }
    
    public void cari(){
        databuku db = new databuku();
        int id = Integer.parseInt(frame.getjTextField8().getText());
        impdata.cari(db);
    }
}
