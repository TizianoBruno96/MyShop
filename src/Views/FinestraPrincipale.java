package Views;

import ActionListeners.LoginListeners;
import ActionListeners.LogoutListeners;
import ActionListeners.RegistrazioneListeners;
import Business.SessionManager;
import Model.Utenti.Utente;
import Views.Decorator.Menu;
import Views.Decorator.*;

import javax.swing.*;
import java.awt.*;

public class FinestraPrincipale extends JFrame {

    JButton logout = new JButton("Logout");
    private JPanel pannelloNord = new JPanel();
    private JPanel pannelloCentro = new JPanel();
    private JPanel pannelloSud = new JPanel();
    private JPanel pannelloOvest = new JPanel();
    private JPanel utenteLoggato = new JPanel();

    public FinestraPrincipale() {
        super("Finestra MyShop");
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //istanzio gli elementi da inserire nei pannelli


        JLabel etichettaCentro1 = new JLabel("Benvenuto nel sistema di MyShop!");
        Menu guestMenu = new GuestMenu(this);
        JTextField username = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JButton login = new JButton("Login");
        login.setActionCommand(LoginListeners.LOGIN_BTN);
        JButton registrati = new JButton("Registrati");
        registrati.setActionCommand(RegistrazioneListeners.REGISTRATI_BTN);
        RegistrazioneListeners registrazioneListeners = new RegistrazioneListeners(this);
        registrati.addActionListener(registrazioneListeners);


        //setto i layout di ogni singolo pannello
        pannelloNord.setLayout(new FlowLayout());
        pannelloCentro.setLayout(new GridLayout(2, 1));
        pannelloOvest.setLayout(new GridLayout(10, 1));
        pannelloSud.setLayout(new FlowLayout());
        utenteLoggato.setLayout(new FlowLayout());


        //inserisco gli elementi nei pannelli
        pannelloNord.add(username);
        pannelloNord.add(password);
        pannelloNord.add(login);
        pannelloNord.add(registrati);
        pannelloCentro.add(etichettaCentro1);
        pannelloSud.add(new JLabel("Interfaccia grafica per il progetto di PIS"));
        for (JButton btn : guestMenu.getPulsanti()) {
            pannelloOvest.add(btn);
        }


        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(pannelloNord, BorderLayout.NORTH);
        c.add(pannelloCentro, BorderLayout.CENTER);
        c.add(pannelloOvest, BorderLayout.WEST);
        c.add(pannelloSud, BorderLayout.SOUTH);


        //parte dei listeners
        LoginListeners loginListeners = new LoginListeners(username, password);
        loginListeners.setFrame(this);
        login.addActionListener(loginListeners);


        logout.setActionCommand(LogoutListeners.LOGOUT_BTN);
        LogoutListeners logoutListeners = new LogoutListeners(this);
        logout.addActionListener(logoutListeners);
        this.setVisible(true);
    }

    public void mostraPannelloUtenteLoggato(String message) {

        //togliere il pannello precedente
        remove(pannelloNord);

        //aggiungere il pannello successivo
        utenteLoggato.removeAll();
        utenteLoggato.add(new JLabel(message));
        utenteLoggato.add(logout);
        add(utenteLoggato, BorderLayout.NORTH);

        //per il refresh
        repaint();
        validate();
    }


    public void aggiornaMenuPulsanti() {
        pannelloOvest.removeAll();

        Utente u = (Utente) SessionManager.getSession().get(SessionManager.LOGGED_USER);

        if (u.getTipo().equals("CL")) {
            //decoriamo il menu usando il ClienteMenudecorator
            Menu guestMenu = new GuestMenu(this);
            Menu clienteMenu = new ClienteMenuDecorator(guestMenu, this);
            for (JButton btn : clienteMenu.getPulsanti()) {
                pannelloOvest.add(btn);
            }
        } else if (u.getTipo().equals("MN")) {
            Menu guestMenu = new GuestMenu(this);
            Menu managerMenu = new ManagerMenuDecorator(guestMenu, this);
            for (JButton btn : managerMenu.getPulsanti()) {
                pannelloOvest.add(btn);
            }
        } else if (u.getTipo().equals("AM")) {
            Menu guestMenu = new GuestMenu(this);
            Menu amministratoreMenu = new AmministratoreMenuDecorator(guestMenu, this);
            for (JButton btn : amministratoreMenu.getPulsanti()) {
                pannelloOvest.add(btn);
            }
        }

        repaint();
        validate();
    }

    public void mostraCatalogoProdotti() {
        pannelloCentro.removeAll();
        pannelloCentro.add(new CatalogoProdottiPanel());
        repaint();
        validate();
    }

    public void mostraPannelloRegistrazione() {
        pannelloCentro.removeAll();
        pannelloCentro.add(new RegistrazionePanel());
        repaint();
        validate();
    }


    public void effettuaLogout() {
        this.setVisible(false);
        new FinestraPrincipale();
        repaint();
        validate();
    }

    public void mostraCatalogoServizi() {
        pannelloCentro.removeAll();
        pannelloCentro.add(new CatalogoServiziPanel());
        repaint();
        validate();
    }

    public void mostraPannelloCreazioneManager() {
        pannelloCentro.removeAll();
        pannelloCentro.add(new CreaManagerPanel());
        repaint();
        validate();
    }

    public void mostraPannelloCreazionePuntoVendita() {
        pannelloCentro.removeAll();
        pannelloCentro.add(new CreaPuntoVenditaPanel());
        repaint();
        validate();
    }

    public void mostraPannelloInserimentoProdotto() {
        pannelloCentro.removeAll();
        pannelloCentro.add(new InserisciProdottoPanel());
        repaint();
        validate();
    }

    public void mostraPannelloInserimentoProduttore() {
        pannelloCentro.removeAll();
        pannelloCentro.add(new InserisciProduttorePanel());
        repaint();
        validate();
    }
}