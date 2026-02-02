import java.util.Scanner;

public class Validator {

    // validate cho dữ liệu INT
    static int getInt(Scanner sc, String label, int min, int max) {
        String input;
        while(true){
            System.out.print(label);
            input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches("\\d+")) {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            }
            System.out.println(Message.INVALID_DATA);
        }
    }


    // tìm sinh viên bằng id
    static Student findStudentById(int id){
        for(int i = 0; i < StudentManager.totalStudent; i++){
            if(StudentManager.students[i] != null && StudentManager.students[i].getStudentId() == id){
                return StudentManager.students[i];
            }
        }
        return null;
    }


    // validate cho điểm nhập vào
    static double scoreInput(Scanner sc, String label, int min, int max) {
        String input;
        while(true){
            System.out.print(label);
            input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches("^\\d+(\\.\\d+)?$")) {
                double value = Double.parseDouble(input);
                if (value >= min && value <= max) {
                    return value;
                }else{
                    System.out.println("Điểm phải lớn hơn 0 và nhỏ hơn 10!");
                }
            }else{
                System.out.println(Message.INVALID_DATA);
            }
        }
    }


    // validate cho dữ liệu String
    static String getString(Scanner sc, String label) {
        String input;
        while(true){
            System.out.print(label);
            input = sc.nextLine().trim();
            if(input.isEmpty()){
                System.out.println(Message.EMPTY_DATA);
            }else{
                return input.trim().replaceAll("\\s+"," ");
            }
        }
    }
}
