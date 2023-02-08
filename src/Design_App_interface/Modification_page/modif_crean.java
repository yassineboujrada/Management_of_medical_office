package Design_App_interface.Modification_page;


import Dao_implementation.clients_Dao_implementation;
import Dao_implementation.creneaux_Dao_implementation;
import Dao_implementation.medcins_Dao_implementation;
import Dao_implementation.rv_Dao_implementation;
import Models_DB.clients;
import Models_DB.creneaux;
import Models_DB.medcins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class modif_crean extends JFrame implements MouseListener, ActionListener {
    private JTextField nom,prenom,mail,code,H_debut,M_debut;
    private JLabel Lclose;
    private JButton btnCancel;
    private JButton btnConfirm;
    private int id_;



    public modif_crean(int index_col) {
        this.id_ = index_col;
        creneaux_Dao_implementation cr_ = new creneaux_Dao_implementation();

        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        Color BackgroundColor=new Color(224, 236, 222);
        JPanel Login = new JPanel();
        Login.setBorder(null);
        Login.setPreferredSize(new Dimension(580,600));
        Login.setBackground(new Color(205, 224, 201));
        getContentPane().add(Login);
        Login.setLayout(null);

        JLabel lblNewLabel = new JLabel("Modify Creneaux data");
        lblNewLabel.setBounds(0, 21, 585, 70);
        lblNewLabel.setFont(new Font("Anonymous Pro", Font.BOLD, 41));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Login.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(110, 101, 374, 431);
        panel.setBackground(BackgroundColor);
        Login.add(panel);
        panel.setLayout(null);

        JLabel Lusername = new JLabel("VERSION:");
        Lusername.setFont(new Font("Oswald", Font.PLAIN, 13));
        Lusername.setBounds(50, 60, 133, 20);
        panel.add(Lusername);

        nom = new JTextField(cr_.getData(index_col).getVersion()+"");
        nom.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nom.setHorizontalAlignment(SwingConstants.CENTER);
        nom.setBounds(50, 80, 260, 20);
        panel.add(nom);
        nom.setColumns(10);

        JLabel LH_debut = new JLabel("H_debut :");
        LH_debut.setFont(new Font("Oswald", Font.PLAIN, 13));
        LH_debut.setBounds(50, 100, 133, 20);
        panel.add(LH_debut);

        H_debut = new JTextField(cr_.getData(index_col).getHedebut()+"");
        H_debut.setFont(new Font("Tahoma", Font.PLAIN, 13));
        H_debut.setHorizontalAlignment(SwingConstants.CENTER);
        H_debut.setBounds(50, 120, 260, 20);
        panel.add(H_debut);
        H_debut.setColumns(11);

        JLabel LM_debut = new JLabel("M_debut :");
        LM_debut.setFont(new Font("Oswald", Font.PLAIN, 13));
        LM_debut.setBounds(50, 140, 133, 20);
        panel.add(LM_debut);

        M_debut = new JTextField(cr_.getData(index_col).getMdebut()+"");
        M_debut.setFont(new Font("Tahoma", Font.PLAIN, 13));
        M_debut.setHorizontalAlignment(SwingConstants.CENTER);
        M_debut.setBounds(50, 160, 260, 20);
        panel.add(M_debut);
        M_debut.setColumns(10);

        JLabel Lpass = new JLabel("H_Fin:");
        Lpass.setFont(new Font("Oswald", Font.PLAIN, 13));
        Lpass.setBounds(50, 180, 122, 20);
        panel.add(Lpass);

        prenom = new JTextField(cr_.getData(index_col).getHfin()+"");
        prenom.setHorizontalAlignment(SwingConstants.CENTER);
        prenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
        prenom.setBounds(50, 200, 260, 20);
        panel.add(prenom);

        JLabel Lmail = new JLabel("MFin:");
        Lmail.setFont(new Font("Oswald", Font.PLAIN, 13));
        Lmail.setBounds(50, 220, 200, 13);
        panel.add(Lmail);

        mail = new JTextField(cr_.getData(index_col).getMfin()+"");
        mail.setBounds(50, 240, 260, 20);
        mail.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(mail);
        mail.setColumns(10);

        JLabel lRpps = new JLabel("Medecin Id");
        lRpps.setFont(new Font("Oswald", Font.PLAIN, 13));
        lRpps.setBounds(50, 280, 260, 13);
        panel.add(lRpps);

        code = new JTextField(cr_.getData(index_col).getMed().getId()+"");
        code.setBounds(50, 300, 260, 20);
        code.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(code);
        code.setColumns(10);

        JLabel img = new JLabel("");
        img.setIcon(new ImageIcon(Design_App_interface.Login.class.getResource("/Design_App_interface/Icon/dashPatient.png")));
        img.setBounds(525, 116, 400, 400);
        Login.add(img);

        Lclose = new JLabel("New label");
        Lclose.setIcon(new ImageIcon(Design_App_interface.Login.class.getResource("/Design_App_interface/Icon/cancel.png")));
        Lclose.setBounds(950, 10, 40, 40);
        Lclose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Lclose.addMouseListener(this);
        Login.add(Lclose);

        btnCancel = new JButton("Annuler");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCancel.setBounds(42, 381, 130, 40);
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.addActionListener(this);
        panel.add(btnCancel);

        btnConfirm = new JButton("Confirmer");
        btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnConfirm.setBounds(202, 381, 130, 40);
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirm.addActionListener(this);
        panel.add(btnConfirm);

        this.setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1000,600));
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==Lclose) {
            this.dispose();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnConfirm){
            try {
                medcins_Dao_implementation med= new medcins_Dao_implementation();
                creneaux_Dao_implementation cr_ =new creneaux_Dao_implementation();
                medcins id_med = null;
                int version = 0,h_deb = 0,m_deb = 0,h_fin = 0,m_fin = 0;
                id_med = med.getData(Integer.parseInt(code.getText()));
                version = Integer.parseInt(nom.getText());
                h_deb = Integer.parseInt(H_debut.getText());
                m_deb = Integer.parseInt(M_debut.getText());
                h_fin = Integer.parseInt(prenom.getText());
                m_fin = Integer.parseInt(mail.getText());
                cr_.updateData(new creneaux(id_,version,h_deb,m_deb,h_fin,m_fin,id_med));
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "There's an Error");
            }

        } else if (e.getSource()==btnCancel) {
            this.dispose();
        }
    }
}
