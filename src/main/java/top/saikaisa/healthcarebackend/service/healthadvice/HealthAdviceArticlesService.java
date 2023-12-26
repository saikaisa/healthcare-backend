package top.saikaisa.healthcarebackend.service.healthadvice;

import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceArticles;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Saikai
* @description 针对表【health_advice_articles(文章)】的数据库操作Service
* @createDate 2023-12-26 18:13:46
*/
public interface HealthAdviceArticlesService extends IService<HealthAdviceArticles> {

    List<HealthAdviceArticles> getArticles(int articlesNum);
}
