package ru.geekbrains.lesson5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Backup {
    public static void main(String[] args) {
        String sourceDir = "./";
        String backupDir = "./backup";

        try {
            createBackup(sourceDir, backupDir);
            System.out.println("Backup created successfully!");
        } catch (IOException e) {
            System.out.println("Error creating backup: " + e.getMessage());
        }
    }

    public static void createBackup(String sourceDir, String backupDir) throws IOException {
        File sourceDirectory = new File(sourceDir);
        File backupDirectory = new File(backupDir);

        if (!sourceDirectory.isDirectory()) {
            throw new IllegalArgumentException("Source path is not a directory!");
        }

        if (!backupDirectory.exists()) {
            backupDirectory.mkdirs();
        }

        File[] files = sourceDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    File backupFile = new File(backupDir + "/" + file.getName());
                    copyFile(file, backupFile);
                }
            }
        }
    }

    public static void copyFile(File sourceFile, File destinationFile) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
