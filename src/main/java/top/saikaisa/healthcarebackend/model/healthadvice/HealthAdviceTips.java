package top.saikaisa.healthcarebackend.model.healthadvice;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 小贴士
 * @TableName health_advice_tips
 */
@TableName(value ="health_advice_tips")
@Data
public class HealthAdviceTips implements Serializable {
    /**
     * 小贴士id
     */
    @TableId(type = IdType.AUTO)
    private Integer tipsId;

    /**
     * 内容
     */
    private String content;

    @TableField(exist = false)
    private static final long serialVersionUID = 6620802529653513180L;

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
        HealthAdviceTips other = (HealthAdviceTips) that;
        return (this.getTipsId() == null ? other.getTipsId() == null : this.getTipsId().equals(other.getTipsId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTipsId() == null) ? 0 : getTipsId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tipsId=").append(tipsId);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
