import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class StudentGroup {
    
    private String name;
    private static int totalNumberOfGroups;
    private ArrayList<Student> students;
    public StudentGroup(String name) throws Exception{
    //... to be completed
        if (!Pattern.matches("[1-2]G[1-3]TD[1-4]TP[1-8]",name)){
            throw new Exception(name +" is not a real ENSEA name");
        }
        this.name = name;
        this.students = new ArrayList<Student>();
        StudentGroup.totalNumberOfGroups++;
    //...
     
    }
    public void addStudent(Student student){
        students.add(students.size(), student);
    }
    public void displayPresenceList(){
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ) {
            Student item = iterator.next();
            System.out.println(item);
        }
    }

    public int getStudentCnt(){
        return this.students.size();
    }

    public String toString(){
        return "[Group INFO]\nGroup name:"+this.name+"\n--------\nGroup cnt:"+StudentGroup.totalNumberOfGroups+"\n---------\nStudents cnt:"+this.getStudentCnt()+"\n";
    }
    public static int getTotalNumberOfGroups(){
        return StudentGroup.totalNumberOfGroups;
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }

    public static void main(String[] args) {
        StudentGroup a = null, b = null, c = null;
        try {
            a = new StudentGroup("1G1TD1TP1");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        Student student1= new Student("maman", "t'es ou");
        Student student2= new Student("papa", "t'es ou");
        a.addStudent(student1);
        a.addStudent(student2);
      
        a.displayPresenceList();
    
    }
    
}

