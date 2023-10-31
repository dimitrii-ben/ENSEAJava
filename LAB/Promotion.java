import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;



public class Promotion {
    
    private String name;
    private ArrayList<StudentGroup> groups;

    public Promotion(String name){
        this.name = name;
        this.groups = new ArrayList<StudentGroup>();
    }

    public void addGroup(StudentGroup group){
        groups.add(StudentGroup.getTotalNumberOfGroups()-1,group);
    }
    /*@args
     * name: A Group name XGXTPX
     * Parse the StudentGroup arraylist and return the equivalent StudentGroup
     * return value: A Student Group
     */
    public StudentGroup findGroup(String name){
        for (Iterator<StudentGroup> iterator = this.groups.iterator(); iterator.hasNext(); ) {
            StudentGroup item = iterator.next();
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }
    public ArrayList<StudentGroup> getGroups(){
        return this.groups;
    }
    public Student findStudent(StudentGroup group,String first,String last){
        
        StudentGroup currentgroup = this.findGroup(group.getName());
        if (currentgroup != null){
            ArrayList<Student> students = currentgroup.getStudents();
            for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ) {
                Student item = iterator.next();
                if(item.getFirstName().equals(first) && item.getLastName().equals(last)){
                    return item;
                }
        }
        }
        
        return null;
    }

    public void fillPromotion(String path){
        try{FileReader fileReader = new FileReader(path);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                StudentGroup currentgroup;
                while ((line = bufferedReader.readLine())!= null){
                    /*
                     * 0: Last Name
                     * 1: First Name
                     * 2: Group name
                     */
                    String[] column_data = line.split(",");

                    if (this.findGroup(column_data[2]) == null){
                        try {
                            currentgroup = new StudentGroup(column_data[2]);
                            this.addGroup(currentgroup);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }   
                    }
                    currentgroup = this.findGroup(column_data[2]);
                    if (this.findStudent(currentgroup,column_data[1],column_data[0])==null){
                        Student s = new Student(column_data[1],column_data[0]);
                        currentgroup.addStudent(s);
                    }
                     
                    
                    
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Promotion ENSEA = new Promotion("ENSEA");
        ENSEA.fillPromotion("LAB/liste2_2020_2021.csv");
        ArrayList<StudentGroup> current_groups = ENSEA.getGroups();
        current_groups.get(1).displayPresenceList();
        
    }

}
