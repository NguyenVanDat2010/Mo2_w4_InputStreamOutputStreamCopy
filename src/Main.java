import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tệp tin input: ");
        String inputStr = scanner.nextLine();
        System.out.print("Nhập tệp tin output: ");
        String outputStr = scanner.nextLine();

        Main myMain = new Main();
        myMain.CopyFile(inputStr, outputStr);
    }

    public void CopyFile(String input, String output) {
        try {
            File fileInput = new File(input);
            File fileOutput = new File(output);
            if (!fileInput.exists() || fileOutput.exists()) {
                throw new FileNotFoundException();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutput));

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileInput));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileOutput));
//            int byteRead;
            int countByte = 0;
            byte[]buffer=new byte[1024];

            while ((bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer);
                countByte++;
            }

            System.out.println("Số byte trong tệp là: " + countByte);

            System.out.println("Copy file thành công");
            bufferedInputStream.close();
            bufferedOutputStream.close();
        } catch (IOException e) {
            System.out.println("File nguồn ko tồn tại hoặc file đích đã có");
        }
    }
}
