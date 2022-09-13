package DAO.Interfaces;

import Model.Guest;

import java.util.ArrayList;

public interface IGuestDAO {
     ArrayList<Guest> findAll();
     Guest findByIP(String IP);
     Guest findByID(int id);
     int add(Guest guest);
     int removeByIP(String nome);
     int removeByID(int id);
     int update(Guest guest);
}
