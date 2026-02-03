import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        StudentManager.ok();
        do {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. [FR1] Thêm sinh viên mới");
            System.out.println("2. [FR2] Hiển thị tất cả sinh viên");
            System.out.println("3. [FR3] Tìm sinh viên theo tiêu chí");
            System.out.println("4. [FR4] Cập nhật thông tin sinh viên");
            System.out.println("5. [FR5] Xóa sinh viên");
            System.out.println("6. [FR6] Tính điểm trung bình và xếp loại");
            System.out.println("7. [FR7] Sắp xếp sinh viên");
            System.out.println("8. [FR8] Thống kê");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng (1-9): ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    StudentManager.insertStudent(sc);
                    break;
                case 2:
                    StudentManager.displayAllStudents();
                    break;
                case 3:
                    System.out.println("\n===== TÌM KIẾM SINH VIÊN =====");
                    System.out.println("1. Tìm kiếm theo mã sinh viên");
                    System.out.println("2. Tìm kiếm theo tên sinh viên");
                    System.out.println("3. Quay lại");
                    System.out.print("Chọn chức năng (1-3): ");
                    int subChoice = sc.nextInt();
                    sc.nextLine();
                    switch (subChoice) {
                        case 1, 2:
                            StudentManager.searchStudent(sc, subChoice);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lê!");
                            break;
                    }
                    break;
                case 4:
                    StudentManager.updateStudent(sc);
                    break;
                case 5:
                    StudentManager.deleteStudent(sc);
                    break;
                case 6:
                    StudentManager.studentRank(sc);
                    break;
                case 7:
                    System.out.println("\n===== SẮP XẾP SINH VIÊN =====");
                    System.out.println("1. Sắp xếp theo điểm trung bình giảm dần");
                    System.out.println("2. Sắp xếp theo tên A-Z");
                    System.out.println("3. Quay lại");
                    System.out.print("Chọn chức năng (1-3): ");
                    int tempChoice = sc.nextInt();
                    sc.nextLine();
                    switch (tempChoice) {
                        case 1, 2:
                            StudentManager.sortStudents(sc, tempChoice);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lê!");
                            break;
                    }
                    break;
                case 8:
                    System.out.println("\n===== THỐNG KÊ SINH VIÊN =====");
                    StudentManager.statistical();
                    break;
                case 9:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lê!");
                    break;
            }
        } while (choice != 9);
    }
}
