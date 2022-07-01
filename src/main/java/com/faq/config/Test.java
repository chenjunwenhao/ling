package com.faq.config;

public class Test{

    public static void main(String[] args) throws CloneNotSupportedException{

        Professor p1=new Professor();

        p1.setName("zhang");

        p1.setAge(44);

        Student s1=new Student();

        s1.setName("Xiao Ming");

        s1.setAge(15);

        s1.setProfessor(p1);

        System.out.println(s1);



        Student s2=(Student) s1.clone();//克隆s1

        Professor p2=s2.getProfessor();//这里其实获取的是p1的引用

        //其实这里修改的也是p1的属性

        p2.setName("Li");

        p2.setAge(55);

        s2.setProfessor(p2);

        s2.setAge(88);//这里是基本数据类型

        s2.setName("Wu");//这里是基本数据类型

        System.out.println("修改前 ："+s1);

        System.out.println("修改后 ："+s2);

    }

}

class Student implements Cloneable{

    private String name;

    private int age;

    private Professor professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override

    protected Object clone()throws CloneNotSupportedException{
        Student newStudent=(Student) super.clone();

        newStudent.professor=(Professor) professor.clone();

        return newStudent;

    }

}

class Professor implements Cloneable{

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();

    }
}
//
//发现问题，当修改p2的时候，p1也跟着变了，是因为p1和p2指向的是同一个对象，所以clone的是引用。
//
//        深拷贝



