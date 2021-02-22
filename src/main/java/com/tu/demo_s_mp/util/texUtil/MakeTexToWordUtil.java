package com.tu.demo_s_mp.util.texUtil;

import java.util.List;

/**
 * Created by Administrator on 2020/6/12 0012.
 *
 * 生成word文档直接拼接进tex
 * 使用pandoc工具转成word文件
 */
public class MakeTexToWordUtil {

    /**
     * 用于生成word的内容需要手动拼接。
     * 模板
     */
    private final String WORD_TEMPLATE="\\documentclass [UTF8]{ctexart}\n" +
                                        "\\usepackage{graphicx}\n" +
                                        "\\pagestyle{plain}\n" +
                                        "\\linespread{1.5}\n" +
                                        "\\setlength{\\parindent}{0pt}\n" +
                                        "\\begin {document}\n"+
                                        "\\title{title_title}\n" +
                                        "\\date{date_date}\n" +
                                        "\\maketitle\n"+
                                        "result_result \n"+
                                        "\\end{document}\n";

    private final String PICTUREMODULE="\\\\quad\\\\includegraphics{pictureName_pictureName}";

    private final String TITLEMODULE="\\begin{center}\\Large{title_title}\\end{center}\n";


    private String tagPath;

    public void setTagPath(String path){
        this.tagPath=path;
    }

    /**
     *
     * @param choiceQuestions 选择题list
     * @param title 试卷标题（最好给出）
     * @param date 日期
     * @param needRemark 是否需要答案，解析?
     * @return 生成tex文件所在的路径
     */
    public String makeWordPaperOnlyChoiceQuestion(List<ChoiceQuestionEntity> choiceQuestions,String title,String date,boolean needRemark) {
        StringBuffer sb=new StringBuffer();
        String paper=WORD_TEMPLATE;
        if(title==null || title.equals("")){
            paper=paper.replace("title_title","");
        }else{
            paper=paper.replace("title_title",title);
        }
        if(date==null || date.equals("")){
            paper=paper.replace("date_date","");
        }else{
            paper=paper.replace("date_date",date);
        }
        for(int i=0;i<choiceQuestions.size();i++){
            sb.append(makeChoiceQuesionParagraph(choiceQuestions.get(i),i+1,needRemark));
        }
        paper=paper.replace("result_result",sb.toString());
        String path=CommonUtil.writePaperTex(paper,"src/main/resources/templates");
        return path;
    }

    /**
     * 现在只能应对选项长度比较平均的情况
     * @param entity 选择题实体
     * @param no 题号
     * @param needRemark 是否需要答案，解析？
     * @return 一道选择题段落
     */
    public String makeChoiceQuesionParagraph(ChoiceQuestionEntity entity,int no,boolean needRemark){
        StringBuffer paragraph=new StringBuffer();
        paragraph.append(no+". ").append(CommonUtil.picturePathConverter(entity.getStem())+"\\\\\n");

        /**
         * 生成的word一行能显示33个中文字，99byte。
         */
        int choiceCount=entity.getChoices().length;
        int choiceALength=0;
        int choiceBLength=0;
        int choiceCLength=0;
        int choiceDLength=0;
        for(int i=0;i<choiceCount;i++){
            if(i==0){
                choiceALength=CommonUtil.contentLength(entity.getChoices()[i]);
            }else if(i==1){
                choiceBLength=CommonUtil.contentLength(entity.getChoices()[i]);
            }else if(i==2){
                choiceCLength=CommonUtil.contentLength(entity.getChoices()[i]);
            }else if(i==3){
                choiceDLength=CommonUtil.contentLength(entity.getChoices()[i]);
            }
        }
        int choiceLengthCount=0;
        for(String s:entity.getChoices()){
            choiceLengthCount+=CommonUtil.contentLength(s);
        }
        double averageLength=(double)choiceLengthCount/(double)choiceCount;

        if(choiceCount==2 && averageLength<=39){//两个选项在一行
            for (int i=0;i<entity.getChoices().length;i++){
                if(i==0){
                    paragraph.append("A. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==1){
                    paragraph.append("B. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim());
                }
            }
        }else if(choiceCount==2 && averageLength>39){//两个选项分两行
            for (int i=0;i<entity.getChoices().length;i++){
                if(i==0){
                    paragraph.append("A. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 \\\\\n");
                }else if(i==1){
                    paragraph.append("B. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim());
                }
            }
        }else if(choiceCount==3 && averageLength<=22){//三个选项在一行
            for (int i=0;i<entity.getChoices().length;i++){
                if(i==0){
                    paragraph.append("A. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==1){
                    paragraph.append("B. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==2){
                    paragraph.append("C. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim());
                }
            }
        }else if(choiceCount==3 && averageLength>22 && averageLength<=34.5){
            for (int i=0;i<entity.getChoices().length;i++){
                if(i==0){
                    paragraph.append("A. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==1){
                    paragraph.append("B. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 \\\\\n");
                }else if(i==2){
                    paragraph.append("C. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim());
                }
            }
        }else if(choiceCount==3 && averageLength>34.5){
            for (int i=0;i<entity.getChoices().length;i++){
                if(i==0){
                    paragraph.append("A. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 \\\\\n");
                }else if(i==1){
                    paragraph.append("B. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 \\\\\n");
                }else if(i==2){
                    paragraph.append("C. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim());
                }
            }
        }else if(choiceCount==4 && averageLength<=14){
            for (int i=0;i<entity.getChoices().length;i++){
                if(i==0){
                    paragraph.append("A. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==1){
                    paragraph.append("B. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==2){
                    paragraph.append("C. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==3){
                    paragraph.append("D. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim());
                }
            }
        }else if(choiceCount==4 && averageLength>14 && averageLength<=39.5){
            for (int i=0;i<entity.getChoices().length;i++){
                if(i==0){
                    paragraph.append("A. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==1){
                    paragraph.append("B. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 \\\\\n");
                }else if(i==2){
                    paragraph.append("C. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 ");
                }else if(i==3){
                    paragraph.append("D. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim());
                }
            }
        }else if(choiceCount==4 && averageLength>39.5){
            for (int i=0;i<entity.getChoices().length;i++){
                if(i==0){
                    paragraph.append("A. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 \\\\\n");
                }else if(i==1){
                    paragraph.append("B. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 \\\\\n");
                }else if(i==2){
                    paragraph.append("C. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim()+"　　 \\\\\n");
                }else if(i==3){
                    paragraph.append("D. "+CommonUtil.picturePathConverter(entity.getChoices()[i]).trim());
                }
            }
        }
        paragraph.append("\\\\\n");
        if(needRemark){
            if(entity.getAnswer()!=null || !entity.getAnswer().equals("")){
                paragraph.append("答案：").append(CommonUtil.picturePathConverter(entity.getAnswer())+"\\\\\n");
            }
            if(entity.getRemark()!=null ||entity.getRemark().equals("")){
                paragraph.append("解析：").append(CommonUtil.picturePathConverter(entity.getRemark()).replace("####","")+"\\\\\n");
            }
        }
        paragraph.append("\\\\\n");
        return paragraph.toString();
    }

    /**
     *
     * @param entity
     * @param no
     * @param needRemark
     * @return
     */
    public String makeFillBlankQuestionParagraph(FillBlankQuestionEntity entity,int no,boolean needRemark){
        return "";
    }

    /**
     *
     * @param entity
     * @param no
     * @param needRemark
     * @return
     */
    public String makeSubjectiveQuestionParagraph(SubjectiveQuestionEntity entity,int no,boolean needRemark){
        return "";
    }


}
