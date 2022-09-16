package Business;

import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import DAO.Interfaces.IUtenteRegistratoDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteDAO;
import DAO.UtenteRegistratoDAO;
import Model.PuntoVendita;
import Model.Utenti.Utente;
import Model.Utenti.UtenteRegistrato;
import Views.AccessoUtente;

public class LoginBusiness {
    private static LoginBusiness instance;
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    IUtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();

    public static synchronized LoginBusiness getInstance() {
        if (instance == null) {
            instance = new LoginBusiness();
        }
        return instance;
    }

    //creo una classe LoginResult che mi indica lo stato del login
    public LoginResult login(String username, String password, String nomePuntoVendita) {
        LoginResult result = new LoginResult();

        //controllo l'username
        if (!utenteDAO.checkUsername(username)) {
            result.setResult(LoginResult.Result.USER_DOESNT_EXIST);
            result.setMessage("L'username inserito non esiste");
            return result;
        }

        //controllo la password
        if (!utenteDAO.checkUtente(username, password)) {
            result.setResult(LoginResult.Result.WRONG_PASSWORD);
            result.setMessage("La password inserita non è corretta");
            return result;
        }

        //Controllo sull'utente e la sua registrazione sul punto vendita
        Utente u = utenteDAO.findByUsername(username);

        PuntoVendita pv = null;
        //controllo che il nome del punto vendita sia valido
        if (!u.getTipo().equals("AM")) {
            if (!puntoVenditaDAO.checkNome(nomePuntoVendita)) {
                result.setResult(LoginResult.Result.WRONG_PUNTO_VENDITA);
                result.setMessage("Nome punto vendita non valido");
                return result;
            }
        }

        pv = puntoVenditaDAO.findByNome(nomePuntoVendita);
        AccessoUtente.setIdPuntoVendita(pv.getIdPuntoVendita());
        AccessoUtente.setIdUtente(u.getIdUtente());
        AccessoUtente.setTipo(u.getTipo());

        //se l'utente non è registrato a questo punto vendita ritorna messaggio d'errore
        if (!checkRegistrazione(u.getTipo(), pv, u.getIdUtente())) {
            result.setResult(LoginResult.Result.UTENTE_NON_REGISTRATO_AL_PUNTOVENDITA);
            result.setMessage("L'utente non è registrato al punto vendita");
        }

        //se tutto è ok ritorna messaggio di successo ed effettua il login
        SessionManager.getSession().put(SessionManager.LOGGED_USER, u);
        result.setMessage("Benvenuto " + u.getNome() + " " + u.getCognome());
        result.setResult(LoginResult.Result.LOGIN_OK);
        return result;
    }

    private boolean checkRegistrazione(String tipo, PuntoVendita pv, int idUtente) {
        boolean flag = true;
        if (tipo.equals("AM") && pv != null) {
            for (UtenteRegistrato ur : utenteRegistratoDAO.findByPuntoVendita(pv.getIdPuntoVendita())) {
                if (ur.getIdUtente() == idUtente) {
                    flag = true;
                    break;
                } else flag = false;
            }
        }
        return flag;
    }
}