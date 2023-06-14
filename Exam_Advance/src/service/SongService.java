package service;

import model.Singer;
import model.Song;

public class SongService {
    public static Song[] listSong = new Song[50];
    public boolean saveSong(Song song) {
        if (song == null) {
            return false;
        }
        for (int i = 0; i < listSong.length; i++) {
            if (listSong[i] == null) {
                listSong[i] = song;
                return true;
            }
        }
        return false;
    }
}
