package com.tu.demo_s_mp.util.texUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2020/6/12 0012.
 */
public class CommonUtil {

    /**
     * tex图片
     */
    private static final String PICTUREMODULE="\\\\quad\\\\includegraphics{pictureName_pictureName}";


    /**
     * 生成.tex文件
     * @param paper 试卷的字符串
     * @param path 生成后的路径
     * @return
     */
    public static String writePaperTex(String paper,String path){

        String paperName= UUID.randomUUID().toString();
        String paperPath=path+"/"+paperName+".tex";

        File f=new File(paperPath);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(paperPath));
            //一次写一行
            bw.write(paper);
            bw.newLine(); //换行用
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("tex 文件所在的位置："+paperPath);
        return paperPath;
    }


    /**
     * 将内容里的img标签转换成tex文件的图片标签
     * @param content 内容
     * @return 转换后的字符串
     */
    public static String picturePathConverter(String content){
        String result=content;
        boolean contentPicture=Pattern.matches(".*<img.*?src=.*>.*",content);

        if(!contentPicture){
            return content;
        }else {
            List<String> pictureNameList=new ArrayList<>();
            Pattern pattern = Pattern.compile("src=\".*?\"");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                pictureNameList.add(matcher.group());
            }

            String m=PICTUREMODULE;
            result=result.replaceAll("<img(.*?)src=\\\"(.*?)>",m);

            for(int i=0;i<pictureNameList.size();i++){
                result=result.replaceFirst("pictureName_pictureName",pictureNameList.get(i).replace("src=\"","").replace("\"",""));
            }
            return result;
        }
    }


    /**
     * 获得内容的byte长度，主要为了选择题选项的排版
     * UTF-8 这里规定一个中文字符是3个byte，一个英文字符是1个byte
     * 这里规定一个letex代码长15byte，一张图片为24byte
     * @param content 内容
     * @return 内容的byte长度
     */
    public static int contentLength(String content){

        int length=0;
        //去掉填答案的()
        String temp=content.replaceAll("[(]\\s*[)]","");

        if(temp.matches(".*\\\\[(].*\\\\[)].*")){
            int count=0;
            Pattern pattern = Pattern.compile("\\\\[(].*?\\\\[)]");
            Matcher matcher = pattern.matcher(temp);
            while (matcher.find()) {
                count++;
            }
            length=length+15*count;
            temp=temp.replaceAll("\\\\[(].*?\\\\[)]","");
        }

        if(temp.matches(".*<img.*?src=.*>.*")){
            int count=0;
            Pattern pattern = Pattern.compile("<img(.*?)src=(.*?)>");
            Matcher matcher = pattern.matcher(temp);
            while (matcher.find()) {
                count++;
            }
            length=length+24*count;
            temp=temp.replaceAll("<img(.*?)src=(.*?)>","");
        }

        length=length+temp.getBytes().length;

        return length;
    }


    public boolean choiceQuestionCheck(ChoiceQuestionEntity cqe){
        int length=cqe.getChoices().length;
        if(length<3 || length>6){//选择题只支持2-6个选项
            return false;
        }
        return true;
    }

    public boolean fillBlankQuestionCheck(FillBlankQuestionEntity fqe){
        return true;
    }

    public boolean SubjectiveQuestionCheck(SubjectiveQuestionEntity sqe){
        return true;
    }
}
