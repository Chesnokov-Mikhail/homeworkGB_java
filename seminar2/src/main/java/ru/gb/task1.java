package ru.gb;

import java.io.File;
import java.nio.file.Path;

/*
Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
1 Расширение файла: txt
2 Расширение файла: pdf
3 Расширение файла:
4 Расширение файла: jpg
*/
public final class task1 {
    public static void main(String[] args) {
        try {
            // File dir = new File(System.getProperty("user.dir"));
            File dir = new File(new File(".\\src\\main\\java\\ru\\gb\\").getAbsolutePath());
            File[] files = dir.listFiles();
            ExtendFile(files);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }    
    }
    
    private static void ExtendFile(File[] listFiles) {
        String nameFile = "";
        String ext = "";
        for (File item : listFiles) {
            if (item.isFile()) {
                nameFile = item.getName();
                int pos = nameFile.lastIndexOf(".");
                if(pos == -1) {
                    ext = "";
                } else {
                    ext = nameFile.substring(pos+1);
                }
                System.out.printf("Расширение файла %s : %s \n", nameFile, ext);
            }
        }    
    }
}
