package Dao_implementation;

import Models_DB.creneaux;
import DB_connection.DB_connect;
import Dao_interfaces.Dao_interfaces_classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class creneaux_Dao_implementation implements Dao_interfaces_classe<creneaux> {
    private Connection con= DB_connect.getConnection();
    @Override
    public List<creneaux> getAllData() {
        List<creneaux> cre = new ArrayList<creneaux>();
        PreparedStatement ps;
        ResultSet res;
        try{
            ps= con.prepareStatement("select * from creneaux");
            res=ps.executeQuery();
            while (res.next()){
                cre.add(new creneaux(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6),new medcins_Dao_implementation().getData(res.getInt(7))));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cre;
    }

    @Override
    public creneaux getData(int id) {
        creneaux cren=null;
        try {
            PreparedStatement ps=con.prepareStatement("select * from creneaux where id=?");
            ps.setInt(1,id);
            ResultSet res =ps.executeQuery();
            while (res.next()) {
                cren = new creneaux(id,res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6),new medcins_Dao_implementation().getData(res.getInt(7)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cren;
    }

    @Override
    public void addData(creneaux cl) {
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO creneaux VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1,cl.getId());
            ps.setInt(2,cl.getVersion());
            ps.setInt(3,cl.getHedebut());
            ps.setInt(4,cl.getMdebut());
            ps.setInt(5,cl.getHfin());
            ps.setInt(6,cl.getMfin());
            ps.setInt(7,cl.getMed().getId());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void updateData(creneaux cl) {
        try{
            PreparedStatement ps=con.prepareStatement("UPDATE creneaux SET version=?,hedebut=?,mdebut=?,hfin=?,mfin=?,med=? WHERE id=?");
            ps.setInt(7,cl.getId());
            ps.setInt(1,cl.getVersion());
            ps.setInt(2,cl.getHedebut());
            ps.setInt(3,cl.getMdebut());
            ps.setInt(4,cl.getHfin());
            ps.setInt(5,cl.getMfin());
            ps.setInt(6,cl.getMed().getId());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void deleteData(creneaux cl) {
        try{
            PreparedStatement ps=con.prepareStatement("DELETE FROM creneaux WHERE id=?");
            ps.setInt(1,cl.getId());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
