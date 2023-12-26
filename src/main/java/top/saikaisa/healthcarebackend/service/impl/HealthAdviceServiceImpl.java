package top.saikaisa.healthcarebackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.saikaisa.healthcarebackend.model.HealthAdvice;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceArticles;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceQa;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceTips;
import top.saikaisa.healthcarebackend.service.HealthAdviceService;
import top.saikaisa.healthcarebackend.service.healthadvice.HealthAdviceArticlesService;
import top.saikaisa.healthcarebackend.service.healthadvice.HealthAdviceQaService;
import top.saikaisa.healthcarebackend.service.healthadvice.HealthAdviceTipsService;

import java.util.List;

@Service
public class HealthAdviceServiceImpl implements HealthAdviceService {

    @Resource
    private HealthAdviceArticlesService healthArticleService;

    @Resource
    private HealthAdviceQaService healthAdviceQaService;

    @Resource
    private HealthAdviceTipsService healthAdviceTipsService;

    @Override
    public HealthAdvice getHealthAdvice(int articlesNum, int qaNum, int tipsNum) {
        // 获取文章，问答，小贴士列表
        List<HealthAdviceArticles> articlesList = healthArticleService.getArticles(articlesNum);
        List<HealthAdviceQa> qaList = healthAdviceQaService.getQa(qaNum);
        List<HealthAdviceTips> tipsList = healthAdviceTipsService.getTips(tipsNum);

        // 将三种列表封装到 HealthAdvice 对象中
        HealthAdvice healthAdvice = new HealthAdvice();
        healthAdvice.setArticles(articlesList);
        healthAdvice.setQa(qaList);
        healthAdvice.setTips(tipsList);

        return healthAdvice;
    }
}
