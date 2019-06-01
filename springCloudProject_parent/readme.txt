项目结构：
springCloudProject_parent    .pom               
	--springCloudProject_api     .pom           :只提供接口api和entity  接口方法加：@RequestMapping("xxx")
		--springCloudProject_api_user      .jar
		--springCloudProject_api_vip       .jar
	--springCloudProject_service .pom		    :1.依赖对应的api，并且实现接口。   实现的方法加同样的：@RequestMapping("xxx")
		--springCloudProject_user_service  .jar :2.定义fegin接口实现被调用方api接口，并注解需要被调用的服务名称@FeignClient("serviceName")
		--springCloudProject_vip_service   .jar :3.启动app，@EnableEurekaClient：注册到eureka；@EnableFeignClients：支持fegin客户端
		
		
1.api提供接口，方法加注解@RequestMapping
2.service实现api接口，并实现方法，方法加注解@RequestMapping
3.service层注解@RestController
4.fegin包下，创建fegin对象实现调用方的api接口。fegin对象加注解：@FeignClient("服务方注册名称")
5.在service层注入fegin对象，并使用。
6.备注：fegin调用需要传参，用注解：@RequestParam("name")，并加上参数name
7.配置application.yml
8.app启动加注解：@EnableEurekaClient、@EnableFeignClients



hystrix服务保护机制
1.在parent的pom中加入依赖：spring-cloud-starter-netflix-hystrix
2.在需要启用hystrix的app里加上注解：@EnableHystrix
3.在服务对应的application.yml中加入配置
4.在服务里需要做熔断机制的接口上，加注解、并写上服务降级需要调用的方法：@HystrixCommand(fallbackMethod="getUserByTimeHystrixBack")此方法，参数要和原接口一致。
5.启动服务，可用打印线程池名称/线程名称的方法，来验证服务熔断和服务降级是否开启。

6.使用hystrix服务保护（以下两种方式）
	2.1-@HystrixCommand
	2.2-@FeignClient(name="xxx",fallback=FallBackCommon.class)




