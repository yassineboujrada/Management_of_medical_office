package Dao_implementation;

import Models_DB.medcins;
import DB_connection.DB_connect;
import Dao_interfaces.Dao_interfaces_classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class medcins_Dao_implementation implements Dao_interfaces_classe<medcins> {
    private Connection con= DB_connect.getConnection();
    @Override
    public List<medcins> getAllData() {
        List<medcins> medcins_ = new ArrayList<medcins>();
        PreparedStatement ps;
        ResultSet res;
        try{
            ps= con.prepareStatement("select * from medecins");
            res=ps.executeQuery();
            while (res.next()){
                medcins_.add(new medcins(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return medcins_;
    }

    @Override
    public medcins getData(int id) {
        medcins med=null;
        try {
            PreparedStatement ps=con.prepareStatement("select * from medecins where id=?");
            ps.setInt(1,id);
            ResultSet result =ps.executeQuery();
            while (result.next()) {
                med = new medcins(id,result.getInt(2),result.getString(3),result.getString(4),result.getString(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return med;
    }

    @Override
    public void addData(medcins cl) {
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO medecins VALUES (?,?,?,?,?)");
            ps.setInt(1,cl.getId());
            ps.setInt(2,cl.getVersion());
            ps.setString(3,cl.getTitre());
            ps.setString(4,cl.getNom());
            ps.setString(5,cl.getPrenom());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void updateData(medcins cl) {
        try{
            PreparedStatement ps=con.prepareStatement("UPDATE medecins SET version=?,titre=?,nom=?,prenom=? WHERE id=?");
            ps.setInt(1,cl.getVersion());
            ps.setString(2,cl.getTitre());
            ps.setString(3,cl.getNom());
            ps.setString(4,cl.getPrenom());
            ps.setInt(5,cl.getId());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void deleteData(medcins cl) {
        try{
            PreparedStatement ps=con.prepareStatement("DELETE FROM medecins WHERE id=?");
            ps.setInt(1,cl.getVersion());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
