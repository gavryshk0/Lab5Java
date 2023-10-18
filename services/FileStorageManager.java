package services;

import models.Credit;

import java.io.*;
import java.util.List;

public class FileStorageManager {
    public void saveCredits(List<Credit> credits, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(credits);
            System.out.println("Кредити успiшно збережено в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Credit> loadCredits(String fileName) {
        List<Credit> credits = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            credits = (List<Credit>) inputStream.readObject();
            System.out.println("Кредити успiшно завантажено з файлу " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return credits;
    }
}
