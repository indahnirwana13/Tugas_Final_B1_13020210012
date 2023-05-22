package jualbelitanah.DAO;

import jualbelitanah.DAOImplement.Implement_jualbeli;
import jualbelitanah.Koneksi.Koneksi_jualbeliDB;
import jualbelitanah.Model.Model_jualbeli;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_jualbeli implements Implement_jualbeli {
    
    Connection connection;
    final String insert = "INSERT INTO tbljualtanah (pembeli, penjual, harga, luas) VALUES (?, ?, ?, ?)";
    final String update = "UPDATE tbljualtanah SET pembeli = ?, penjual = ?, harga = ?, luas = ? WHERE id = ?";
    final String delete = "DELETE FROM tbljualtanah WHERE id = ?";
    final String select = "SELECT * FROM tbljualtanah";
    final String getByPembeli = "SELECT * FROM tbljualtanah WHERE pembeli LIKE ?";
    
    public DAO_jualbeli(){
        connection = Koneksi_jualbeliDB.connection();
    }
    
    @Override
    public void insert(Model_jualbeli jualBeli){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setString(1, jualBeli.getPembeli());
            statement.setString(2, jualBeli.getPenjual());
            statement.setString(3, jualBeli.getHarga());
            statement.setString(4, jualBeli.getLuas());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(Model_jualbeli jualBeli) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, jualBeli.getPembeli());
            statement.setString(2, jualBeli.getPenjual());
            statement.setString(3, jualBeli.getHarga());
            statement.setString(4, jualBeli.getLuas());
            statement.setInt(5, jualBeli.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(int id){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public List<Model_jualbeli> getAll(){
        List<Model_jualbeli> jualBeliList = new ArrayList<>();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                Model_jualbeli jualBeli = new Model_jualbeli();
                jualBeli.setId(rs.getInt("id"));
                jualBeli.setPembeli(rs.getString("pembeli"));
                jualBeli.setPenjual(rs.getString("penjual"));
                jualBeli.setHarga(rs.getString("harga"));
                jualBeli.setLuas(rs.getString("luas"));
                jualBeliList.add(jualBeli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_jualbeli.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return jualBeliList;
    }
    
    @Override
    public List<Model_jualbeli> getByKeyword(String keyword) {
    List<Model_jualbeli> jualBeliList = new ArrayList<>();
    try {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM tbljualtanah WHERE pembeli LIKE ? OR penjual LIKE ? OR harga LIKE ? OR luas LIKE ?");
        st.setString(1, "%" + keyword + "%");
        st.setString(2, "%" + keyword + "%");
        st.setString(3, "%" + keyword + "%");
         st.setString(4, "%" + keyword + "%");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Model_jualbeli jualBeli = new Model_jualbeli();
            jualBeli.setId(rs.getInt("id"));
            jualBeli.setPembeli(rs.getString("pembeli"));
            jualBeli.setPenjual(rs.getString("penjual"));
            jualBeli.setHarga(rs.getString("harga"));
            jualBeli.setLuas(rs.getString("luas"));
            jualBeliList.add(jualBeli);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_jualbeli.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return jualBeliList;
    }
}
