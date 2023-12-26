package top.saikaisa.healthcarebackend.service.healthadvice;

import top.saikaisa.healthcarebackend.model.healthadvice.HealthAdviceQa;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Saikai
* @description 针对表【health_advice_qa(问答)】的数据库操作Service
* @createDate 2023-12-26 18:13:52
*/
public interface HealthAdviceQaService extends IService<HealthAdviceQa> {

    List<HealthAdviceQa> getQa(int qaNum);
}
