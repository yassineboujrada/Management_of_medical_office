package Design_App_interface.Add_pages;

import Dao_implementation.*;
import Design_App_interface.Login;
import Models_DB.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Add_New extends JFrame implements MouseListener,ActionListener {
    private JTextField nom,prenom,mail,code;
    private JLabel Lclose;
    private JButton btnCancel;
    private JButton btnConfirm;

    private String s;


    public Add_New(String s) {
        this.s=s;

        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        Color BackgroundColor=new Color(224, 236, 222);
        JPanel Login = new JPanel();
        Login.setBorder(null);
        Login.setPreferredSize(new Dimension(580,600));
        Login.setBackground(new Color(205, 224, 201));
        getContentPane().add(Login);
        Login.setLayout(null);
        String title = "Add New "+s;
        JLabel lblNewLabel = new JLabel(title);
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
        Lusername.setFont(new Font("Oswald", Font.PLAIN, 17));
        Lusername.setBounds(50, 10, 133, 40);
        panel.add(Lusername);

        nom = new JTextField();
        nom.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nom.setHorizontalAlignment(SwingConstants.CENTER);
        nom.setBounds(50, 49, 260, 40);
        panel.add(nom);
        nom.setColumns(10);

        JLabel Lpass = new JLabel("Titre:");
        Lpass.setFont(new Font("Oswald", Font.PLAIN, 17));
        Lpass.setBounds(50, 87, 122, 43);
        panel.add(Lpass);

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

        prenom = new JTextField();
        prenom.setHorizontalAlignment(SwingConstants.CENTER);
        prenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
        prenom.setBounds(50, 127, 260, 40);
        panel.add(prenom);

        JLabel Lmail = new JLabel("Nom:");
        Lmail.setFont(new Font("Oswald", Font.PLAIN, 17));
        Lmail.setBounds(50, 177, 200, 21);
        panel.add(Lmail);

        mail = new JTextField();
        mail.setBounds(50, 208, 260, 40);
        mail.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(mail);
        mail.setColumns(10);

        JLabel lRpps = new JLabel("Prenom");
        lRpps.setFont(new Font("Oswald", Font.PLAIN, 17));
        lRpps.setBounds(50, 254, 260, 23);
        panel.add(lRpps);

        code = new JTextField();
        code.setBounds(50, 280, 260, 40);
        code.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(code);
        code.setColumns(10);

        JLabel img = new JLabel("");
        img.setIcon(new ImageIcon(Design_App_interface.Login.class.getResource("/Design_App_interface/Icon/dashPatient.png")));
        img.setBounds(525, 116, 400, 400);
        Login.add(img);

        Lclose = new JLabel("New label");
        Lclose.setIcon(new ImageIcon(Login.class.getResource("/Design_App_interface/Icon/cancel.png")));
        Lclose.setBounds(950, 10, 40, 40);
        Lclose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Lclose.addMouseListener(this);
        Login.add(Lclose);

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
                if (s.equals("medcin")){
                    try{
                        medcins_Dao_implementation cl = new medcins_Dao_implementation();
                        cl.addData(new medcins(cl.getAllData().size()+1,Integer.parseInt(nom.getText()),prenom.getText(),mail.getText(),code.getText()));
                        this.dispose();
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "There's an Error");
                    }
                } else if (s.equals("client")) {
                    try{
                        clients_Dao_implementation cl = new clients_Dao_implementation();
                        cl.addData(new clients(cl.getAllData().size()+1,Integer.parseInt(nom.getText()),prenom.getText(),mail.getText(),code.getText()));
                        this.dispose();
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "There's an Error");
                    }
                }


        } else if (e.getSource()==btnCancel) {
            this.dispose();
        }
    }
}
