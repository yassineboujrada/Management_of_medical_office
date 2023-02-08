package Design_App_interface;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame implements ActionListener{
    private JTextField Lname;
    private JPasswordField Pass;
    private JLabel Lclose;
    private JButton btnLogin,btnRegister;

    public Login() {
        setLayout(new GridLayout(0, 1, 0, 0));
        Color BackgroundColor=new Color(224, 236, 222);
        JPanel Login = new JPanel();
        Login.setBorder(null);
        Login.setPreferredSize(new Dimension(580,600));
        Login.setBackground(new Color(205, 224, 201));
        getContentPane().add(Login);
        Login.setLayout(null);

        JLabel lblNewLabel = new JLabel("\n Welcome \n");
        lblNewLabel.setBounds(0, 21, 585, 70);
        lblNewLabel.setFont(new Font("Anonymous Pro", Font.BOLD, 41));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Login.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(110, 101, 374, 431);
        panel.setBackground(BackgroundColor);
        Login.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("UserName :");
        lblNewLabel_1.setFont(new Font("Oswald", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(62, 48, 133, 40);
        panel.add(lblNewLabel_1);

        Lname = new JTextField();
        Lname.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Lname.setHorizontalAlignment(SwingConstants.CENTER);
        Lname.setBounds(50, 90, 260, 40);
        panel.add(Lname);
        Lname.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Password :");
        lblNewLabel_2.setFont(new Font("Oswald", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(62, 151, 122, 43);
        panel.add(lblNewLabel_2);

        btnLogin = new JButton("Login In");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnLogin.setBounds(29, 269, 130, 40);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnLogin);

        btnLogin.addActionListener(this);

        btnRegister = new JButton("Cr\u00E9er Compte");
        btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnRegister.setBounds(201, 269, 130, 40);
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnRegister);

        btnRegister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn=(JButton)e.getSource();
                if(btn==btnRegister) {
                    System.out.println("Registre");
                }
                if(btn==btnLogin) {
                    //controle de saisie et redirection a la page d'accueil si vraie
                    String login = Lname.getText();
                    String password = Pass.getText();
                    if((login.length() == 0)||(password.length() == 0)) {
                        JOptionPane.showMessageDialog(null, "Remplir Tous les Chapms SVP");
                    }else {
                        System.out.println("hi----------");
                    }
                }

            }
        });
        Pass = new JPasswordField();
        Pass.setHorizontalAlignment(SwingConstants.CENTER);
        Pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Pass.setBounds(50, 190, 260, 40);
        panel.add(Pass);

        JLabel img = new JLabel("");
        img.setIcon(new ImageIcon(Login.class.getResource("/Design_App_interface/Icon/login.png")));
        img.setBounds(525, 116, 400, 400);
        Login.add(img);

        Lclose = new JLabel("New label");
        Lclose.setIcon(new ImageIcon(Login.class.getResource("/Design_App_interface/Icon/cancel.png")));
        Lclose.setBounds(950, 10, 40, 40);
        Lclose.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Lclose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==Lclose) {
                    System.exit(0);
                }
            }
        });

        Login.add(Lclose);

        this.setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1000,600));
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn=(JButton)e.getSource();
        if(btn==btnRegister) {
            System.out.println("Registre");
        }
        if(btn==btnLogin) {
            String login = Lname.getText();
            String password = Pass.getText();
            if((login.length() == 0)||(password.length() == 0)) {
                JOptionPane.showMessageDialog(null, "Remplir Tous les Chapms SVP");
            }else {
                System.out.println("hi----------");
                this.dispose();
                new medcinInterface();
            }
        }

    }
}



