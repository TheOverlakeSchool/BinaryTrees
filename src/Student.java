import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private int grade;
    public static final Comparator<Student> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();

    public Student(String name, int grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    public String toString(){
        return name;
    }

    public static class CaseInsensitiveComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    }
}
