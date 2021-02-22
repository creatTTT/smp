package com.tu.demo_s_mp.service.serviceImpl;

import com.tu.demo_s_mp.util.texUtil.ChoiceQuestionEntity;
import com.tu.demo_s_mp.util.texUtil.FillBlankQuestionEntity;
import com.tu.demo_s_mp.util.texUtil.MakeTexToPdfUtil;
import com.tu.demo_s_mp.util.texUtil.SubjectiveQuestionEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/10 0010.
 */
public class Textword {
    public static void main(String[] args) {

        //MakeTexToWordUtil util=new MakeTexToWordUtil();
        MakeTexToPdfUtil util=new MakeTexToPdfUtil();

        ChoiceQuestionEntity entity=new ChoiceQuestionEntity();
        entity.setStem("下面的计算正确吗？(  ) <img height=\"63\" id=\"rId5\" src=\"images/98-01-06-13.files/5d2ba1ab-8a8a-4b47-8771-2a2718c83cdfimage1.png\" width=\"79\">.某小组6名同学的身高情况如下表，平均身高是( )cm。\\( \\displaystyle \\frac{1}{1\\times 2}+\\frac{1}{2\\times 3}+\\frac{1}{3\\times 4}+\\cdots +\\frac{1}{2018\\times 2019}\\)=( )。");
        String[] options={"789789","46","456456"};
        entity.setChoices(options);
        entity.setAnswer("A");
        entity.setRemark("设有\\( x\\)辆汽车，用第一种方案表示这批货物的吨数是(\\( 4x+2\\))吨，用第二种方案表示这批货物的吨数是(\\( 5x-3\\))吨。根据两种方案，货物的总吨数不变，列方程为\\( 4x+2=5x-3\\)，" +
                "解得\\( x=5\\)，即有5辆汽车，那么这批货物一共有4×5＋2＝22(吨)； 故选B。");

        ChoiceQuestionEntity entity2=new ChoiceQuestionEntity();
        entity2.setStem("某小组6名同学的身高情况如下表，平均身高是( )cm。\\( \\displaystyle \\frac{1}{1\\times 2}+\\frac{1}{2\\times 3}+\\frac{1}{3\\times 4}+\\cdots +\\frac{1}{2018\\times 2019}\\)=( )。");
        String[] options2={"\\( \\frac{3090}{100}\\)\\( \\frac{3090}{100}\\)","\\( \\frac{3090}{100}\\)","\\( \\frac{3090}{100}\\)"};
        entity2.setChoices(options2);
        entity2.setAnswer("A");
        entity2.setRemark("设有\\( x\\)辆汽车，用第一种方案表示这批货物的吨数是(\\( 4x+2\\))吨，用第二种方案表示这批货物的吨数是(\\( 5x-3\\))吨。根据两种方案，货物的总吨数不变，列方程为\\( 4x+2=5x-3\\)，" +
                "解得\\( x=5\\)，即有5辆汽车，那么这批货物一共有4×5＋2＝22(吨)； 故选B。");

        ChoiceQuestionEntity entity3=new ChoiceQuestionEntity();
        entity3.setStem("某小组6名同学的身高情况如下表，平均身高是( )cm。\\( \\displaystyle \\frac{1}{1\\times 2}+\\frac{1}{2\\times 3}+\\frac{1}{3\\times 4}+\\cdots +\\frac{1}{2018\\times 2019}\\)=( )。");
        String[] options3={"然后IG利润华农\\( \\frac{3090}{100}\\)\\( \\frac{3090}{100}\\)","IP唐人街哦朋友镜头膜骗人\\( \\frac{3090}{100}\\)","弄丢了退款回娘家\\( \\frac{3090}{100}\\)"};
        entity3.setChoices(options3);
        entity3.setAnswer("A");
        entity3.setRemark("设有\\( x\\)辆汽车，用第一种方案表示这批货物的吨数是(\\( 4x+2\\))吨，用第二种方案表示这批货物的吨数是(\\( 5x-3\\))吨。根据两种方案，货物的总吨数不变，列方程为\\( 4x+2=5x-3\\)，" +
                "解得\\( x=5\\)，即有5辆汽车，那么这批货物一共有4×5＋2＝22(吨)； 故选B。");

        List<ChoiceQuestionEntity> questions=new ArrayList<>();
        questions.add(entity);
        questions.add(entity2);
        questions.add(entity3);


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

        List<FillBlankQuestionEntity> fs=new ArrayList<>();
        fs.add(fe1);
        fs.add(fe2);

        SubjectiveQuestionEntity s1=new SubjectiveQuestionEntity();
        s1.setStem("faikfi可能佛罗非能佛罗非农能佛罗非农农IBM人非能佛罗非农能佛罗非农能佛罗非农能佛罗非农能佛罗非农能佛罗非农");
        String[] squestion={"1234564646","vgrbft789789","00.0e155vgdrfbrfe[[[[[["};
        s1.setSubQuestion(squestion);
        s1.setRemark("nfbv nodlfn弄弄哦if年河北");

        SubjectiveQuestionEntity s2=new SubjectiveQuestionEntity();
        s2.setStem("2222222222222faikfi可能佛罗非能佛罗非农能佛罗非农农IBM人非能佛罗非农能佛罗非农能佛罗非农能佛罗非农能佛罗非农能佛罗非农");
        String[] squestion2={"1234564646","vgrbft789789","00.0e155vgdrfbrfe[[[[[["};
        s2.setSubQuestion(squestion2);
        s2.setRemark("2222222222nfbv nodlfn弄弄哦if年河北");

        List<SubjectiveQuestionEntity> ss=new ArrayList<>();
        ss.add(s1);
        ss.add(s2);

        String path=util.makePaper(questions,fs,ss,false,"试卷标题","一个副标题","opooooo","123","2020-2-2");

        //String path=util.makeWordPaperOnlyChoiceQuestion(questions,"标题","2020.2.2",true);
        /*String command="pandoc "+path+" -o "+path.replace("tex","docx");
        System.out.println(command);
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try {
            Runtime.getRuntime().exec("pandoc 03.tex -o 03.docx",null,new File("C:\\Users\\Administrator\\Desktop\\Tex"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }


}
