# 健康管理中心（暂定名称）

本仓库是 HealthCare 的后端项目，基于 SpringBoot，是人机交互技术课程的小组课程设计。

前端项目：https://github.com/KrisAlthea/HealthCare



## 项目结构

```shell
├── src
│   ├── main
│   │   ├── java
│   │   │   └── top.saikaisa.healthcarebackend
│   │   │       ├── HealthcareBackendApplication.java  # SpringBoot应用的入口
│   │   │       ├── config  	# 配置类目录
│   │   │       │   └── WebConfig.java	# 跨域配置（只有在开发环境下才用到）
│   │   │       ├── constant  	# 常量定义
│   │   │       │   └── UserConstant.java
│   │   │       ├── controller  # 控制器层
│   │   │       │   ├── HealthAdviceController.java	# 获取健康建议相关控制器
│   │   │       │   └── UserController.java  		# 用户登录及健康数据相关控制器
│   │   │       ├── mapper  	# MyBatis映射器接口
│   │   │       │   ├── HealthAdviceArticlesMapper.java
│   │   │       │   ├── HealthAdviceQaMapper.java
│   │   │       │   ├── HealthAdviceTipsMapper.java
│   │   │       │   └── UserMapper.java
│   │   │       ├── model  		# 数据模型
│   │   │       │   ├── HealthAdvice.java	# 健康建议文章、问答和小贴士的封装实体
│   │   │       │   ├── User.java			# 用户实体，对应 user 表
│   │   │       │   ├── healthadvice  		# 健康建议相关的实体
│   │   │       │   │   ├── HealthAdviceArticles.java	# 文章
│   │   │       │   │   ├── HealthAdviceQa.java			# 问答
│   │   │       │   │   └── HealthAdviceTips.java		# 小贴士
│   │   │       │   └── request	# 请求对象模型
│   │   │       │       ├── UserHealthDataRequest.java
│   │   │       │       ├── UserLoginRequest.java
│   │   │       │       └── UserRegisterRequest.java
│   │   │       └── service		# 服务层
│   │   │       	├── HealthAdviceService.java	# 健康建议服务封装
│   │   │       	├── UserService.java	# 用户服务（实现登录注册、健康数据等业务逻辑）
│   │   │       	├── healthadvice  # 各健康建议相关服务
│   │   │       	│   ├── HealthAdviceArticlesService.java
│   │   │       	│   ├── HealthAdviceQaService.java
│   │   │       	│   └── HealthAdviceTipsService.java
│   │   │       	└── impl	# 服务实现
│   │   │           	├── HealthAdviceServiceImpl.java	# 健康建议服务封装实现
│   │   │           	├── UserServiceImpl.java	# 用户服务实现
│   │   │           	└── healthadvice	# 各健康建议服务实现
│   │   │               	├── HealthAdviceArticlesServiceImpl.java
│   │   │               	├── HealthAdviceQaServiceImpl.java
│   │   │               	└── HealthAdviceTipsServiceImpl.java
│   │   └── resources  # 资源文件
│   │       ├── application.yml  # SpringBoot 配置文件
│   │       └── mapper  # MyBatis映射器XML文件
│   │           ├── HealthAdviceArticlesMapper.xml
│   │           ├── HealthAdviceQaMapper.xml
│   │           ├── HealthAdviceTipsMapper.xml
│   │           └── UserMapper.xml
│   └── test  	# 测试代码
├── .gitignore	# git上传忽略文件目录
├── pom.xml		# Maven项目依赖配置文件
└── README.md
```



## 本地运行


### 修改文件

#### （1）跨域配置

在 `src/main/java/top/saikaisa/healthcarebackend/config` 目录下添加一个配置类，名为 `WebConfig.java`，然后输入以下内容：

```java
package top.saikaisa.healthcarebackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // 前端服务器的URL
                .allowCredentials(true) // 允许携带凭证
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
```

#### （2）端口修改

在 `src/main/resources/application.yml` 中修改后端监听的端口号：

```yaml
server:
  port: 8080
```

### 安装依赖

通常，IDEA 会在项目启动时自动安装依赖，但如果没有安装，请在控制台输入以下命令：

```bash
mvn clean install
```

### 启动后端服务器

直接在 IDEA 内运行项目即可。

请确保前端运行在 http://localhost:3000 上，并且前端配置的后端 api 地址为 http://localhost:8080/api
