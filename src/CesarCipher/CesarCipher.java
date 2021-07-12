package CesarCipher;

import java.io.*;

public class CesarCipher {

    private int key;

    public CesarCipher(int key) {
        this.key = key;
    }

    //encrypt
    public void encrypt(InputStream charIn, OutputStream charOut) throws IOException {
        boolean isDoneReading = false;
        while (!isDoneReading) {
            int next = charIn.read();
            if (next == -1) {
                isDoneReading = true;
            } else {
                byte b = (byte) next;
                byte c = (byte) (b + key);
                charOut.write(c);
            }
        }

    }

    public static void main(String[] args) {

        try {
            InputStream fileInput = new FileInputStream("/Users/Manuel/Documents/Pyramid_Consulting/CesarCipher/src/input.txt");
            OutputStream fileOutput = new FileOutputStream("/Users/Manuel/Documents/Pyramid_Consulting/CesarCipher/src/output.txt");
            CesarCipher cipher = new CesarCipher(3);
            cipher.encrypt(fileInput, fileOutput);
            fileInput.close();
            fileOutput.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        try {
            InputStream fileInputEncrypted = new FileInputStream("/Users/Manuel/Documents/Pyramid_Consulting/CesarCipher/src/output.txt");
            OutputStream fileOutputDecrypted = new FileOutputStream("/Users/Manuel/Documents/Pyramid_Consulting/CesarCipher/src/outputDecrypt.txt");
            CesarCipher cipher = new CesarCipher(-3);
            cipher.encrypt(fileInputEncrypted, fileOutputDecrypted);
            //System.out.println();
            fileInputEncrypted.close();
            fileOutputDecrypted.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }
}
