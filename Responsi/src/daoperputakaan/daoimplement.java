/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoperputakaan;

import java.util.List;
import model.*;

/**
 *
 * @author Lab Informatika
 */
public interface daoimplement {
    public  void simpan(databuku p);
    public  void ubah(databuku p);
    public  void hapus(int id);
    public  void cari(databuku p);
    public List<databuku> getAll();

    public void cari(int id);
}
