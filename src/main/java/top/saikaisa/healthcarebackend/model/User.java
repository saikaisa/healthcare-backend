package top.saikaisa.healthcarebackend.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像URL
     */
    private String avatarUrl;

    /**
     * 性别，0-男  1-女
     */
    private Integer gender;

    /**
     * 运动步数
     */
    private Integer steps;

    /**
     * 卡路里
     */
    private Integer calories;

    /**
     * 运动时间，单位：分钟
     */
    private Integer exerciseTime;

    /**
     * 睡眠时长，单位：分钟
     */
    private Integer sleepDuration;

    /**
     * 入睡时间，单位：hh:mm:ss
     */
    private Date sleepStartTime;

    /**
     * 醒来时间，单位：hh:mm:ss
     */
    private Date sleepEndTime;

    /**
     * 心率，单位：次/分钟
     */
    private Integer heartRate;

    /**
     * 血氧，单位：%
     */
    private Integer bloodOxygen;

    /**
     * 血压，单位：mmHg
     */
    private Integer bloodPressure;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除，1-已删除
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 8071611933841994347L;

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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getAvatarUrl() == null ? other.getAvatarUrl() == null : this.getAvatarUrl().equals(other.getAvatarUrl()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getSteps() == null ? other.getSteps() == null : this.getSteps().equals(other.getSteps()))
            && (this.getCalories() == null ? other.getCalories() == null : this.getCalories().equals(other.getCalories()))
            && (this.getExerciseTime() == null ? other.getExerciseTime() == null : this.getExerciseTime().equals(other.getExerciseTime()))
            && (this.getSleepDuration() == null ? other.getSleepDuration() == null : this.getSleepDuration().equals(other.getSleepDuration()))
            && (this.getSleepStartTime() == null ? other.getSleepStartTime() == null : this.getSleepStartTime().equals(other.getSleepStartTime()))
            && (this.getSleepEndTime() == null ? other.getSleepEndTime() == null : this.getSleepEndTime().equals(other.getSleepEndTime()))
            && (this.getHeartRate() == null ? other.getHeartRate() == null : this.getHeartRate().equals(other.getHeartRate()))
            && (this.getBloodOxygen() == null ? other.getBloodOxygen() == null : this.getBloodOxygen().equals(other.getBloodOxygen()))
            && (this.getBloodPressure() == null ? other.getBloodPressure() == null : this.getBloodPressure().equals(other.getBloodPressure()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getAvatarUrl() == null) ? 0 : getAvatarUrl().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getSteps() == null) ? 0 : getSteps().hashCode());
        result = prime * result + ((getCalories() == null) ? 0 : getCalories().hashCode());
        result = prime * result + ((getExerciseTime() == null) ? 0 : getExerciseTime().hashCode());
        result = prime * result + ((getSleepDuration() == null) ? 0 : getSleepDuration().hashCode());
        result = prime * result + ((getSleepStartTime() == null) ? 0 : getSleepStartTime().hashCode());
        result = prime * result + ((getSleepEndTime() == null) ? 0 : getSleepEndTime().hashCode());
        result = prime * result + ((getHeartRate() == null) ? 0 : getHeartRate().hashCode());
        result = prime * result + ((getBloodOxygen() == null) ? 0 : getBloodOxygen().hashCode());
        result = prime * result + ((getBloodPressure() == null) ? 0 : getBloodPressure().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", gender=").append(gender);
        sb.append(", steps=").append(steps);
        sb.append(", calories=").append(calories);
        sb.append(", exerciseTime=").append(exerciseTime);
        sb.append(", sleepDuration=").append(sleepDuration);
        sb.append(", sleepStartTime=").append(sleepStartTime);
        sb.append(", sleepEndTime=").append(sleepEndTime);
        sb.append(", heartRate=").append(heartRate);
        sb.append(", bloodOxygen=").append(bloodOxygen);
        sb.append(", bloodPressure=").append(bloodPressure);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
