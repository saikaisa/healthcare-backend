package top.saikaisa.healthcarebackend.service.advice;

import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceTips;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Saikai
* @description 针对表【health_advice_tips(小贴士)】的数据库操作Service
* @createDate 2023-12-26 18:13:56
*/
public interface HealthAdviceTipsService extends IService<HealthAdviceTips> {

    List<HealthAdviceTips> getTips(int tipsNum);
}
