package model;

import java.util.Scanner;

public class Singer {
    private int singerId; //Mã ca sĩ
    private String singerName; //tên ca sĩ
    private int age; // Tuổi ca sĩ
    private String nationality; // Quốc tịch
    private boolean gender; // Giới tính
    private String genre; // Thể loại

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public Singer() {

    }

    // Getter, setter
    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên ca sĩ: ");
        this.singerName = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập quốc tịch: ");
        this.nationality = scanner.nextLine();

        System.out.print("Nhập giới tính (Nam/Nữ): ");
        String genderInput = scanner.nextLine();
        this.gender = genderInput.equalsIgnoreCase("Nam");

        System.out.print("Nhập thể loại âm nhạc: ");
        this.genre = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", gender=" + (this.gender ? "nam" : "nữ") +
                ", genre='" + genre + '\'' +
                '}';
    }
}


