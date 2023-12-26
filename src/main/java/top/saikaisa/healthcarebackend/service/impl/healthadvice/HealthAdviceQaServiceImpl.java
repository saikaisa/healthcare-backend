package top.saikaisa.healthcarebackend.service.impl.healthadvice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceQa;
import top.saikaisa.healthcarebackend.service.healthadvice.HealthAdviceQaService;
import top.saikaisa.healthcarebackend.mapper.HealthAdviceQaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Saikai
* @description 针对表【health_advice_qa(问答)】的数据库操作Service实现
* @createDate 2023-12-26 18:13:52
*/
@Service
public class HealthAdviceQaServiceImpl extends ServiceImpl<HealthAdviceQaMapper, HealthAdviceQa>
    implements HealthAdviceQaService{

    @Override
    public List<HealthAdviceQa> getQa(int qaNum) {
        QueryWrapper<HealthAdviceQa> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("ORDER BY RAND() LIMIT " + qaNum);
        return list(queryWrapper);
    }
}




