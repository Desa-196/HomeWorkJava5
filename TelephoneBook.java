import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneBook{

    //Хранит пары ключ(Фамилия) и значение(список номеров)
    private HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public void add(String name, int number){
        //Если в map уже есть такая фамилия, проверим есть ли уже в его списке номеров номер который пытаемся добавить и если есть то ничего не делаем
        if(map.containsKey(name) && !map.get(name).contains(number)){
            map.get(name).add(number);
        }
        //Если записи нет, добавляем
        else if(!map.containsKey(name)){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(number);
            map.put(name, list);
        }
    }
    //Удаляет запись целиком
    public void removeRecord(String name){
        //Если такая запись существует удаляем её, в противном случае ничего не делаем.
        if(map.containsKey(name)) map.remove(name);
    }
    public void removeNumber(String name, int number){

    }

    public String toString(){
        return map.toString();
    }
}