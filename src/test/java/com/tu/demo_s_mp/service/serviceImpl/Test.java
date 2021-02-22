package com.tu.demo_s_mp.service.serviceImpl;

import com.tu.demo_s_mp.util.texUtil.ChoiceQuestionEntity;
import com.tu.demo_s_mp.util.texUtil.FillBlankQuestionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2020/6/9 0009.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ChoiceQuestionEntity entity=new ChoiceQuestionEntity();
        entity.setStem("某小组6名同学的身高情况如下表，平均身高是( )cm。\\( \\displaystyle \\frac{1}{1\\times 2}+\\frac{1}{2\\times 3}+\\frac{1}{3\\times 4}+\\cdots +\\frac{1}{2018\\times 2019}\\)=( )。");
        String[] options={"\\( \\displaystyle \\frac{1}{1\\times 2}+\\frac{1}{2\\times 3}+\\frac{1}{3\\times 4}+\\cdots +\\frac{1}{2018\\times 2019}\\)=( )。","46","aa<img height=\"33\" id=\"rId7\" src=\"../../images/98-01-06-13.files/5d2ba1ab-8a8a-4b47-8771-2a2718c83cdfimage1.png\" width=\"283\">"};
        entity.setChoices(options);
        entity.setAnswer("A");
        entity.setRemark("设有\\( x\\)辆汽车，用第一种方案表示这批货物的吨数是(\\( 4x+2\\))吨，用第二种方案表示这批货物的吨数是(\\( 5x-3\\))吨。根据两种方案，货物的总吨数不变，列方程为\\( 4x+2=5x-3\\)，" +
                "解得\\( x=5\\)，即有5辆汽车，那么这批货物一共有4×5＋2＝22(吨)； 故选B。");

        ChoiceQuestionEntity entity2=new ChoiceQuestionEntity();
        entity2.setStem("如果每辆装4吨，就还有2吨货物不能被运走；如果每辆装5吨，装完这批货物后，其中一辆车还差3吨装满，这批货物有(   )吨。");
        String[] options2={"<img height=\"33\" id=\"rId7\" src=\"../../images/98-01-06-13.files/5d2ba1ab-8a8a-4b47-8771-2a2718c83cdfimage1.png\" width=\"283\">","1000","<img height=\"33\" id=\"rId7\" src=\"../../images/98-01-06-13.files/5d2ba1ab-8a8a-4b47-8771-2a2718c83cdfimage1.png\" width=\"283\">","9090"};
        entity2.setChoices(options2);
        entity2.setAnswer("B");
        entity2.setRemark("设有\\( x\\)辆汽车，用第一种方案表示这批货物的吨数是(\\( 4x+2\\))吨，用第二种方案表示这批货物的吨数是(\\( 5x-3\\))吨。根据两种方案，货物的总吨数不变，列方程为\\( 4x+2=5x-3\\)，" +
                "解得\\( x=5\\)，即有5辆汽车，那么这批货物一共有4×5＋2＝22(吨)； 故选B。");

        List<ChoiceQuestionEntity> qs=new CopyOnWriteArrayList<>();
        qs.add(entity);
        qs.add(entity2);

        FillBlankQuestionEntity fe1=new FillBlankQuestionEntity();
        fe1.setStem("橘子数学的网址是_________, 一根绳子长\\( \\dfrac{6}{7}\\)米,橘子数学的微信公众号是_________.");
        String[] answer={"iioioi","\\( \\dfrac{6}{7}\\)"};
        fe1.setAnswer(answer);
        fe1.setRemark("qwqwr柔荑花$\\ln{x}$.");


        FillBlankQuestionEntity fe2=new FillBlankQuestionEntity();
        fe2.setStem("：计算______：\\( \\dfrac{1}{8}\\times \\dfrac{1}{8}\\div \\dfrac{1}{8}\\times \\dfrac{1}{8}\\)oiehnoig_______");
        String[] answer2={"\\( \\dfrac{1}{8}\\)","\\( \\dfrac{1}{64}\\)"};
        fe2.setAnswer(answer2);
        fe2.setRemark("在没有括号的算式里，如果只含有加、减法或乘、除法，要按照从");

        /*SubjectiveQuestionEntity entity=new SubjectiveQuestionEntity();
        entity.setStem("计算：\\( \\dfrac{1}{8}\\times \\dfrac{1}{8}\\div \\dfrac{1}{8}\\times \\dfrac{1}{8}\\)");
        String[] subquestion={"a哦if你hi你附体opt。","偶然他覅合同。"};
        entity.setSubQuestion(subquestion);
        entity.setRemark("evigoprogvi2mprimbjihpti");*/


        //MakeTexToPdfUtil util=new MakeTexToPdfUtil();
        //util.makePdfPaperOnlyChoiceQuestion(qs,true,"标题","","","","");


        /*try {
            Runtime.getRuntime().exec("xelatex.exe -synctex=1 -interaction=nonstopmode \"36\".tex",
                    null,
                                    new File("C:\\Users\\Administrator\\Desktop\\Tex\\"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        String s="分数单位是\\( \\displaystyle \\frac{1}{8}\\)的最大真分数是( )，它至少再添上( )\\( \\displaystyle \\frac{1}{8}\\)个这样的分数单位就成了假分数。";

        List<String> list=new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\\\[(].*?\\\\[)]");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            list.add(matcher.group().trim());
        }
        for(String ss:list){
            int len=ss.length();
            System.out.println(ss.substring(2,len-2));
        }
        String[] arr=list.toArray(new String[0]);
        System.out.println(arr.toString());

        //String[] command = { "cmd", "/c", "xelatex.exe -synctex=1 -interaction=nonstopmode C:\\Users\\Administrator\\Desktop\\Tex\\72.tex"};
        //String[] envp = new String[] {"path=D:\\MiKTeX 2.9\\miktex\\bin\\x64\\"};

        //System.out.println("------"+a);
    }

}
