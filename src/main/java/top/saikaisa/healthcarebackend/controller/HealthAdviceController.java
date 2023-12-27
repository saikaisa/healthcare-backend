package top.saikaisa.healthcarebackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.saikaisa.healthcarebackend.model.HealthAdvice;
import top.saikaisa.healthcarebackend.service.HealthAdviceService;

/**
 * @Author Saikai
 * @description 健康建议接口
 * @createDate 2023-12-26 17:16:23
 */
@RestController     // 适用于编写 restful 风格的 api，返回值默认为 json 类型
@RequestMapping("/advice")
public class HealthAdviceController {
    @Resource
    private HealthAdviceService healthAdviceService;

    /**
     * 获取健康建议
     * @return 健康建议
     */
    @GetMapping("/get")
    public HealthAdvice getRandomAdvice() {
        int articlesNum = 5;
        int qaNum = 4;
        int tipsNum = 10;
        return healthAdviceService.getHealthAdvice(articlesNum, qaNum, tipsNum);
    }
}
