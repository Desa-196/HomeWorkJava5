import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        TelephoneBook telephoneBook = new TelephoneBook();
        telephoneBook.add("Ponomarev", 3201);
        telephoneBook.add("Ponomarev", 3234);
        telephoneBook.add("Ivanov", 3040);
        telephoneBook.add("Sidorov", 3055);
        telephoneBook.add("Sidorov", 45445434);
        telephoneBook.add("Sidorov", 4534534);
        telephoneBook.add("Sidorov", 98943);
        System.out.println(telephoneBook);
        telephoneBook.removeNumber("Ponomarev", 3034);
        System.out.println(telephoneBook);
        ArrayList<Integer> telephoneList = telephoneBook.getTelephoneNumber("Ponomarev");
        if(telephoneList != null) System.out.println(telephoneList.toString());
        System.out.println(telephoneBook.getAllTelephoneBook());
    }
}
