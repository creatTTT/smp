package com.tu.demo_s_mp.util.texUtil;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/6/8 0008.
 * 数学选择题实体
 */
public class ChoiceQuestionEntity{

    private int no;
    private String stem;
    private String[] choices;
    private String answer;
    private String remark;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ChoiceQuestionEntity{" +super.toString()+
                "no=" + no +
                ", stem='" + stem + '\'' +
                ", choices=" + Arrays.toString(choices) +
                ", answer='" + answer + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
