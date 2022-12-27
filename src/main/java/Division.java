// класс подразделения
public class Division {
    private int ID;
    private String title;
    private static int counter = 1;
    
    // конструктор
    public Division(int _ID, String _title)
    {
        ID = _ID;
        title = _title;
    }
    
    // конструктор
    public Division(String _title)
    {
        ID = 1+(counter++)%26;
        title = _title;
    }
    
    // печатает id, title подразделения
    public void println()
    {
        System.out.println("Unit ID: " + ID + "\nUnit title: " + title);
    }
}
