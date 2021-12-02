package ru.yuriys.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileSearchApp {
    public static void main(String[] args) {
        ArrayList<File> fileArrayList = new ArrayList<>();
        searchFile(new File("C:\\Users\\User"), fileArrayList);
        for (File file: fileArrayList){
            System.out.println(file.getAbsolutePath());
        }

    }

    public static void searchFile(File rootFile, List<File> fileList){
        //Если rootFile не является директорией
        if (rootFile.isDirectory()){                                                //Если файл - директория
            System.out.println("serching  at: " + rootFile.getAbsolutePath());      // Вывести имя директории
            File[] directoryFiles = rootFile.listFiles();                           // Создать список из элементов директории
            if (directoryFiles!=null){                                              // Если список не пуст
                for (File file:directoryFiles){                                     // Сканируем в цикле
                    if (file.isDirectory()){                                        // Если элемент списка директория делаем рекурсивный вызов
                        searchFile(file, fileList);                                 // поиск в новой директории
                    } else {                                                        // Если элемент - файл
                        if (file.getName().toLowerCase().endsWith(".jpg")){          // Проверяем на соответсвие условию поиска
                            fileList.add(file);                                     // Если соответсвует добавляем в список файлов
                        }
                    }
                }
            }
        }

    }
}

