public class Student {
    private final int studentId;
    private String studentName;
    private int age;
    private boolean isMale;
    private double mathScore;
    private double physicScore;
    private double chemistryScore;
    private double avg;
    private String rank;
    public Student(int studentId, String studentName, int age, boolean isMale, double mathScore, double physicScore, double chemistryScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.isMale = isMale;
        this.mathScore = mathScore;
        this.physicScore = physicScore;
        this.chemistryScore = chemistryScore;
        updatePoint();
    }


    public Student(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
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

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
        updatePoint();
    }

    public double getPhysicScore() {
        return physicScore;
    }

    public void setPhysicScore(double physicScore) {
        this.physicScore = physicScore;
        updatePoint();
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
        updatePoint();
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    private void updatePoint() {
        avg = (mathScore + physicScore + chemistryScore) / 3;
        if (avg >= 8 && mathScore > 6.5 && physicScore > 6.5 && chemistryScore > 6.5) {
            rank = "Giỏi";
        } else if (avg >= 6.5 && mathScore > 5 && physicScore > 5 && chemistryScore > 5) {
            rank = "Khá";
        } else if (avg >= 5 && mathScore > 3.5 && physicScore > 3.5 && chemistryScore > 3.5) {
            rank = "Trung bình";
        } else {
            rank = "Yếu";
        }
    }

    void updateInfo(String name, int age, double mathScore, double physicScore, double chemistryScore) {
        setStudentName(name);
        setAge(age);
        setMathScore(mathScore);
        setPhysicScore(physicScore);
        setChemistryScore(chemistryScore);
    }

    @Override
    public String toString() {
        return String.format("| %-12d | %-20s | %-5d | %-10s | %-7.2f | %-7.2f | %-7.2f |\n" +
                            "+----------------------------------------------------------------------------------------+",
                getStudentId(), getStudentName(), age, (isMale() ? "Nam" : "Nữ"), getMathScore(), getPhysicScore(), getChemistryScore());
    }
}
