package Design_App_interface;


import Dao_implementation.*;
import Design_App_interface.Add_pages.Add_New;
import Design_App_interface.Add_pages.Add_crean;
import Design_App_interface.Add_pages.Add_new_rv;
import Design_App_interface.Modification_page.*;
import Models_DB.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class medcinInterface extends JFrame implements MouseListener {
    private JLabel Lclose, Medcins, Reservation, corenaux, client;
    private JPanel Login,action_to_DO;
    private int index_page=0;
    private JTable j;
    
    public medcinInterface() {
        setLayout(new FlowLayout());
        Color BackgroundColor = new Color(225, 236, 222);
        JPanel main_panel = new JPanel();
        Login = new JPanel();
        action_to_DO = new JPanel();

        Login.setBorder(null);
        Login.setPreferredSize(new Dimension(1000, 100));

        action_to_DO.setBorder(null);
        action_to_DO.setPreferredSize(new Dimension(1000, 500));

        getContentPane().add(Login,BorderLayout.PAGE_START);
        Login.setLayout(null);
        getContentPane().add(action_to_DO);

        Medcins = new JLabel("Medcins");
        Medcins.setBounds(50, 10, 100, 40);
        Medcins.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Medcins.addMouseListener(this);
        Login.add(Medcins);

        client = new JLabel("Clients");
        client.setBounds(150, 10, 100, 40);
        client.setCursor(new Cursor(Cursor.HAND_CURSOR));
        client.addMouseListener(this);
        Login.add(client);

        Reservation = new JLabel("Reservation");
        Reservation.setBounds(250, 10, 100, 40);
        Reservation.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Reservation.addMouseListener(this);
        Login.add(Reservation);

        corenaux = new JLabel("Creneaux");
        corenaux.setBounds(370, 10, 100, 40);
        corenaux.setCursor(new Cursor(Cursor.HAND_CURSOR));
        corenaux.addMouseListener(this);
        Login.add(corenaux);

        Lclose = new JLabel("Close label");
        Lclose.setIcon(new ImageIcon(Login.class.getResource("/Design_App_interface/Icon/cancel.png")));
        Lclose.setBounds(950, 10, 40, 40);
        Lclose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Lclose.addMouseListener(this);
        Login.add(Lclose);

        JLabel add_new = new JLabel("");
        add_new.setIcon(new ImageIcon(Login.class.getResource("/Design_App_interface/Icon/add2.png")));
        add_new.setBounds(680, 55, 40, 40);
        add_new.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add_new.addMouseListener(this);
        Login.add(add_new);
        add_new.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                switch (index_page){
                    case 1:
                        new Add_New("medcin");
                        break;
                    case 2:
                        new Add_new_rv();
                        break;
                    case 3:
                        new Add_crean();
                        break;
                    case 4:
                        new Add_New("client");
                        break;
                    default:
                        System.out.println("nothing");
                        break;
                }
            }

        });

        JLabel remove_ele = new JLabel("");
        remove_ele.setIcon(new ImageIcon(Login.class.getResource("/Design_App_interface/Icon/remove.png")));
        remove_ele.setBounds(740, 50, 50, 50);
        remove_ele.setCursor(new Cursor(Cursor.HAND_CURSOR));
        remove_ele.addMouseListener(this);
        Login.add(remove_ele);
        remove_ele.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int id_data_ele;
                id_data_ele = Integer.parseInt(j.getModel().getValueAt(j.getSelectedRow(), 0).toString());
                switch (index_page){
                    case 1:
                        medcins_Dao_implementation med = new medcins_Dao_implementation();
                        med.deleteData(med.getData(id_data_ele));
                        break;
                    case 2:
                        rv_Dao_implementation rv_ = new rv_Dao_implementation();
                        rv_.deleteData(rv_.getData(id_data_ele));
                        break;
                    case 3:
                        creneaux_Dao_implementation cr_ = new creneaux_Dao_implementation();
                        cr_.deleteData(cr_.getData(id_data_ele));
                        break;
                    case 4:
                        clients_Dao_implementation cl = new clients_Dao_implementation();
                        System.out.println(cl.getData(id_data_ele));
                        cl.deleteData(cl.getData(id_data_ele));
                        break;
                    default:
                        System.out.println("nothing");
                        break;
                }

            }

        });

        JLabel update_ele = new JLabel("");
        update_ele.setIcon(new ImageIcon(Login.class.getResource("/Design_App_interface/Icon/dossier.png")));
        update_ele.setBounds(800, 50, 50, 50);
        update_ele.setCursor(new Cursor(Cursor.HAND_CURSOR));
        update_ele.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int id_data_ele;
                id_data_ele = Integer.parseInt(j.getModel().getValueAt(j.getSelectedRow(), 0).toString());
                System.out.println("id"+id_data_ele);
                switch (index_page){
                    case 1:
                        new modif_New("medcin",id_data_ele);
                        break;
                    case 2:
                        new modif_new_rv(id_data_ele);
                        break;
                    case 3:
                        new modif_crean(id_data_ele);
                        break;
                    case 4:
                        new modif_New("client",id_data_ele);
                        break;
                    default:
                        System.out.println("nothing");
                        break;
                }

            }

        });
        Login.add(update_ele);
        this.setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1000, 600));
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void mousePressed(MouseEvent evt){
    };

    public void mouseReleased (MouseEvent evt){
    };
    @Override
    public void mouseClicked (MouseEvent evt){
        if (evt.getSource() == Lclose) {
            System.exit(0);
        } else {
            if (evt.getSource() == Medcins) {
                index_page=1;
                action_to_DO.removeAll();
                medcins_Dao_implementation cl = new medcins_Dao_implementation();
                List<medcins> info_nedded = cl.getAllData();
                String[][] data = new String[info_nedded.size()][];
                for (int i = 0; i < info_nedded.size(); i++) {
                    data[i]=new String[]{
                            Integer.toString(info_nedded.get(i).getId()),
                            Integer.toString(info_nedded.get(i).getVersion()),
                            info_nedded.get(i).getTitre(),
                            info_nedded.get(i).getNom(),
                            info_nedded.get(i).getPrenom()
                    };
                }

                String[] columnNames = { "ID", "VERSION", "TITLE","NOM","PRENOM" };
                j = new JTable(data, columnNames);
                j.setBounds(60, 150, 880, 400);
                j.setModel(new MyTableModel(data, columnNames));

                JScrollPane sp = new JScrollPane(j);
                action_to_DO.setLayout(new BorderLayout());
                action_to_DO.add(sp);
                repaint();
                revalidate();

            } else {
                if (evt.getSource() == Reservation) {
                    index_page=2;
                    action_to_DO.removeAll();
                    rv_Dao_implementation cl = new rv_Dao_implementation();
                    List<rv> info_nedded = cl.getAllData();
                    String[][] data = new String[info_nedded.size()][];
                    for (int i = 0; i < info_nedded.size(); i++) {
                        data[i]=new String[]{
                                Integer.toString(info_nedded.get(i).getId()),
                                info_nedded.get(i).getJour().toString(),
                                info_nedded.get(i).getClient().getNom()+" "+info_nedded.get(i).getClient().getPrenom(),
                                Integer.toString(info_nedded.get(i).getCreneau().getId())
                        };
                    }

                    String[] columnNames = { "ID", "DATE", "CLIENT NAME","SLOTS NUM"};
                    j = new JTable(data, columnNames);
                    j.setBounds(60, 150, 880, 400);
                    j.setModel(new MyTableModel(data, columnNames));

                    JScrollPane sp = new JScrollPane(j);
                    action_to_DO.setLayout(new BorderLayout());
                    action_to_DO.add(sp);
                    repaint();
                    revalidate();
                } else {
                    if (evt.getSource() == corenaux) {
                        index_page=3;
                        action_to_DO.removeAll();
                        creneaux_Dao_implementation cl = new creneaux_Dao_implementation();
                        List<creneaux> info_nedded = cl.getAllData();
                        String[][] data = new String[info_nedded.size()][];
                        for (int i = 0; i < info_nedded.size(); i++) {
                            data[i]=new String[]{
                                    Integer.toString(info_nedded.get(i).getId()),
                                    Integer.toString(info_nedded.get(i).getVersion()),
                                    Integer.toString(info_nedded.get(i).getMdebut()),
                                    Integer.toString(info_nedded.get(i).getMfin()),
                                    Integer.toString(info_nedded.get(i).getHedebut()),
                                    Integer.toString(info_nedded.get(i).getHfin()),
                                    info_nedded.get(i).getMed().getNom()+" "+info_nedded.get(i).getMed().getPrenom()
                            };
                        }

                        String[] columnNames = { "ID", "VERSION", "M_DEBUTE","M_FIN","H_DEBUTE","H_FIN","DOCTOR NAME" };
                        j = new JTable(data, columnNames);
                        j.setBounds(60, 150, 880, 400);
                        j.setModel(new MyTableModel(data, columnNames));

                        JScrollPane sp = new JScrollPane(j);
                        action_to_DO.setLayout(new BorderLayout());
                        action_to_DO.add(sp);
                        repaint();
                        revalidate();
                    } else {
                        if (evt.getSource() == client) {
                            index_page=4;
                            action_to_DO.removeAll();
                            clients_Dao_implementation cl = new clients_Dao_implementation();
                            List<clients> info_nedded = cl.getAllData();
                            String[][] data = new String[info_nedded.size()][];
                            for (int i = 0; i < info_nedded.size(); i++) {
                                data[i]=new String[]{
                                        Integer.toString(info_nedded.get(i).getId()),
                                        Integer.toString(info_nedded.get(i).getVersion()),
                                        info_nedded.get(i).getTitre(),
                                        info_nedded.get(i).getNom(),
                                        info_nedded.get(i).getPrenom()
                                };
                            }

                            String[] columnNames = { "ID", "VERSION", "TITLE","NOM","PRENOM" };
                            j = new JTable(data, columnNames);
                            j.setBounds(60, 150, 880, 400);
                            j.setModel(new MyTableModel(data, columnNames));

                            JScrollPane sp = new JScrollPane(j);
                            action_to_DO.setLayout(new BorderLayout());
                            action_to_DO.add(sp);
                            repaint();
                            revalidate();
                        }
                    }
                }
            }
        }
    };


    public void mouseEntered (MouseEvent evt){
    };
    public void mouseExited (MouseEvent evt){
    };

    public class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[][] tableData, Object[] colNames) {
            super(tableData, colNames);
        }

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
}



