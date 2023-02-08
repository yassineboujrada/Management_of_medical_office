package Dao_implementation;

import Models_DB.rv;
import DB_connection.DB_connect;
import Dao_interfaces.Dao_interfaces_classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rv_Dao_implementation implements Dao_interfaces_classe<rv> {
    private Connection con= DB_connect.getConnection();
    @Override
    public List<rv> getAllData() {
        List<rv> rv_ = new ArrayList<rv>();
        PreparedStatement ps;
        ResultSet res;
        try{
            ps= con.prepareStatement("select * from rv");
            res=ps.executeQuery();
            while (res.next()){
                rv_.add(new rv(res.getInt(1),res.getDate(2),new clients_Dao_implementation().getData(res.getInt(3)),new creneaux_Dao_implementation().getData(res.getInt(4))));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rv_;
    }

    @Override
    public rv getData(int id) {
        rv rv_=null;
        try {
            PreparedStatement ps=con.prepareStatement("select * from rv where id=?");
            ps.setInt(1,id);
            ResultSet res =ps.executeQuery();
            while (res.next()) {
                rv_ = new rv(id,res.getDate(2),new clients_Dao_implementation().getData(res.getInt(3)),new creneaux_Dao_implementation().getData(res.getInt(4)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rv_;
    }

    @Override
    public void addData(rv cl) {
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO rv VALUES (?,to_date(?,'dd-mm-yyyy'),?,?)");
            ps.setInt(1,cl.getId());
            ps.setDate(2,cl.getJour());
            ps.setInt(3,cl.getClient().getId());
            ps.setInt(4,cl.getCreneau().getId());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void updateData(rv cl) {
        try{
            PreparedStatement ps=con.prepareStatement("UPDATE rv SET jour=?,client=?,crenaux=? WHERE id=?");
            ps.setInt(4,cl.getId());
            ps.setDate(1,cl.getJour());
            ps.setInt(2,cl.getClient().getId());
            ps.setInt(3,cl.getCreneau().getId());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void deleteData(rv cl) {
        try{
            PreparedStatement ps=con.prepareStatement("DELETE FROM rv WHERE id=?");
            ps.setInt(1,cl.getId());
            ps.executeUpdate();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
