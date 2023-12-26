package top.saikaisa.healthcarebackend.service.impl.healthadvice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceArticles;
import top.saikaisa.healthcarebackend.service.healthadvice.HealthAdviceArticlesService;
import top.saikaisa.healthcarebackend.mapper.HealthAdviceArticlesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Saikai
* @description 针对表【health_advice_articles(文章)】的数据库操作Service实现
* @createDate 2023-12-26 18:13:46
*/
@Service
public class HealthAdviceArticlesServiceImpl extends ServiceImpl<HealthAdviceArticlesMapper, HealthAdviceArticles>
    implements HealthAdviceArticlesService{

    @Override
    public List<HealthAdviceArticles> getArticles(int articlesNum) {
        QueryWrapper<HealthAdviceArticles> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("ORDER BY RAND() LIMIT " + articlesNum);
        return list(queryWrapper);
    }
}




