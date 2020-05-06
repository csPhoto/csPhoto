/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package son.Main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author jampho
 */
public class WriteFile {
    private String path;
    private String content;

    public WriteFile() {
    }

    public WriteFile(String path, String content) {
        this.path = path;
        this.content = content;
    }
    
    public void Write(){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(path), true);
            String s[] = content.split("\n");
            for (int i = 0; i < s.length; i++) {
                String st = s[i];
                pw.print(st + "\r\n");
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
