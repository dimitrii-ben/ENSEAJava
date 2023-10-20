public class Student {
    private String firstName,lastName;
    private static int totalNumberOfStudents;

    public Student(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        Student.totalNumberOfStudents++;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public static int getTotalNumberOfStudents() {
        return totalNumberOfStudents;
    }
    public String toString(){
        return "[Student INFO]\n*First Name: "+ this.firstName+"\n*Last Name: "+this.lastName+"\n------------\nStudent cnt:"+Student.totalNumberOfStudents+"\n------------";
    }

    public static void main(String[] args) {
        Student student1 = new Student("Dim", "Ben");
        System.out.println(student1);
        Student student2 = new Student("Dim2", "Ben2");
        System.out.println(student2);
    }
}
