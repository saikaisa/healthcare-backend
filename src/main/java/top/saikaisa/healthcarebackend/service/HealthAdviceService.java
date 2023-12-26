package top.saikaisa.healthcarebackend.service;

import top.saikaisa.healthcarebackend.model.HealthAdvice;

public interface HealthAdviceService {

    public HealthAdvice getHealthAdvice(int articlesNum, int qaNum, int tipsNum);

}
