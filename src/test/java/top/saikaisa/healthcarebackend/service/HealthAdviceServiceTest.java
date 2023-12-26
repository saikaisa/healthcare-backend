package top.saikaisa.healthcarebackend.service;

import jakarta.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import top.saikaisa.healthcarebackend.model.HealthAdvice;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceArticles;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceQa;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceTips;
import top.saikaisa.healthcarebackend.service.advice.HealthAdviceArticlesService;

@SpringBootTest
public class HealthAdviceServiceTest {

    @Autowired
    private HealthAdviceArticlesService healthAdviceArticlesService;

    @Resource
    private HealthAdviceService healthAdviceService;

    @Test
    public void testGetArticles() {
        int articlesNum = 5; // 测试获取的文章数量
        List<HealthAdviceArticles> articles = healthAdviceArticlesService.getArticles(articlesNum);
        for (HealthAdviceArticles article : articles) {
            System.out.println(article.getTitle());
        }

        assertNotNull(articles, "The returned list should not be null.");
        assertTrue(articles.size() <= articlesNum, "The returned list should not exceed the requested number of articles.");
    }

    @Test
    public void testGetHealthAdvice() {
        int articlesNum = 5;
        int qaNum = 5;
        int tipsNum = 5;
        HealthAdvice healthAdvice = healthAdviceService.getHealthAdvice(articlesNum, qaNum, tipsNum);

        for (HealthAdviceArticles article : healthAdvice.getArticles()) {
            System.out.println(article.getTitle());
        }
        for (HealthAdviceQa qa : healthAdvice.getQa()) {
            System.out.println(qa.getQuestion());
        }
        for (HealthAdviceTips tip : healthAdvice.getTips()) {
            System.out.println(tip.getContent());
        }


    }
}
