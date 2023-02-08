package Dao_implementation;
import java.sql.*;
import Models_DB.clients;
import DB_connection.DB_connect;
import Dao_interfaces.Dao_interfaces_classe;

import java.util.ArrayList;
import java.util.List;

public class clients_Dao_implementation implements Dao_interfaces_classe<clients> {
    private Connection con= DB_connect.getConnection();
    @Override
    public List<clients> getAllData() {
        List<clients> clients_ = new ArrayList<clients>();
        PreparedStatement ps;
        ResultSet res;
        try{
            ps= con.prepareStatement("select * from clients");
            res=ps.executeQuery();
            while (res.next()){
                clients_.add(new clients(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return clients_;
    }

    @Override
    public clients getData(int id) {
        clients cl=null;
        try {
            PreparedStatement ps=con.prepareStatement("select * from clients where id=? order by id");
            ps.setInt(1,id);
            ResultSet result =ps.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("nom"));
                cl = new clients(id,result.getInt(2),result.getString(3),result.getString(4),result.getString(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cl;
    }

    @Override
    public void addData(clients cl) {
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO clients VALUES (?,?,?,?,?)");
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
    public void updateData(clients cl) {
        try{
            PreparedStatement ps=con.prepareStatement("UPDATE clients SET version=?,titre=?,nom=?,prenom=? WHERE id=?");
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
    public void deleteData(clients cl) {
        try{
            PreparedStatement ps=con.prepareStatement("delete from clients where id=?");
            ps.setInt(1,cl.getVersion());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}