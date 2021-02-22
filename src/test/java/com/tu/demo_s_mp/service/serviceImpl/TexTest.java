package com.tu.demo_s_mp.service.serviceImpl;

import java.io.*;

/**
 * Created by Administrator on 2020/6/8 0008.
 */
public class TexTest {

    private static final String TEMPLATE="\\documentclass [UTF8]{ctexart}\r\n" +
            "\\usepackage{graphicx}\r\n" +
            "\\setlength{\\parindent}{0pt}\r\n"+
            "\\begin {document}\r\n" +
            "\\end{document}\r\n";

    private static final String PICTUREMODULE_THREE_OPTION="\\begin{figure}[h]\n" +
            "\t\n" +
            "\tA.\\includegraphics[width=0.2\\linewidth]{picture1}\\quad\\quad\\quad\n" +
            "\tB.\\includegraphics[width=0.2\\linewidth]{picture2}\\quad\\quad\\quad\n" +
            "\tC.\\includegraphics[width=0.2\\linewidth]{picture3}\\quad\\quad\\quad\n" +
            "\t\n" +
            "\n" +
            "\\end{figure}";

    private static final String PICTUREMODULE_FORE_OPTION="\\begin{figure}[h]\n" +
            "\t\n" +
            "\tA.\\includegraphics[width=0.23\\linewidth]{picture1}\\quad\\quad\\quad\\quad\\quad\\quad\n" +
            "\tB.\\includegraphics[width=0.23\\linewidth]{picture2}\n" +
            "\t\\\\\n" +
            "\t\\\\\n" +
            "\tC.\\includegraphics[width=0.23\\linewidth]{picture3}\\quad\\quad\\quad\\quad\\quad\\quad\n" +
            "\tD.\\includegraphics[width=0.23\\linewidth]{picture4}\n" +
            "\n" +
            "\\end{figure}";

    private static final String PICTURE_TEXT_ON_ONE_LINE="\\hfill\\includegraphics[width=0.23\\linewidth]{picture}";

    public static void main(String[] args) {

        String content="\r\n1.找规律：\\( \\frac{1}{2}\\)、\\( \\frac{3}{5}\\)、\\( \\frac{8}{13}\\)、\\( \\frac{21}{34}\\)、(   )、……，括号里的分数是(   )。\\\\\r\n";
        String choiceA=" A.\\( \\frac{29}{47}\\)\\quad\\quad";
        String choiceB=" B.\\( \\frac{34}{55}\\)\\quad\\quad";
        String choiceC=" C.\\( \\frac{55}{89}\\)\\\\\r\n";
        String answer="答案：C"+"\\\\\r\n";
        String remark="解析：通过观察发现，后一个分数的分子是前一个分数的分子、分母之和，后一个分数的分母是前一个分数的分母与后一个分数分子的和，" +
                "所以括号里的分数是\\( \\frac{21+34}{34+(21+34)}=\\frac{55}{89}\\)； \\#\\#\\#\\#故选C。\\\\\r\n";

        String finalString=content+choiceA+choiceB+choiceC+answer+remark;

        StringBuffer s=new StringBuffer(TEMPLATE);
        int i=TEMPLATE.indexOf("begin {document}");
        s.insert(i+16,finalString);

        try {
            write(s.toString(),"src/main/resources/templates/template1.tex");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void write(String s,String path) throws IOException {
        //将写入转化为流的形式
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        //一次写一行
        bw.write(s);
        bw.newLine(); //换行用
        //关闭流
        bw.close();
        System.out.println("写入成功");
    }
}
