package QuanLyHocSinh.impl.run;

import QuanLyHocSinh.impl.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    static List<Student> arrStudent = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        do {
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. Tính điểm trung bình");
            System.out.println("3. Đánh giá xếp loại");
            System.out.println("4. Tình trạng Sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng đần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo ten");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên");
            System.out.println("10.Thoát");

        byte choice = Byte.parseByte(scanner.nextLine());
        switch (choice){
            case 1:
                inputSinhVien(scanner);
                break;
            case 2:
                avgMark();
                break;
            case 3:
                evaluate();
                break;
            case 4:
                status();
                break;
            case 5:
                disPlay();
                break;
            case 6:
                sortAvg();
                break;
            case 7:
                searchName(scanner);
                break;
            case 8:
                studentByArrange();
                break;
            case 9:
                break;
            case 10:
                isExit = false;
                break;
            default:
                System.out.println("Vui long nhap lai");
                break;
        }
        }while (isExit);
    }

    public static void inputSinhVien(Scanner scanner){
        Student student = new Student();
        student.inputData(scanner,arrStudent);
        arrStudent.add(student);
    }
    public static void avgMark(){
        for ( Student st :arrStudent) {
            st.calAvgMark();
        }
        System.out.println("Đã tính xong");
    }
    public static void evaluate(){
        for ( Student st :arrStudent) {
            st.evaluateStudent();
        }
        System.out.println("Đã tính xong");
    }
    public static void status(){
        for ( Student st :arrStudent) {
            st.statusStudent();
        }
        System.out.println("Đã tính xong");
    }
    public static void disPlay(){
        for (Student st: arrStudent) {
            st.displayData();
        }
    }

    public static void sortAvg(){
       arrStudent.sort(new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               return o1.getAge()-o2.getAge();
           }
       });
        System.out.println("Đã sắp xếp xong");
    }

    public static void searchName(Scanner scanner){
        boolean isStudent = true;
        System.out.println("Nhap ten Sinh vien tim kiem: ");
        String studentName = scanner.nextLine();
        for (Student student :arrStudent) {
            if (student.getStudentName().toLowerCase().contains(studentName.toLowerCase())){
                student.displayData();
                isStudent = true;
            }
        }
        if (!isStudent){
            System.out.println("Khong tim thay Sinh vien");
        }
    }
    public static void studentByArrange(){
        int xuatXuac = 0, gioi = 0, kha = 0, trungBinh = 0, yeu= 0;
        for ( Student st: arrStudent) {
               switch (st.getArrange()){
                   case "Xuat sac":
                       xuatXuac+=1;
                       break;
                   case "Gioi":
                       gioi+=1;
                       break;
                   case "Kha":
                       kha+=1;
                       break;
                   case "Trung binh":
                       trungBinh+=1;
                       break;
                   case "Yeu":
                       yeu+=1;
               }
        }
        System.out.println("Thong ke theo Xep loai: ");
            System.out.printf("Xuat Sac: %3d - Gioi: %3d - Kha:%3d - Trung Binh: %3d - Yeu: %3d \n", xuatXuac,gioi,kha,trungBinh,yeu);
    }
}
