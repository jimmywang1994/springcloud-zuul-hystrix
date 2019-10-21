package com.ww.springcloudzuulhystrix.controller;

import com.ww.springcloudzuulhystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class HystrixController {
    @Autowired
    HystrixService hystrixService;

    /**
     * 测试服务降级方法
     * @return
     */
    @GetMapping("/testDowngrade")
    public List<Map<String, Object>> testDowngrade() {
        return hystrixService.testDowngrade();
    }

    /**
     * 测试请求缓存
     * @return
     */
    @GetMapping("/testCache4Get")
    public List<Map<String, Object>> testCache4Get(){
        return hystrixService.testCache4Get();
    }


    /**
     * 在一个控制器方法中多次调用服务逻辑。用来模拟高并发。
     * 测试请求合并
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @GetMapping("/testMergeRequest")
    public void testMergeRequest() throws InterruptedException, ExecutionException {
        Future<Map<String, Object>> r1 = hystrixService.testMergeRequest(1L);
        Future<Map<String, Object>> r2 = hystrixService.testMergeRequest(5L);
        Future<Map<String, Object>> r3 = hystrixService.testMergeRequest(10L);

        System.out.println("r1 : " + r1.get());
        System.out.println("r2 : " + r2.get());
        System.out.println("r3 : " + r3.get());

        Thread.sleep(50);

        Future<Map<String, Object>> r4 = hystrixService.testMergeRequest(10L);
        System.out.println("r4 : " + r4.get());
    }

    @GetMapping("/testBreaker")
    public List<Map<String, Object>> testBreaker() {
        return hystrixService.testBreaker();
    }

    @GetMapping("/testThreadQuarantine")
    public List<Map<String, Object>> testThreadQuarantine(){
        return hystrixService.testThreadQuarantine();
    }
}
