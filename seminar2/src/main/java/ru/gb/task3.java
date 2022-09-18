package ru.gb;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
 Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */
public class task3 {
    public static void main(String[] args) {
        String pathFile = System.getProperty("user.dir").concat("\\src\\main\\java\\ru\\gb\\task3.json");
        System.out.println(pathFile);
        JSONArray jsonArray = parseJson(pathFile);
        if (jsonArray.isEmpty()) {
            System.out.println("Empty json in file");
        } else {
            StringBuilder strOut = new StringBuilder();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                strOut.append(String.join("","Студент ",
                    item.getString("фамилия"),
                    " получил ",
                    item.getString("оценка"),
                    " по предмету ",
                    item.getString("предмет"),
                    ".\n"));
            }
            System.out.println(strOut.toString());
        }
    }

    public static JSONArray parseJson(String pathFile) {
        StringBuilder in = new StringBuilder();
        try {
            File jf = new File(pathFile);
            BufferedReader bufReader = new BufferedReader(new FileReader(jf));
            try {
                String str = null;
                while ((str = bufReader.readLine()) != null) {
                    in.append(str);
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            } finally {
                bufReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (in.length()>0) {
            JSONArray jsonArray = new JSONArray(in.toString());
            return jsonArray;
        } else {
            return null;
        }
    }
}
