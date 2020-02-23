package optional;

import java.util.*;

/**
 * @Author ZhengH
 * @Date 2019/12/3 20:04
 **/
public class test2 {
    public static void main(String[] args) {
        Student student = new Student("1");
        School school = new School();
        List<Student> students = Collections.singletonList(student);
        school.setList(students);
        Optional<School> listOptional = Optional.ofNullable(school);
        System.out.println(listOptional.map(School::getList).orElse(new ArrayList<>()));

    }
}

class School{
    private List<Student> list;

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}

class Student{
    private String name ;

    public String getName() {
        return name;
    }

    public Student(String name) {
        this.name = name;
    }
}
