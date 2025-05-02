import java.io.*;

/**
 * This program performs several file operations: 
 * 1. Lists all files in a specified directory.
 * 2. Renames a file.
 * 3. Calculates the total size of files in a directory.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Specify the directory path
            File directory = new File("C:\\Users\\Esma Şevval Marangoz\\Desktop\\Yeni Klasör");

            // List all files in the directory
            listFilesInDirectory(directory);

            // Rename a file
            File oldFile = new File("test1.txt");
            File newFile = new File("test2.txt");
            renameFile(oldFile, newFile);

            // Calculate and print the total size of the directory
            long folderSize = getFolderSize(directory);
            System.out.println("Total folder size: " + folderSize + " bytes");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to list all files in a directory
    public static void listFilesInDirectory(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            System.out.println("Files in directory:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("The directory is empty or does not exist.");
        }
    }

    // Method to rename a file
    public static void renameFile(File oldFile, File newFile) {
        if (oldFile.exists()) {
            if (oldFile.renameTo(newFile)) {
                System.out.println("File renamed to: " + newFile.getName());
            } else {
                System.out.println("Failed to rename file.");
            }
        } else {
            System.out.println("File does not exist: " + oldFile.getName());
        }
    }

    // Method to calculate the total size of a directory
    public static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else {
                    length += getFolderSize(file);
                }
            }
        }
        return length;
    }
}
