import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;

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
    //Удаляет номер телефона у определенной записи
    public void removeNumber(String name, int number){
        //Если запись существует и у нее есть такой номер
        if(map.containsKey(name) && map.get(name).contains(number)){
            map.get(name).removeIf(value -> value == number);
        }
    }
    //Возвращает список телефонов записи по фамилии
    public ArrayList<Integer> getTelephoneNumber(String name){
        return map.get(name);
    }

    public String getAllTelephoneBook(){
        StringBuilder stringBuilder = new StringBuilder();
        //Создаем компаратор и присваиваем ему лямбда выражение с алгоритмом сравнения, он принимает два списка и возвращает 0 если они равны
        // отрицательное число если второй меньше и положительное если второй больше
        Comparator<ArrayList<Integer>> bySize = ( ArrayList<Integer> obj1, ArrayList<Integer> obj2) -> {
           return  obj2.size() - obj1.size();
        };

        //Передаем компаратор в сортировку и получаем отсортированный Затем с помощью forEach и переданной в него лямбды наполняем stringBuilder 
        map.entrySet().stream().sorted(Map.Entry.<String, ArrayList<Integer>>comparingByValue(bySize)).collect(Collectors.toList()).
        forEach(p->{
            stringBuilder.append(p.getKey());
            stringBuilder.append(p.getValue().toString());
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();

        
    }

    public String toString(){
        return map.toString();
    }
}