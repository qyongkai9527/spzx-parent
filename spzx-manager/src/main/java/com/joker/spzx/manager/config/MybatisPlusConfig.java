package com.joker.spzx.manager.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.MySqlDialect;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Configuration
public class MybatisPlusConfig {


    @Bean("SpzxManagerThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        Runtime runtime = Runtime.getRuntime();
        int cores = runtime.availableProcessors();

        executor.setCorePoolSize(cores + 1); // 设置核心线程数
        executor.setMaxPoolSize(cores * 20); // 设置最大线程数
        executor.setKeepAliveSeconds(60); // 设置空闲时间
        executor.setQueueCapacity(100); // 设置队列大小
        executor.setThreadNamePrefix("Manager-ThreadPool-"); // 配置线程池的前缀
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 进行加载
        executor.initialize();
        return executor;
    }


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setDialect(new MySqlDialect());
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        paginationInnerInterceptor.setMaxLimit(500L);
        paginationInnerInterceptor.setOptimizeJoin(true);
        interceptor.addInnerInterceptor(paginationInnerInterceptor); // 分页插件
        return interceptor;
    }

    public static void main(String[] args) {
        List<String> allProductIds=Lists.newArrayList("1002749687445",
                "1004309444423",
                "999848005018",
                "1000569284830",
                "985421198746",
                "986144913184",
                "986129657623",
                "984626523823",
                "985903033980",
                "986552880747",
                "985090946595",
                "985522929172",
                "985455529717",
                "983651983880",
                "983617039200",
                "983592859425",
                "983528215918",
                "984339673981",
                "984209333776",
                "946428559433",
                "901838610614",
                "901138863229",
                "893415340735",
                "891428286635",
                "889127465365",
                "887368941385",
                "867344217837",
                "864099421832",
                "854165978085",
                "853356381342",
                "853355809972",
                "853044770497",
                "852622142189",
                "839691775119",
                "839684963723",
                "836021781983",
                "830273414526",
                "806286726626",
                "780589729422",
                "767062327341",
                "760778266041",
                "760175574364",
                "760216419668",
                "760026304444",
                "760026408294",
                "760215475188",
                "760024152245");

        List<String> currentProductIds=Lists.newArrayList("986129657623",
                "901838610614",
                "854165978085",
                "946428559433",
                "839684963723",
                "984339673981",
                "853044770497",
                "986552880747",
                "985522929172",
                "760026304444",
                "901138863229",
                "836021781983",
                "983528215918",
                "985903033980",
                "853356381342",
                "891428286635",
                "867344217837",
                "1000569284830",
                "852622142189",
                "806286726626");

        System.out.println(allProductIds.size());
        System.out.println(currentProductIds.size());
        allProductIds.removeAll(currentProductIds);
        System.out.println(allProductIds);
    }

}
