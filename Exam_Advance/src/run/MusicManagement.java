package run;

import config.Config;
import controller.SingerController;
import model.Singer;
import model.Song;
import service.SingService;
import service.SongService;

import java.util.Date;


public class MusicManagement {
    Date date = new Date();
    static SingerController controllerSinger = new SingerController();
    static Singer[] listSinger = SingService.listSinger;
    static Song[] listSong = SongService.listSong;
    public static void main(String[] args) {

        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Config.getScanner().nextInt();
            switch (choice) {
                case 1:
                    singerMenu();
                    break;
                case 2:
                    songManager();
                    break;
                case 3:
                    searchManager();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
            }
            if (choice == 4) {
                break;
            }
        }
    }

    public static void singerMenu() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới ");
            System.out.println("2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ ");
            System.out.println("3.Thay đổi thông tin ca sĩ theo mã id ");
            System.out.println("4.Xóa ca sĩ theo mã id");
            System.out.println("5.Thoát");
            choice = Config.getScanner().nextInt();
            switch (choice) {
                case 1:
                    createNameSinger();
                    break;
                case 2:
                    showNameSinger();
                    break;
                case 3:
                    editNameSinger();
                    break;
                case 4:
                    deleteSinger();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nhập từ 1 => 5");
            }
        }
    }
    static void createNameSinger(){
        System.out.println("Nhập số lượng ca sĩ cần thêm vào:");
        int n = Config.getScanner().nextInt();
        for (int i = 0; i < n; i++) {
            int id = maxid();
            listSinger[i] = new Singer();
            listSinger[i].setSingerId(id);
            System.out.printf("Nhập ca si thu %d ",i+1);
            System.out.println("Nhập tên ca sĩ: ");
            listSinger[i].setSingerName(Config.getScanner().nextLine());
            System.out.println("Nhập tuổi: ");
            listSinger[i].setAge(Config.getScanner().nextInt());
            System.out.println("Nhập quốc tịch: ");
            listSinger[i].setNationality(Config.getScanner().nextLine());
            System.out.println("NHập giới tính: ");
            listSinger[i].setGender(Config.getScanner().nextBoolean());
            System.out.println("Nhập thể loại :");
            listSinger[i].setGenre(Config.getScanner().nextLine());
        }
    }
    static int maxid(){
        int maxid = 0;
        for (int i = 0; i < listSinger.length; i++) {
            if(listSinger[i] != null && maxid < listSinger[i].getSingerId())
            maxid = listSinger[i].getSingerId();
        }
        return maxid+1;
    }
    static void showNameSinger(){
        for (int i = 0; i < listSinger.length; i++) {
            if(listSinger[i] != null){
                System.out.println(listSinger[i]);
            }
        }
    }
    static void editNameSinger(){
        System.out.println("Nhập id cần sửa:");
        int id = Config.getScanner().nextInt();
        Singer singer = controllerSinger.findById(id);
        if(singer == null){
            System.out.println("Không tìm thấy thông tin.");
            return;
        }
        System.out.println("Nhập tên ca sĩ:");
        String nameSinger = Config.getScanner().nextLine();
        System.out.println("Nhập tuổi: ");
        int ageSinger = Config.getScanner().nextInt();
        System.out.println("Nhập quốc tịch: ");
        String national = Config.getScanner().nextLine();
        System.out.println("Nhập giới tính: ");
        boolean gender = Config.getScanner().nextBoolean();
        System.out.println("Nhập thể loại: ");
        String genre = Config.getScanner().nextLine();
        singer.setSingerName(nameSinger);
        singer.setAge(ageSinger);
        singer.setNationality(national);
        singer.setGender(gender);
        singer.setGenre(genre);
        boolean check = controllerSinger.saveSinger(singer);
        if(check){
            System.out.println("Sửa thành công");
        } else {
            System.out.println("Sửa thất bai");
        }
    }
static void deleteSinger(){
    System.out.println("Nhập id cần xóa: ");
    int id = Config.getScanner().nextInt();
    Singer singer = controllerSinger.findById(id);
    if(singer == null){
        System.out.println("Không tìm thấy id.");
    } else {
        controllerSinger.deleteSinger(id-1);
        System.out.println("Xóa thành công");
    }

}

    public static void songManager() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới ");
            System.out.println("2.Hiển thị danh sách tất cả bài hát đã lưu trữ  ");
            System.out.println("3.Thay đổi thông tin bài hát theo mã id ");
            System.out.println("4.Xóa bài hát theo mã id ");
            System.out.println("5.Thoát");
            choice = Config.getScanner().nextInt();
            switch (choice) {
                case 1:
                    addSong();
                    break;
                case 2:
                    showSong();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nhập từ 1 => 5");
            }
        }
    }
    static void addSong(){
        System.out.println("Nhập số lượng bài hát cần thêm vào:");
        int n = Config.getScanner().nextInt();
        String id ;
        int count =0;

        for (int i = 0; i < n; i++) {
            listSong[i] = new Song();
            System.out.printf("Nhập bai hat thu %d ",i+1);
            System.out.println("Nhập id: " );
            listSong[i].setSongId(Config.getScanner().nextLine());
            System.out.println("Nhập tên bài hát: ");
            listSong[i].setSongName(Config.getScanner().nextLine());
            System.out.println("Nhập mô tả: ");
            listSong[i].setDescriptions(Config.getScanner().nextLine());
            System.out.println("Nhập ngươi sáng tác: ");
            listSong[i].setSongWriter(Config.getScanner().nextLine());
            listSong[i].setCreatedDate(new Date());
            listSong[i].setSongStatus((true));
        }
    }
    static void showSong(){
        for (int i = 0; i < listSong.length; i++) {
            if(listSong[i] != null){
                System.out.println(listSong[i]);
            }
        }
    }


    public static void searchManager() {
        int choice = 0;
        while (choice != 5) {
            System.out.println("**********************SEARCH-MANAGEMENT*************************");
            System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại .");
            System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại  ");
            System.out.println("3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần ");
            System.out.println("4.Hiển thị 10 bài hát được đăng mới nhất ");
            System.out.println("5.Thoát");
            choice = Config.getScanner().nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nhập từ 1 => 5");

            }
        }
    }


}