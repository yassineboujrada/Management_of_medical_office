package Design_App_interface.Add_pages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
//import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Design_App_interface.Login;
import org.jdatepicker.*;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;

import Dao_implementation.clients_Dao_implementation;
import Dao_implementation.creneaux_Dao_implementation;
import Dao_implementation.rv_Dao_implementation;
import Models_DB.clients;
import Models_DB.creneaux;
import Models_DB.rv;

public class Add_new_rv extends JFrame implements MouseListener, ActionListener {
    private JTextField nom,prenom,mail,code;
    private JLabel Lclose;
    private JButton btnCancel;
    private JButton btnConfirm;
    private JDatePickerImpl datePicker;

    public Add_new_rv(){
        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        Color BackgroundColor=new Color(224, 236, 222);
        JPanel Login = new JPanel();
        Login.setBorder(null);
        Login.setPreferredSize(new Dimension(580,600));
        Login.setBackground(new Color(205, 224, 201));
        getContentPane().add(Login);
        Login.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add New Reservation");
        lblNewLabel.setBounds(0, 21, 585, 70);
        lblNewLabel.setFont(new Font("Anonymous Pro", Font.BOLD, 41));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Login.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(110, 101, 374, 431);
        panel.setBackground(BackgroundColor);
        Login.add(panel);
        panel.setLayout(null);

        JLabel Lusername = new JLabel("Date :");
        Lusername.setFont(new Font("Oswald", Font.PLAIN, 17));
        Lusername.setBounds(50, 10, 133, 40);
        panel.add(Lusername);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(50, 49, 260, 40);
        panel.add(datePicker);

        JLabel Lpass = new JLabel("Client Id:");
        Lpass.setFont(new Font("Oswald", Font.PLAIN, 17));
        Lpass.setBounds(50, 87, 122, 43);
        panel.add(Lpass);

        prenom = new JTextField();
        prenom.setHorizontalAlignment(SwingConstants.CENTER);
        prenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
        prenom.setBounds(50, 127, 260, 40);
        prenom.setColumns(20);
        panel.add(prenom);

        JLabel Lmail = new JLabel("Creneaux Id:");
        Lmail.setFont(new Font("Oswald", Font.PLAIN, 17));
        Lmail.setBounds(50, 177, 200, 21);
        panel.add(Lmail);

        mail = new JTextField();
        mail.setBounds(50, 208, 260, 40);
        mail.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(mail);
        mail.setColumns(20);

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

    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }

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
        if (e.getSource()==btnConfirm) {
            rv_Dao_implementation rv_ = new rv_Dao_implementation();
            clients_Dao_implementation cl = new clients_Dao_implementation();
            creneaux_Dao_implementation cr_= new creneaux_Dao_implementation();
            clients id_clint = null;
            creneaux id_cre = null;
            try {
                id_clint = cl.getData(Integer.parseInt(prenom.getText()));
                id_cre = cr_.getData(Integer.parseInt(mail.getText()));
                java.util.Date date = Date.valueOf(LocalDate.of(datePicker.getModel().getYear(),datePicker.getModel().getMonth(),datePicker.getModel().getDay()));
                System.out.println(date);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                rv_.addData(new rv(rv_.getAllData().size() + 1, sqlDate, id_clint, id_cre));
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "There's an Error");
            }
        } else if (e.getSource()==btnCancel) {
            this.dispose();
        }
    }
}
