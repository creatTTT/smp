package com.tu.demo_s_mp.util.texUtil;

/**
 * Created by Administrator on 2020/6/10 0010.
 *
 * 数学解答题实体
 */
public class SubjectiveQuestionEntity{

    private int no;
    private String stem;
    private String[] subQuestion;
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

    public String[] getSubQuestion() {
        return subQuestion;
    }

    public void setSubQuestion(String[] subQuestion) {
        this.subQuestion = subQuestion;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
