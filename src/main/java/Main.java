import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь к CSV: ");
        String path = in.nextLine(); //"/Users/admin/Downloads/java_lab4-main/foreign_names.csv"
        System.out.println("Введите сепаратор: "); // ;
        char separator = in.next().charAt(0);

        ArrayList<Person> fList = fileToList(path, separator);
        int size = fList.size();
        for (int i = 0; i < size; i++) { fList.get(i).println(); }
        in.close();
    }

    static ArrayList<Person> fileToList(String path, char separator) {
        ArrayList<Person> fileList = new ArrayList<>();

        File file = new File("foreign_names.csv");
        try (BufferedReader fileLine = new BufferedReader(new FileReader(file))) {
            String line = fileLine.readLine();
            while ((line = fileLine.readLine()) != null) {
                int length = line.length(), cellType = 0, ID = 0;
                String name = "",
                        sex = "",
                        unitName = "",
                        birthday = "",
                        cell = "";
                double salary = 0;
                for (int i = 0; i < length; i++) {
                    if (line.charAt(i) != separator) {
                        cell += line.charAt(i);
                    } else {
                        if (cellType == 0 && ID == 0) {ID = Integer.parseInt(cell);}
                        else if (cellType == 1 && name == "") {name = cell;}
                        else if (cellType == 2 && sex == "") {sex = cell;}
                        else if (cellType == 3 && birthday == "") {birthday = cell;}
                        else if (cellType == 4 && unitName == "") {unitName = cell;}
                        cell = "";
                        cellType++;
                    }
                }
                salary = Integer.parseInt(cell);
                cell = "";
                Person dataPerson = new Person(ID, name, sex, unitName, salary, birthday);
                fileList.add(dataPerson);
            }
        } catch (IOException e) { e.printStackTrace(); }

        return fileList;
    }
}