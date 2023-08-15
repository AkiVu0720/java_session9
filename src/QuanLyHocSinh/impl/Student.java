package QuanLyHocSinh.impl;

import QuanLyHocSinh.impl.ra.IStudent;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Student implements IStudent {
    private String studentId;
    private String studentName;
    private int age;
    private float htmlScore;
    private float cssScore;
    private float javaScripScore;
    private boolean sex;
    private String arrange;
    private String status;
    private float avgMark;
//2 get,set


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(float htmlScore) {
        this.htmlScore = htmlScore;
    }

    public float getCssScore() {
        return cssScore;
    }

    public void setCssScore(float cssScore) {
        this.cssScore = cssScore;
    }

    public float getJavaScripScore() {
        return javaScripScore;
    }

    public void setJavaScripScore(float javaScripScore) {
        this.javaScripScore = javaScripScore;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getArrange() {
        return arrange;
    }

    public void setArrange(String arrange) {
        this.arrange = arrange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getAvgMark() {
        return avgMark;
    }
    //3 Constructor

    public Student() {
    }

    public Student(String studentId, String studentName, int age, float htmlScore, float cssScore, float javaScripScore, boolean sex) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.javaScripScore = javaScripScore;
        this.sex = sex;
    }
    //4 Methou

@Override
    public void inputData(Scanner scanner, List<Student> studentArrayList) {
        System.out.println("Nhap ma SV");
        boolean checkStudent = true;
        do {
            String studentId = scanner.nextLine();
            boolean isDuplicate = false;
            for (Student student:studentArrayList) {
                 if (student.getStudentId().equalsIgnoreCase(studentId)){
                     isDuplicate = true;
                     break;
                 }
            }
            if (isDuplicate) {
                System.out.println("Ma Sinh Vien da ton tai");
            } else {
                boolean isTruestudenId = false;
                    if(studentId.startsWith("SV")){
                        if (studentId.length()>=5){
                            isTruestudenId = true;
                        }
                    }else {
                        System.out.println("Vui long nhap lai");
                    }
                    if (isTruestudenId){
                        this.studentId = studentId;
                        checkStudent = false;
                    }
            }
        } while (checkStudent);

        boolean checkName = true;
        System.out.println("Nhap ten Sinh Vien");
        do {
            this.studentName = scanner.nextLine();
            String nameRegex = "^(?=.{6,50}$)[A-Za-zÀ-ỹ][A-Za-zÀ-ỹ ]*$";
            boolean isName = Pattern.matches(nameRegex, this.studentName);
            if (!isName) {
                System.out.println("Vui long nhap lai:");
            } else {
                checkName = false;
            }
        } while (checkName);

        do {
            System.out.println("Vui long nhap tuoi(tu 18t tro len)");
            this.age = Integer.parseInt(scanner.nextLine());
        } while (this.age < 18);
        boolean checkSex = true;
        do {
            System.out.println("lua chon gioi tinh: ");
            System.out.println("1.Nam");
            System.out.println("2.Nu");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    this.sex = true;
                    checkSex = false;
                    break;
                case 2:
                    this.sex = false;
                    checkSex = false;
                    break;
                default:
                    System.out.println("Vui long chon lai.");
                    break;
            }
            checkSex = false;

        } while (checkSex);


        do {
            System.out.println("Vui long nhap diem HTML(0-10)");
            this.htmlScore = Integer.parseInt(scanner.nextLine());
        } while (this.htmlScore < 0 || this.htmlScore > 10);

        do {
            System.out.println("Vui long nhap diem CSS(0-10)");
            this.cssScore = Integer.parseInt(scanner.nextLine());
        } while (this.cssScore < 0 || this.cssScore > 10);

        do {
            System.out.println("Vui long nhap diem JavaScrip(0-10)");
            this.javaScripScore = Integer.parseInt(scanner.nextLine());
        } while (this.javaScripScore < 0 || this.javaScripScore > 10);

    }


   

    @Override
    public void displayData() {
        String sex = this.sex ? "Nam" : "Nu";
        System.out.printf("Ma SV: %3s Ten: %3s Tuoi: %3d Gioi Tinh: %3s Html: %3.1f Css: %3.1f JavaScrip: %3.1f DiemTB: %3.1f XepLoai: %3s \n", this.studentId, this.studentName, this.age,
                sex, this.htmlScore, this.cssScore, this.javaScripScore, this.avgMark, this.arrange);
    }

    @Override
    public float calAvgMark() {
        return  this.avgMark = (float) (Math.round(((this.htmlScore + this.cssScore + this.javaScripScore) / 3)*10)/10);
    }
    public void evaluateStudent() {
        if (this.avgMark > 9)
            this.arrange = "Xuat sac";
        else if (this.avgMark >= 8)
            this.arrange = "Gioi";
        else if (this.avgMark >= 7)
            this.arrange = "Kha";
        else if (this.avgMark >= 5)
            this.arrange = "Trung binh";
        else
            this.arrange = "Yeu";

    }
    public void statusStudent(){
        this.status = this.avgMark< MARK_PASS ?"FAIL":"MARK";
    }

}
