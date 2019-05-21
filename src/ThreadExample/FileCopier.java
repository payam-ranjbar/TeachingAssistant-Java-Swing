package ThreadExample;

import javax.swing.*;
import java.io.*;

public class FileCopier {

    public String originalFilePath;

    public String dstFilePath;

    public FileCopier(String origin, String dst) {
        originalFilePath = origin;
        dstFilePath = dst;

    }

    public void copy() throws IOException {



        File dstFile = new File(dstFilePath);

        if (!dstFile.exists()) {
            dstFile.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(dstFile);

        FileInputStream in = new FileInputStream(originalFilePath);
        int b = in.read();
        while (b!= -1) {
            out.write(b);
            b = in.read();
        }

        out.close();
        in.close();


    }


    public static void main(String[] args) {
//        GUI gui = new GUI();
//        System.out.println("gui ran");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();

            }
        });

        System.out.println("gui ran");
    }
}
