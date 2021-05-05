package properties_test;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties pro= new Properties();

        try {
            pro.load(new FileInputStream("src/main/java/properties_test/resources/test.properties"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "파일 불러오기 오류 -> " + e);

        }

        String input = JOptionPane.showInputDialog("몇단까지 계산하시겠습니까?");
        int input_to_int = Integer.parseInt(input);

        System.out.println("loading...");
        for(int i=2; i <= input_to_int; i++) {
            System.out.println(i + "단");

            for(int j=1; j <= 10; j++) {

                int q = i*j;
                String to = Integer.toString(q);
                String x = "x";
                System.out.println(i + " x " + j + " = " + i * j);
                pro.setProperty(i +  x  + j , to);

            }

        }
        System.out.println("saveing...");
        try {
            pro.save( new FileOutputStream("src/main/java/properties_test/resources/test.properties"),"");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "파일 불러오기 오류 -> " + e);
        }
        System.out.println("exiting...");
        JOptionPane.showMessageDialog(null, "종료합니다");
        System.exit(0);
    }
}
