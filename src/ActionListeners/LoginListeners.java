package ActionListeners;

import Business.LoginResult;
import Business.LoginBusiness;
import Views.FinestraPrincipale;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListeners implements ActionListener {

    //dichiaro le costanti che userò come etichetta per i pulsanti
    public final static String LOGIN_BTN = "Login_btn";


    //dichiaro il frame che deve ricevere dal chiamante
    private FinestraPrincipale frame;

    public LoginListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    private JTextField username;
    private JPasswordField password;

    public LoginListeners(JTextField username, JPasswordField password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand(); //serve per catturare il tasto premuto

        if (LOGIN_BTN.equals(azione)){
            String user = username.getText();
            String pwd = new String(password.getPassword());

            LoginResult result = LoginBusiness.getInstance().login(user,pwd);
            if (result.getResult() == LoginResult.Result.LOGIN_OK){
                frame.mostraPannelloUtenteLoggato(result.getMessage());
                frame.aggiornaMenuPulsanti();
            }else
                JOptionPane.showMessageDialog(null,result.getMessage());
        }

    }
}
