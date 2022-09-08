package Views;

import ActionListeners.LoginListeners;

import javax.swing.*;
import java.awt.*;

public class FinestraPrincipale extends JFrame {

    private JPanel pannelloNord = new JPanel();
    private JPanel pannelloCentro = new JPanel();
    private JPanel pannelloSud = new JPanel();
    private JPanel pannelloOvest = new JPanel();
    private JPanel pannelloEst = new JPanel();
    private JPanel pannelloLoginNord = new JPanel();
    private JPanel pannelloLoginCentro = new JPanel();



    public FinestraPrincipale() {
        super("Finestra MyShop");
        this.setSize(1000,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //istanzio gli elementi da inserire nei pannelli
        JButton login = new JButton("Login");
        login.setActionCommand(LoginListeners.LOGIN_BTN);//associo un'etichetta al pulsante
        JButton navigaCatalogo = new JButton("Naviga catalogo");
        JLabel etichettaNord = new JLabel(" MY SHOP");
        JLabel etichettaCentro1 = new JLabel("Benvenuto nel sistema di MyShop!\n");
        JLabel etichettaCentro2 = new JLabel("In questa schermata puoi decidere se effettuare il login oppure navigare nel catalogo.");


        //setto i layout di ogni singolo pannello
        pannelloNord.setLayout(new FlowLayout());
        pannelloCentro.setLayout(new FlowLayout());
        pannelloOvest.setLayout(new GridLayout(10,1));
        pannelloEst.setLayout(new FlowLayout());


        //inserisco gli elementi nei pannelli
        pannelloNord.add(etichettaNord);
        pannelloCentro.add(etichettaCentro1);
        pannelloCentro.add(etichettaCentro2);
        pannelloOvest.add(login);
        pannelloOvest.add(navigaCatalogo);
        pannelloEst.add(new JLabel("         "));
        pannelloSud.add(new JLabel("Interfaccia grafica per il progetto di PIS"));


        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(pannelloNord,BorderLayout.NORTH);
        c.add(pannelloCentro,BorderLayout.CENTER);
        c.add(pannelloOvest,BorderLayout.WEST);
        c.add(pannelloEst,BorderLayout.EAST);
        c.add(pannelloSud,BorderLayout.SOUTH);

        //lavoro sui pannelli di login
        JTextField username = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JButton effettualogin = new JButton("Login");
        pannelloLoginNord.setLayout(new GridLayout(1,3));
        pannelloLoginCentro.setLayout(new FlowLayout());
        pannelloLoginNord.add(username);
        pannelloLoginNord.add(password);
        pannelloLoginNord.add(effettualogin);
        pannelloLoginCentro.add(new JLabel("Inserire username e password , successivamente premere il pulsante di login per confermare"));

        //parte dei listeners
        LoginListeners loginListeners = new LoginListeners(this);
        loginListeners.setFrame(this);
        login.addActionListener(loginListeners);
        this.setVisible(true);
    }


    public void mostraPannelloLogin(){
        //rimuovo i pannelli precedenti
        remove(pannelloNord);
        remove(pannelloCentro);

        //aggiungo i pannelli di login
        add(pannelloLoginNord,BorderLayout.NORTH);
        add(pannelloLoginCentro,BorderLayout.CENTER);

        //faccio il refresh
        repaint();
        validate();
    }

    public void mostraCatalogo(){
        pannelloNord.removeAll();
        pannelloCentro.removeAll();
        pannelloCentro.add(new CatalogoPanel());
        repaint();
        validate();
    }

    public void mostraMessaggioBenvenuto(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}