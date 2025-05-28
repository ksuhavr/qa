import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class Task {
    //Задание 2
    public static class PhoneDirectory {
        private final HashMap<String, List<String>> directory = new HashMap<>();

        public void add(String lastName, String phoneNumber) {
            directory.putIfAbsent(lastName, new ArrayList<>());
            directory.get(lastName).add(phoneNumber);
        }

        public List<String> get(String lastName) {
            return directory.getOrDefault(lastName, new ArrayList<>());
        }

        public void printAll() {
            for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        public static PhoneDirectory createDirectory() {
            PhoneDirectory directory = new PhoneDirectory();
            directory.add("Иванов", "+375293094286");
            directory.add("Петров", "+375296483992");
            directory.add("Иванов", "+375332894662");
            directory.add("Сидоров", "+375297046286");
            return directory;
        }
    }

    //Задание 1
    public static class StudentManagement {
        public static class Student {
            private String name;
            private String group;
            private int course;
            private List<Integer> grades;

            public Student(String name, String group, int course, List<Integer> grades) {
                this.name = name;
                this.group = group;
                this.course = course;
                this.grades = new ArrayList<>(grades);
            }

            public double getAverageGrade() {
                return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            }

            public void promote() {
                this.course++;
            }

            public String getName() {
                return name;
            }

            public int getCourse() {
                return course;
            }

            @Override
            public String toString() {
                return String.format("%s (%s, курс %d, средний балл %.2f)", name, group, course, getAverageGrade());
            }
        }

        public static void removeUnsuccessfulStudents(Set<Student> students) {
            students.removeIf(student -> student.getAverageGrade() < 3.0);
        }

        public static void promoteSuccessfulStudents(Set<Student> students) {
            students.forEach(student -> {
                if (student.getAverageGrade() >= 3.0) {
                    student.promote();
                }
            });
        }

        public static void printStudents(Set<Student> students, int course) {
            System.out.printf("Студенты %d курса:%n", course);
            students.stream().filter(student -> student.getCourse() == course).forEach(System.out::println);
        }

        public static void data() {
            Set<Student> students = new HashSet<>(Arrays.asList(
                    new Student("Иванов", "Группа1", 1, Arrays.asList(4, 5, 4, 3)),
                    new Student("Петров", "Группа2", 2, Arrays.asList(4, 5, 4, 3)),
                    new Student("Сидоров", "Группа1", 1, Arrays.asList(3, 3, 3, 3)),
                    new Student("Козлов", "Группа3", 2, Arrays.asList(5, 5, 4, 3)),
                    new Student("Шальнов", "Группа3", 2, Arrays.asList(2, 3, 2, 3))
            ));
            //Вывод всех студентов
            System.out.println("Все студенты:");
            students.forEach(System.out::println);

            //Удаление неуспевающих студентов
            removeUnsuccessfulStudents(students);
            System.out.println("\nПосле удаления неуспевающих студентов:");
            students.forEach(System.out::println);

            //Перевод на следующий курс
            promoteSuccessfulStudents(students);
            System.out.println("\nПосле перевода на следующий курс:");
            students.forEach(System.out::println);

            //Вывод студентов по номеру курса
            System.out.println();
            printStudents(students, 2);
        }
    }
}