//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Задание 2
        Task.PhoneDirectory directory = Task.PhoneDirectory.createDirectory();
        //вывод всех
        System.out.println("Весь справочник:");
        directory.printAll();
        System.out.println();
        //поиск по фамилии
        System.out.println("Телефоны Иванова:");
        System.out.println("Иванов: " + directory.get("Иванов"));

        //Задание 1
        System.out.println();
        Task.StudentManagement.data();
    }
}