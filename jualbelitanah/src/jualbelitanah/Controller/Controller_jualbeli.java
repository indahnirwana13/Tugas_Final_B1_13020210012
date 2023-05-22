package jualbelitanah.Controller;

import jualbelitanah.DAO.DAO_jualbeli;
import jualbelitanah.DAOImplement.Implement_jualbeli;
import jualbelitanah.Model.Model_jualbeli;
import jualbelitanah.Model.Tabel_jualbeli;
import jualbelitanah.View.View_jualbeli;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * Kontroller untuk entitas Jual Beli
 */
public class Controller_jualbeli {

    View_jualbeli frame_jualbeli;
    Implement_jualbeli implement_jualbeli;
    List<Model_jualbeli> jualbeliList;

    public Controller_jualbeli(View_jualbeli frame_jualbeli) {
        this.frame_jualbeli = frame_jualbeli;
        implement_jualbeli = new DAO_jualbeli();
        jualbeliList = implement_jualbeli.getAll(); // Perubahan pada baris ini
    }

    // Tombol Reset
    public void reset() {
        frame_jualbeli.getTxtId().setText("");
        frame_jualbeli.getTxtNamapem().setText("");
        frame_jualbeli.getTxtNamapen().setText("");
        frame_jualbeli.getTxtHarga().setText("");
        frame_jualbeli.getTxtLuas().setText("");
        frame_jualbeli.getTxtCari().setText("");
    }

    // Tampil Data Ke Tabel
    public void isiTable() {
        jualbeliList = implement_jualbeli.getAll(); // Perubahan pada baris ini
        Tabel_jualbeli tmb = new Tabel_jualbeli(jualbeliList);
        frame_jualbeli.getTabelJualTanah().setModel(tmb);
    }

    // Menampilkan Data Ke Form Ketika Data Di Klik
    public void isiField(int row) {
        frame_jualbeli.getTxtId().setText(String.valueOf(jualbeliList.get(row).getId()));
        frame_jualbeli.getTxtNamapem().setText(jualbeliList.get(row).getPembeli());
        frame_jualbeli.getTxtNamapen().setText(jualbeliList.get(row).getPenjual());
        frame_jualbeli.getTxtHarga().setText(jualbeliList.get(row).getHarga());
        frame_jualbeli.getTxtLuas().setText(jualbeliList.get(row).getLuas());
    }

    // Insert Data Dari Form Ke Database
    public void insert() {
        if (!frame_jualbeli.getTxtNamapem().getText().trim().isEmpty()
                && !frame_jualbeli.getTxtNamapen().getText().trim().isEmpty()
                && !frame_jualbeli.getTxtHarga().getText().trim().isEmpty()
                && !frame_jualbeli.getTxtLuas().getText().trim().isEmpty()) {

            Model_jualbeli jualbeli = new Model_jualbeli();
            jualbeli.setPembeli(frame_jualbeli.getTxtNamapem().getText());
            jualbeli.setPenjual(frame_jualbeli.getTxtNamapen().getText());
            jualbeli.setHarga(frame_jualbeli.getTxtHarga().getText());
            jualbeli.setLuas(frame_jualbeli.getTxtLuas().getText());

            implement_jualbeli.insert(jualbeli);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } else {
            JOptionPane.showMessageDialog(frame_jualbeli, "Data tidak boleh kosong");
        }
    }

    // Update Data Dari Tabel Ke Database
    public void update() {
        if (!frame_jualbeli.getTxtNamapem().getText().trim().isEmpty()) {
            Model_jualbeli jualbeli = new Model_jualbeli();
            jualbeli.setId(Integer.parseInt(frame_jualbeli.getTxtId().getText()));
            jualbeli.setPembeli(frame_jualbeli.getTxtNamapem().getText());
            jualbeli.setPenjual(frame_jualbeli.getTxtNamapen().getText());
            jualbeli.setHarga(frame_jualbeli.getTxtHarga().getText());
            jualbeli.setLuas(frame_jualbeli.getTxtLuas().getText());

            implement_jualbeli.update(jualbeli);
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
        } else {
            JOptionPane.showMessageDialog(frame_jualbeli, "Silahkan pilih data yang akan diupdate");
        }
    }

    // Hapus Data Pada Tabel berdasarkan ID
    public void delete() {
        if (!frame_jualbeli.getTxtId().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame_jualbeli.getTxtId().getText());
            implement_jualbeli.delete(id);

            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } else {
            JOptionPane.showMessageDialog(frame_jualbeli, "Silahkan pilih data yang akan dihapus");
        }
    }

    // Cari Data
    public void isiTableCariData() {
        String keyword = frame_jualbeli.getTxtCari().getText();
        jualbeliList = implement_jualbeli.getByKeyword(keyword);
        Tabel_jualbeli tmb = new Tabel_jualbeli(jualbeliList);
        frame_jualbeli.getTabelJualTanah().setModel(tmb);
    }

    public void cariData() {
        if (!frame_jualbeli.getTxtCari().getText().trim().isEmpty()) {
            implement_jualbeli.getByKeyword(frame_jualbeli.getTxtCari().getText());
            isiTableCariData();
        } else {
            JOptionPane.showMessageDialog(frame_jualbeli, "Silahkan masukkan kata kunci pencarian");
        }
    }
}
