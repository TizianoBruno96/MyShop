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
    //utilizzo il singleton
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
    public LoginResult login(String username, String password,String nomePuntoVendita) {

        LoginResult result = new LoginResult();

        //controllare se l'utente esiste
        if (!utenteDAO.checkUsername(username)) {
            result.setResult(LoginResult.Result.USER_DOESNT_EXIST);
            result.setMessage("L'username inserito non esiste");
            return result;
        }

        //controllo se la password è valida
        if (!utenteDAO.checkUtente(username, password)) {
            result.setResult(LoginResult.Result.WRONG_PASSWORD);
            result.setMessage("La password inserita non è corretta");
            return result;
        }


        //controllo il tipo di utente
        Utente u = utenteDAO.findByUsername(username);
        PuntoVendita pv = null;
        if (!nomePuntoVendita.equals("")) {
            pv = puntoVenditaDAO.findByNome(nomePuntoVendita);
            AccessoUtente.setIdPuntoVendita(pv.getIdPuntoVendita());
        }
        AccessoUtente.setIdUtente(u.getIdUtente());
        AccessoUtente.setTipo(u.getTipo());
        boolean flag = true;

        if (!u.getTipo().equals("AM")) {
            //controllo che il nome del punto vendita sia valido
            if (!puntoVenditaDAO.checkNome(nomePuntoVendita)) {
                result.setResult(LoginResult.Result.WRONG_PUNTO_VENDITA);
                result.setMessage("Nome punto vendita non valido");
                return result;
            }
        }


        if (!u.getTipo().equals("AM") && flag && pv!=null){

            for (UtenteRegistrato ur : utenteRegistratoDAO.findByPuntoVendita(pv.getIdPuntoVendita())){
                if (ur.getIdUtente() == u.getIdUtente()) {
                    flag = true;
                    break;
                } else flag = false;
            }

        }

        //se l'utente non è registrato a questo punto vendita ritorna messaggio d'errore
        if (!flag){
            result.setResult(LoginResult.Result.UTENTE_NON_REGISTRATO_AL_PUNTOVENDITA);
            result.setMessage("L'utente non è registrato al punto vendita");
        }
        SessionManager.getSession().put(SessionManager.LOGGED_USER, u);
        result.setMessage("Benvenuto " + u.getNome() + " " + u.getCognome());

        result.setResult(LoginResult.Result.LOGIN_OK);
        return result;
    }
}