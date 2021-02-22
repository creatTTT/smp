package com.tu.demo_s_mp.util.texUtil;

/**
 * Created by Administrator on 2020/6/10 0010.
 * 数学填空题实体
 */
public class FillBlankQuestionEntity{

    private int no;
    private String stem;
    private String[] answer;
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

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
