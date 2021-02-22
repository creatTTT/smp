package com.tu.demo_s_mp.service.serviceImpl;

import java.io.*;

/**
 * Created by Administrator on 2020/6/16 0016.
 */
public class Exetex {

    public static void main(String[] args) {
        try {

            File dir = new File("D:\\");
            // create a process and execute notepad.exe and currect environment
            Process proc = Runtime.getRuntime().exec("lantern-installer.exe",null, dir);

            // any error message?
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");

            // any output?
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");

            // kick them off
            errorGobbler.start();
            outputGobbler.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

 class StreamGobbler extends Thread {
    InputStream is;
    String type;

    StreamGobbler(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null)
                System.out.println(type + ">" + line);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}