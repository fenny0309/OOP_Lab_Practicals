import java.io.*;
import java.util.Date;

public class PR17 {

    
    static void showProperties(File f) {

        System.out.println("\n--- File Properties ---");
        System.out.println("File Name: " + f.getName());
        System.out.println("Absolute Path: " + f.getAbsolutePath());

        if (f.exists()) {
            System.out.println("File Size: " + f.length() + " bytes");
            System.out.println("Readable: " + f.canRead());
            System.out.println("Writable: " + f.canWrite());
            System.out.println("Last Modified: " + new Date(f.lastModified()));
        } else {
            System.out.println("File does not exist.");
        }
    }

   
    static void copyFile(String src, String dest) throws IOException {

        FileInputStream fin = new FileInputStream(src);
        FileOutputStream fout = new FileOutputStream(dest);

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = fin.read(buffer)) != -1) {
            fout.write(buffer, 0, bytesRead);
        }

        fin.close();
        fout.close();

        System.out.println("File copied successfully.");
        showProperties(new File(dest));
    }

    
    static void deleteFile(String fileName) {

        File f = new File(fileName);

        if (f.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File deletion failed.");
        }

        showProperties(f);
    }

   
    static void renameFile(String oldName, String newName) {

        File f1 = new File(oldName);
        File f2 = new File(newName);

        if (f1.renameTo(f2)) {
            System.out.println("File renamed successfully.");
            showProperties(f2);
        } else {
            System.out.println("Rename failed.");
            showProperties(f1);
        }
    }

    
    public static void main(String[] args) {

        try {

            if (args.length == 0) {
                System.out.println("No command provided!");
                return;
            }

            String cmd = args[0];

            switch (cmd) {

                case "copy":
                    if (args.length != 3) {
                        System.out.println("Usage: copy <source> <destination>");
                        return;
                    }
                    copyFile(args[1], args[2]);
                    break;

                case "delete":
                    if (args.length != 2) {
                        System.out.println("Usage: delete <filename>");
                        return;
                    }
                    deleteFile(args[1]);
                    break;

                case "rename":
                    if (args.length != 3) {
                        System.out.println("Usage: rename <oldname> <newname>");
                        return;
                    }
                    renameFile(args[1], args[2]);
                    break;

                default:
                    System.out.println("Invalid command!");
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/* Output: 

C:\Users\Mahadev> F:

F:\>cd OOP_lab_practicals

F:\OOP_lab_practicals>javac PR18.java

F:\OOP_lab_practicals>java PR18 copy input.txt output.txt
File copied successfully.

--- File Properties ---
File Name: output.txt
Absolute Path: F:\OOP_lab_practicals\output.txt
File Size: 42 bytes
Readable: true
Writable: true
Last Modified: Sun Apr 26 16:42:34 IST 2026

F:\OOP_lab_practicals>java PR18 delete test.txt
File deleted successfully.

--- File Properties ---
File Name: test.txt
Absolute Path: F:\OOP_lab_practicals\test.txt
File does not exist.

F:\OOP_lab_practicals>java PR18 rename old.txt new.txt
File renamed successfully.

--- File Properties ---
File Name: new.txt
Absolute Path: F:\OOP_lab_practicals\new.txt
File Size: 26 bytes
Readable: true
Writable: true
Last Modified: Sun Apr 26 16:39:09 IST 2026
*/