package Business;

import DAO.IUtenteDAO;
import DAO.UtenteDAO;
import Model.Utenti.Utente;

public class UtenteBusiness {
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();

    //utilizzo il singleton
    private static UtenteBusiness instance;
    public static synchronized UtenteBusiness getInstance(){
        if (instance == null) {
            instance = new UtenteBusiness();
        }
        return instance;
    }

    //creo una classe LoginResult che mi indica lo stato del login
    public LoginResult login(String username , String password) {

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

        switch (u.getTipo()) {
            case "CL" -> {
                SessionManager.getSession().put(SessionManager.LOGGED_USER, u);
                result.setMessage("Benvenuto " + u.getNome() + " " + u.getCognome());
            }
            case "MN" -> {
                SessionManager.getSession().put(SessionManager.LOGGED_MANAGER, u);
                result.setMessage("Benvenuto " + u.getNome() + " " + u.getCognome());
            }
            case "AM" -> {
                SessionManager.getSession().put(SessionManager.LOGGED_ADMIN, u);
                result.setMessage("Benvenuto " + u.getNome() + " " + u.getCognome());
            }
        }
        result.setResult(LoginResult.Result.LOGIN_OK);
        return result;
    }
}