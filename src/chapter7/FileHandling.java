package chapter7;


import chapter8.User;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    private static final String string_data = "Hello World Java";
    private static final User u = new User(2, "sumit");
	private static final chapter7.User user = new chapter7.User(1, "sumit", 25);
    private final static File file = new File("E:\\CoreJava\\src\\chapter7\\txt\\Data.txt"), file2 = new File("E:\\CoreJava\\src\\chapter7\\txt\\Data2.txt");
    private final static FileStreamDemo filedemo = new FileStreamDemo();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StringBuffer sb = null;
        int choice = 0;
        System.out.println("-------------------------------------------------------------------");
        System.out.println("\t\t File Handling Demo");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter the choice Below:\n" +
                "1. File Write\n" +
                "2. File Read\n" +
				"3. Seq Read\n" +
				"4. Obj to file" + "\n" +
				"5. object reader" + "\n" +
				"6. Data append on file");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Writing Started");
                System.out.println("-------------------------------------------------------------------");
                filedemo.fileoutputstream(file, u.toString());
                break;
            case 2:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Reading Started");
                System.out.println("-------------------------------------------------------------------");
    
                try {
                    sb = filedemo.fileinputstream(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\t\t File Data: \n" + sb);
                break;
            case 3:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Reading Started");
                System.out.println("-------------------------------------------------------------------");
                try {
                    sb = filedemo.seqinputstream(file2, file);
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("\t\t File Writing Started");
                    System.out.println("-------------------------------------------------------------------");
                    filedemo.fileoutputstream(file, sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\t\t File Data: \n" + sb);
                break;
			case 4:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t Object to File Writing Started");
				System.out.println("-------------------------------------------------------------------");
				filedemo.transferObject(user, file);
				System.out.println("success");
				break;
			case 5:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t Object to File Writing Started");
				System.out.println("-------------------------------------------------------------------");
				chapter7.User user = filedemo.readObject(file);
				System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());
				System.out.println("success");
				break;
			case 6:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t File append");
				System.out.println("-------------------------------------------------------------------");
				filedemo.fileWriterWithAppend(file, u.toString());
				System.out.println("success");
				break;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }
}
