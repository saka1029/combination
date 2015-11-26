package stackoverflow;

import java.util.LinkedList;
import java.util.List;

public class Employee {

        private String name;
        private String last;
        private Gender gender;
        private int ID;

        Employee(int ID, String name, String last, Gender gender){

            this.name=name;
            this.last=last;
            this.gender=gender;
            this.ID=ID;
        }

        public enum Gender {
            M,F
        }


    public static void main(String[] args){

        List<Employee> oopClass = new LinkedList<>();

        oopClass.add(new Employee(100,"Mick","tayson", Gender.M));
        oopClass.add(new Employee(101,"Jonny","Tayson", Gender.F ));
        oopClass.add(new Employee(108,"Barack","Obama", Gender.F));
        oopClass.add(new Employee(105,"Vlad","Putin", Gender.M));
    }
}
