package Business;

import DAO.UtenteDAO;
import Model.Amministratore;
import Model.Cliente;
import Model.Manager;

public class UtenteBusiness {

    //utilizzo il singleton
    private static UtenteBusiness instance;
    public static synchronized UtenteBusiness getInstance(){
        if (instance == null) {
            instance = new UtenteBusiness();
        }
        return instance;
    }

    //creo una classe LoginResult che mi indica lo stato del login
    public LoginResult login(String username , String password){

        LoginResult result = new LoginResult();
        UtenteDAO uDAO = UtenteDAO.getInstance();

        //controllare se l'utente esiste
        boolean userExists = uDAO.userExists(username);
        if (!userExists) {
            result.setResult(LoginResult.Result.USER_DOESNT_EXIST);
            result.setMessage("L'username inserito non esiste");
            return result;
        }

        //controllare se username e password sono valide
        boolean credentialsOk = uDAO.checkCredentials(username,password);
        if (!credentialsOk){
            result.setResult(LoginResult.Result.WRONG_PASSWORD);
            result.setMessage("La password inserita non è corretta");
            return result;
        }


        //che tipo di utente è
        boolean isCliente = uDAO.isCliente(username);
        boolean isAmministratore = uDAO.isAmministratore(username);
        boolean isManager = uDAO.isManager(username);

        //caricare oggetto utente a seconda del tipo
        if (isCliente){
            Cliente c = uDAO.caricaCliente(username);
            SessionManager.getSession().put(SessionManager.LOGGED_USER,c);
            result.setMessage("Benvenuto" +c.getNome());
        } else if (isManager){
            //da fare da solo
            //Manager m = uDAO.caricaManager(username);
            //Manager m  = uDAO.caricaManager(username);
           // SessionManager.getSession().put(SessionManager.LOGGED_USER,m);
            //result.setMessage("Benvenuto" +m.getName());
        }else if (isAmministratore){
            //da fare da solo
            //Amministratore a = uDAO.caricaAmministratore(username);
           // Amministratore a = uDAO.caricaAmministratore(username);
            //SessionManager.getSession().put(SessionManager.LOGGED_USER,a);
            //result.setMessage("Benvenuto" +a.getName());
        }

        result.setResult(LoginResult.Result.LOGIN_OK);


        return result;




    }




}
