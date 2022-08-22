package DAO;

import Model.Guest;

import java.util.ArrayList;

public interface IGuestDAO {
    public ArrayList<Guest> findAll();
    public Guest findByIP(String IP);
    public int add(Guest guest);
    public int removeByName(String nome);
    public int update(Guest guest);
}
