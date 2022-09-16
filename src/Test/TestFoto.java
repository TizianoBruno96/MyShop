package Test;

import DAO.FotoDAO;
import DAO.Interfaces.IFotoDAO;
import Model.Articoli.Foto;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Scanner;

public class TestFoto {
    public static void main(String[] args) {
        IFotoDAO fotoDAO = FotoDAO.getInstance();


        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci il path della foto");
        String path = in.nextLine();
        System.out.println("Inserisci il nome della foto");
        String nome = in.nextLine();
        try (FileInputStream inputStream = new FileInputStream(path)) {
            Blob blob = new SerialBlob(inputStream.readAllBytes());
            Foto foto1 = new Foto(5600, blob, nome);
            fotoDAO.add(foto1);
        } catch (SQLException e) {
            System.out.println("Errore nel database");
        } catch (FileNotFoundException e) {
            System.out.println("Foto non trovata");
        } catch (IOException e) {
            System.out.println("Errore di I/O");
        }
    }
}
