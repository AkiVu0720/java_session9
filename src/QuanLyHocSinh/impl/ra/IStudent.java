package QuanLyHocSinh.impl.ra;

import QuanLyHocSinh.impl.Student;

import java.util.List;
import java.util.Scanner;

public interface IStudent {
    byte MARK_PASS = 5;
    void inputData(Scanner scanner, List<Student>studentList);
   void displayData();
  float calAvgMark();

}
