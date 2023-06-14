package service;

import model.Singer;

public class SingService {
    public static Singer[] listSinger = new Singer[50];
    public boolean saveSinger(Singer singer) {
        if (singer == null) {
            return false;
        }
        for (int i = 0; i < listSinger.length; i++) {
            if (listSinger[i] == null) {
                listSinger[i] = singer;
                return true;
            }
        }
        return false;
    }
    public Singer findById(int id) {
        for (int i = 0; i < listSinger.length; i++) {
            if(listSinger[i].getSingerId() == id) {
                return listSinger[i];
            }
        }
        return null;
    }
    public boolean deleteSinger(int id){
        for (int i = 0; i < listSinger.length; i++) {
            if(listSinger[i] != null || listSinger[i].getSingerId() == id){
                listSinger[i] = null;
                return true;
            }
        }
        return false;
    }
}

