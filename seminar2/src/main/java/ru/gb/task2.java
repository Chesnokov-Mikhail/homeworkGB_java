package ru.gb;

import org.json.JSONObject;
import java.util.Iterator;

/*
2. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Ответ: "select * from students where name = 'Ivanov' and country = 'Russia' and city = 'Moscow'"
 для приведенного примера
 */
public class task2 {
    public static void main(String[] args) {
        StringBuilder selectText = new StringBuilder("select * from students where ");
        StringBuilder whereText = new StringBuilder("");
        String json = "{name:Ivanov, country:Russia, city:Moscow, age:null}";
        JSONObject jo = new JSONObject("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        String strAnd = "";
        for (Iterator<String> it = jo.keys(); it.hasNext(); ) {
            String key = it.next();
            if (!jo.getString(key).toUpperCase().equals("NULL")) {
                selectText.append(String.join("", strAnd, key, " = '", jo.getString(key), "'"));
                strAnd = " and ";
            }
        }
        System.out.println(selectText);
    }
}
