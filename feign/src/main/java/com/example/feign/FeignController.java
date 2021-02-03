package com.example.feign;

import com.example.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @GetMapping(value = "/feignTest")
    public String sayHi(@RequestParam String name) {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置线程池参数信息
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(50);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("myExecutor--");
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        //修改拒绝策略为使用当前线程执行
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //初始化线程池
        taskExecutor.initialize();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            taskExecutor.execute(() -> getName(finalI+""));
        }

        System.out.println("调用了");
        return "123";
    }

    public void getName(String name){
        System.out.println("--"+name);
    }

    public static void main(String[] args) {
        System.out.println("计算机AAbbu".length());
    }


}
