package top.saikaisa.healthcarebackend.model;

import lombok.Data;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceArticles;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceQa;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceTips;

import java.io.Serializable;
import java.util.List;

/**
 * 健康建议
 */
@Data
public class HealthAdvice implements Serializable {

    private static final long serialVersionUID = 312327543298696685L;

    private List<HealthAdviceArticles> articles;
    private List<HealthAdviceQa> qa;
    private List<HealthAdviceTips> tips;
}
