package top.saikaisa.healthcarebackend.model.healthadvice;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 问答
 * @TableName health_advice_qa
 */
@TableName(value ="health_advice_qa")
@Data
public class HealthAdviceQa implements Serializable {
    /**
     * 问答id
     */
    @TableId(type = IdType.AUTO)
    private Integer qaId;

    /**
     * 问题
     */
    private String question;

    /**
     * 回答
     */
    private String answer;

    @TableField(exist = false)
    private static final long serialVersionUID = 6986385860795292595L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HealthAdviceQa other = (HealthAdviceQa) that;
        return (this.getQaId() == null ? other.getQaId() == null : this.getQaId().equals(other.getQaId()))
            && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQaId() == null) ? 0 : getQaId().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", qaId=").append(qaId);
        sb.append(", question=").append(question);
        sb.append(", answer=").append(answer);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
