package top.saikaisa.healthcarebackend.service.impl.healthadvice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceTips;
import top.saikaisa.healthcarebackend.service.advice.HealthAdviceTipsService;
import top.saikaisa.healthcarebackend.mapper.HealthAdviceTipsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Saikai
* @description 针对表【health_advice_tips(小贴士)】的数据库操作Service实现
* @createDate 2023-12-26 18:13:56
*/
@Service
public class HealthAdviceTipsServiceImpl extends ServiceImpl<HealthAdviceTipsMapper, HealthAdviceTips>
    implements HealthAdviceTipsService{

    @Override
    public List<HealthAdviceTips> getTips(int tipsNum) {
        QueryWrapper<HealthAdviceTips> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("ORDER BY RAND() LIMIT " + tipsNum);
        return list(queryWrapper);
    }
}




