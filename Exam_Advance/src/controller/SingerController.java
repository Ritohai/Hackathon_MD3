package controller;

import model.Singer;
import service.SingService;

public class SingerController {
    private SingService service = new SingService();
    public boolean saveSinger(Singer singer){
        return service.saveSinger(singer);
    }
    public Singer findById(int id){
        return service.findById(id);
    }
    public boolean deleteSinger(int id){
        return service.deleteSinger(id);
    }
}
