import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static ArrayList<Student> students = new ArrayList<>();

    static void ok() {
        students.add(new Student(1, "Nguyen Van An", 18, true, 8.5, 7.0, 9.0));
        students.add(new Student(2, "Tran Thi Binh", 19, false, 5.0, 6.5, 4.5));
        students.add(new Student(3, "Le Van Cuong", 20, true, 7.5, 8.0, 8.5));
        students.add(new Student(4, "Pham Minh Duc", 18, true, 4.0, 3.5, 5.0));
        students.add(new Student(5, "Hoang Lan Anh", 19, false, 9.0, 9.5, 10.0));
        students.add(new Student(6, "Do Thanh Hai", 21, true, 6.0, 5.5, 6.5));
        students.add(new Student(7, "Bui Tuyet Mai", 18, false, 8.0, 8.0, 8.0));
        students.add(new Student(8, "Nguyen Manh Hung", 19, true, 5.5, 4.0, 3.5));
        students.add(new Student(9, "Vu Thuy Linh", 20, false, 7.0, 7.5, 6.0));
        students.add(new Student(10, "Ly Hoang Nam", 18, true, 10.0, 9.5, 9.0));
    }

    // thêm sinh viên
    static void insertStudent(Scanner sc) {
        // nhập mã sinh viên và kiểm tra trùng lặp
        if(students.size() > 100) {
            System.out.println("Mảng đã đầy!");
            return;
        }
        int id;
        do {
            id = Validator.getInt(sc, "Nhập mã sinh viên (1-9999): ", 1, 9999);
            // kiểm tra trùng lặp id
            if (Validator.findStudentById(id) != null) {
                System.out.println(Message.DUPLICATE_ID);
            }
        } while (Validator.findStudentById(id) != null);

        // nhập tên sinh viên
        String name = Validator.getString(sc, "Nhập tên sinh viên : ");

        // nhập tuổi sinh viên
        int age = Validator.getInt(sc, "Nhập tuổi : ", 18, 30);

        // nhập giới tính sinh viên
        boolean gender = Validator.getInt(sc, "Giới tính (Nam : 1 / Nữ : 0) : ", 0, 1) == 1;

        // nhập điểm toán
        double math = Validator.scoreInput(sc, "Điểm toán : ", 0, 10);

        // nhập điểm vật lý
        double physic = Validator.scoreInput(sc, "Điểm lý : ", 0, 10);

        // nhập điểm hoá học
        double chemistry = Validator.scoreInput(sc, "Điểm hoá : ", 0, 10);

        // tạo đối tượng sinh viên mới
        Student newStudent = new Student(id, name, age, gender, math, physic, chemistry);

        // thêm vào mảng dữ liệu
        students.add(newStudent);

        // thông báo thêm thành công
        System.out.println("Thêm học sinh thành công!");
    }

    // in ra danh sách tất cả các sinh viên
    static void displayAllStudents() {
        // kiểm tra danh sách có dữ liệu không
        if (students.isEmpty()) {
            System.out.println(Message.STUDENTS_EMPTY);
            return;
        }
        System.out.println("+----------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-20s | %-5s | %-10s | %-7s | %-7s | %-7s |\n", "Mã sinh viên", "Tên sinh viên", "Tuổi", "Giới tính", "Toán", "Vật lý", "Hoá học");
        System.out.println("+----------------------------------------------------------------------------------------+");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    // tìm kiếm sinh viên
    static void searchStudent(Scanner sc, int choice) {
        if (students.isEmpty()) {
            System.out.println(Message.STUDENTS_EMPTY);
            return;
        }

        // tìm sinh viên theo lựa chọn của người dùng
        switch (choice) {
            // tìm sinh viên theo mã sinh viên
            case 1:
                int input = Validator.getInt(sc, "Nhập mã sinh viên : ", 1, 9999);
                Student findStudent = Validator.findStudentById(input);
                if (findStudent != null) {
                    System.out.println("+----------------------------------------------------------------------------------------+");
                    System.out.printf("| %-10s | %-20s | %-5s | %-10s | %-7s | %-7s | %-7s |\n", "Mã sinh viên", "Tên sinh viên", "Tuổi", "Giới tính", "Toán", "Vật lý", "Hoá học");
                    System.out.println("+----------------------------------------------------------------------------------------+");
                    System.out.println(findStudent.toString());
                } else {
                    System.out.println(Message.STUDENT_NOT_FOUND);
                }
                break;
            // tìm sinh viên theo tên
            case 2:
                boolean flag = false;
                String searchName = Validator.getString(sc, "Nhập tên sinh viên : ");
                for (Student student : students) {
                    if (student != null && student.getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                        System.out.println(student.toString());
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println(Message.STUDENT_NOT_FOUND);
                }
                break;
        }
    }

    // cập nhật các thông tin được cho phép của sinh viên
    static void updateStudent(Scanner sc) {
        if (students.isEmpty()) {
            System.out.println(Message.STUDENTS_EMPTY);
            return;
        }
        int input = Validator.getInt(sc, "Nhập mã sinh viên : ", 1, 9999);
        Student findStudent = Validator.findStudentById(input);
        if (findStudent != null) {
            // tên
            String name = Validator.getString(sc, "Nhập tên mới sinh viên : ");
            // tuổi
            int age = Validator.getInt(sc, "Nhập tuổi mới : ", 18, 30);

            // nhập điểm toán
            System.out.println("Điểm hiện tại : " + findStudent.getMathScore());
            double math = Validator.scoreInput(sc, "Điểm toán mới : ", 0, 10);

            // nhập điểm vật lý
            System.out.println("Điểm hiện tại : " + findStudent.getPhysicScore());
            double physic = Validator.scoreInput(sc, "Điểm lý mới : ", 0, 10);

            // nhập điểm hoá học
            System.out.println("Điểm hiện tại : " + findStudent.getChemistryScore());
            double chemistry = Validator.scoreInput(sc, "Điểm hoá mới : ", 0, 10);

            findStudent.updateInfo(name, age, math, physic, chemistry);
            System.out.println("Cập nhật sinh viên thành công!");
        } else {
            System.out.println(Message.STUDENT_NOT_FOUND);
        }
    }

    // xoá sinh viên
    static void deleteStudent(Scanner sc) {
        if (students.isEmpty()) {
            System.out.println(Message.STUDENTS_EMPTY);
            return;
        }
        int input = Validator.getInt(sc, "Nhập mã sinh viên : ", 1, 9999);
        Student findStudent = Validator.findStudentById(input);
        int confirm = Validator.getInt(sc,"Bạn có chắc chắn muốn xoá sinh viên này không (Có : 1 / Không : 0) : ",0,1);
        if(confirm == 0){
            return;
        }
        if (findStudent != null) {
            int index = -1;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i) != null && students.get(i).getStudentId() == findStudent.getStudentId()) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = index; i < students.size() - 1; i++) {
                    students.set(i,students.get(i + 1));
                }
            }
            students.remove(students.size() - 1);
            System.out.println("Xoá sinh viên thành công!");
        } else {
            System.out.println(Message.STUDENT_NOT_FOUND);
        }
    }


    // in ra điểm trung bình và xếp loại của sinh viên được chọn
    static void studentRank(Scanner sc) {
        if (students.isEmpty()) {
            System.out.println(Message.STUDENTS_EMPTY);
            return;
        }
        int input = Validator.getInt(sc, "Nhập mã sinh viên : ", 1, 9999);
        Student findStudent = Validator.findStudentById(input);
        if (findStudent != null) {
            System.out.println("+----------------------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-20s | %-5s | %-10s | %-7s | %-10s |\n", "Mã sinh viên", "Tên sinh viên", "Tuổi", "Giới tính", "Điểm trung bình", "Xếp loại");
            System.out.println("+----------------------------------------------------------------------------------------+");
            System.out.printf("| %-12d | %-20s | %-5d | %-10s | %-15.2f | %-10s |\n",
                    findStudent.getStudentId(), findStudent.getStudentName(), findStudent.getAge(), findStudent.isMale() ? "Nam" : "Nữ", findStudent.getAvg(), findStudent.getRank());
            System.out.println("+----------------------------------------------------------------------------------------+");
        } else {
            System.out.println(Message.STUDENT_NOT_FOUND);
        }
    }

    // sắp xếp sinh viên
    static void sortStudents(Scanner sc, int choice) {
        if (students.isEmpty()) {
            System.out.println(Message.STUDENTS_EMPTY);
            return;
        }
        switch (choice) {
            // sắp xếp theo điểm trung bình bằng bubble sort
            case 1:
                for (int i = 0; i < students.size() - 1; i++) {
                    for (int j = 0; j < students.size() - 1 -i; j++) {
                        if(students.get(j) != null && students.get(j).getAvg() < students.get(j+1).getAvg()) {
                            Student temp = students.get(j);
                            students.set(j,students.get(j+1));
                            students.set(j+1, temp);
                        }
                    }
                }
                break;
            // sắp xếp theo tên sinh viên bằng selection sort
            case 2:
                for (int i = 0; i < students.size() - 1; i++) {
                    int minIndex =  i;
                    for (int j = i + 1; j < students.size(); j++) {
                        if(students.get(j) != null && (students.get(j).getStudentName().toLowerCase().charAt(0) <  students.get(minIndex).getStudentName().toLowerCase().charAt(0))) {
                            minIndex = j;
                        }
                    }

                    if(minIndex != i) {
                        Student temp = students.get(minIndex);
                        students.set(minIndex, students.get(i));
                        students.set(i, temp);
                    }
                }
                break;
        }
        System.out.println("Sắp xếp thành công!");
    }


    // tính số học sinh ở từng xếp loại
    static void statisRank() {
        int gioi = 0,kha = 0, tb = 0,yeu = 0;
        for (Student student : students) {
            switch (student.getRank()) {
                case "Giỏi" -> gioi++;
                case "Khá" -> kha++;
                case "Trung bình" -> tb++;
                default -> yeu++;
            }
        }

        System.out.println("Giỏi : "+gioi);
        System.out.println("Khá : "+kha);
        System.out.println("Trung Bình : "+tb);
        System.out.println("Yếu : "+yeu);
    }

    // tìm ra sinh viên có điểm trung bình lớn nhất và nhỏ nhất
    static void statisMaxMin(){
        Student maxStudent = students.get(0);
        Student minStudent = students.get(0);

        for (Student student : students) {
            if (student.getAvg() > maxStudent.getAvg()) {
                maxStudent = student;
            }
            if (student.getAvg() < minStudent.getAvg()) {
                minStudent = student;
            }
        }
        System.out.println("Sinh viên có điểm cao nhất : ");
        System.out.println("+----------------------------------------------------------------------------------------+");
        System.out.println(maxStudent.toString());
        System.out.println("Sinh viên có điểm thấp nhất : ");
        System.out.println("+----------------------------------------------------------------------------------------+");
        System.out.println(minStudent.toString());
    }


    // tính trung bình điểm của tất cả sinh viên
    static void avgAllStudents(){
        double avg = 0;
        for (Student student : students) {
            avg += student.getAvg();
        }
        System.out.printf("Điểm trung bình của tất cả sinh viên : %.2f\n",avg/students.size());
    }

    // In ra thống kê
    static void statistical(){
        if (students.isEmpty()) {
            System.out.println(Message.STUDENTS_EMPTY);
            return;
        }
        statisRank();
        statisMaxMin();
        avgAllStudents();
    }
}