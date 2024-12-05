import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " (" + grade + ")";
    }
}

public class SortStudents {

    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("Andrey", 85));
        list1.add(new Student("Gosha", 75));
        list1.add(new Student("Dimmmmon", 95));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("David", 90));
        list2.add(new Student("Eva", 80));
        list2.add(new Student("Pooogrom", 70));

        List<Student> mergedList = mergeAndSort(list1, list2);
        System.out.println("Отсортированнный список:");
        for (Student student : mergedList) {
            System.out.println(student);
        }
    }

    public static List<Student> mergeAndSort(List<Student> list1, List<Student> list2) {
        List<Student> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergeSort(mergedList);
    }

    public static List<Student> mergeSort(List<Student> students) {
        if (students.size() <= 1) {
            return students;
        }

        int mid = students.size() / 2;
        List<Student> left = mergeSort(students.subList(0, mid));
        List<Student> right = mergeSort(students.subList(mid, students.size()));

        return merge(left, right);
    }

    public static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).grade <= right.get(j).grade) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }
}
