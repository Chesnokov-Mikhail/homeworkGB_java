import java.text.SimpleDateFormat;
import java.util.*;

/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */
public class task1 {
    public static Map<String, HashMap<String, LinkedList<Integer>>> telephoneBooks = new HashMap<>();

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.M.yyyy", Locale.ENGLISH);
        try {
            addPeople("Иванов", "Иван", "Иванович", formatter.parse("01.01.2000"), "Москва", 235346336);
            addPeople("Петров", "Иван", "Федорович", formatter.parse("01.02.2000"), "Москва", 564577889);
            addPeople("Петров", "Сергей", "Леонидович", formatter.parse("09.02.2005"), "Челябинск", 348632589);
            addPeople("Иванов", "Иван", "Иванович", formatter.parse("01.01.2000"), "Москва", 577567800);
            System.out.println("Петров: ");
            System.out.println(getPeoples("Петров"));
            System.out.println("Иванов: ");
            System.out.println(getPeoples("Иванов"));
            System.out.println(getPeople("Иванов", "Иван", "Иванович", formatter.parse("01.01.2000"),"Москва"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static boolean addPeople(String surname, String name, String patronymic, Date birthday, String address, Integer telefon) {
        // формируем составной ключ person
        String person = String.join(";", name, patronymic, String.format("%1$td.%1$tm.%1$tY", birthday), address);
        // проверяем нахождения в map людей с такой фамилией surname
        if(telephoneBooks.containsKey(surname)) {
            HashMap<String, LinkedList<Integer>> peoplesSurname = telephoneBooks.get(surname);
            // Проверяем нахождение в map человека по составному ключу person
            if (peoplesSurname.containsKey(person)) {
                LinkedList<Integer> telefons = peoplesSurname.get(person);
                // добавляем телефон если его раньше не было у этого человека
                if (!telefons.contains(telefon)) {
                    telefons.add(telefon);
                    peoplesSurname.put(person, telefons);
                    return true;
                }
            // добавляем новую пару (человек, телефон)
            } else {
                LinkedList<Integer> telefons = new LinkedList<>(List.of(telefon));
                peoplesSurname.put(person, telefons);
                return true;
            }
        // добавляем новую пару (фамилия, (человек, телефон))
        } else {
            LinkedList<Integer> telefons = new LinkedList<>(List.of(telefon));
            HashMap<String, LinkedList<Integer>> peoplesSurname = new HashMap<>();
            peoplesSurname.put(person, telefons);
            telephoneBooks.put(surname,peoplesSurname);
            return true;
        }
        return false;
    }

    // получение списка телефона по полным данным человека
    public static String getPeople(String surname, String name, String patronymic, Date birthday, String address) {
        if(telephoneBooks.containsKey(surname)) {
            // формируем составной ключ person
            String person = String.join(";", name, patronymic, String.format("%1$td.%1$tm.%1$tY", birthday), address);
            HashMap<String, LinkedList<Integer>> peoplesSurname = telephoneBooks.get(surname);
            // Проверяем нахождение в map человека по составному ключу person
            if (peoplesSurname.containsKey(person)) {
                LinkedList<Integer> telefons = peoplesSurname.get(person);
                return String.join(": ", String.join(";", surname, person), telefons.toString());
            }
        }
        return null;
    }

    // получение map людей по фамилии
    public static HashMap<String, LinkedList<Integer>> getPeoples(String surname) {
        if(telephoneBooks.containsKey(surname)) {
            return telephoneBooks.get(surname);
        } else {
            HashMap<String, LinkedList<Integer>> peoplesSurname = new HashMap<>();
            peoplesSurname.put(null, null);
            return peoplesSurname;
        }
    }
}
