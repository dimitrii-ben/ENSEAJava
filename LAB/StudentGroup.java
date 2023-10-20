import java.util.regex.Pattern;

public class StudentGroup {
    
    private String name;
    private static int totalNumberOfGroups;
    public StudentGroup(String name) throws Exception{
    //... to be completed
        if (!Pattern.matches("[1-2]G[1-3]TD[1-4]TP[1-8]",name)){
            throw new Exception(name +" is not a real ENSEA name");
        }
        this.name = name;
        StudentGroup.totalNumberOfGroups++;
    //...
        
    }

    public String toString(){
        return "[Group INFO]\nGroup name:"+this.name+"\n--------\nGroup cnt:"+StudentGroup.totalNumberOfGroups+"\n---------";
    }

    public static void main(String[] args) {
        StudentGroup a = null, b = null, c = null;
        try {
            a = new StudentGroup("1G1TD1TP1");
            b = new StudentGroup("2G1TD1TP1");
            c = new StudentGroup("1G1TD1TP2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    
}

