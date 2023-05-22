package jualbelitanah.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Tabel_jualbeli extends AbstractTableModel {
    
    private List<Model_jualbeli> listJualBeli;
    
    public Tabel_jualbeli(List<Model_jualbeli> listJualBeli){
        this.listJualBeli = listJualBeli;
    }

    @Override
    public int getRowCount() {
        return listJualBeli.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "No";
            case 1:
                return "Pembeli";
            case 2:
                return "Penjual";
            case 3:
                return "Harga";
            case 4:
                return "Luas";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        Model_jualbeli jualBeli = listJualBeli.get(row);
        switch (column){
            case 0:
                return jualBeli.getId();
            case 1:
                return jualBeli.getPembeli();
            case 2:
                return jualBeli.getPenjual();
            case 3:
                return jualBeli.getHarga();
            case 4:
                return jualBeli.getLuas();
            default:
                return null;
        }
    }
    
}
