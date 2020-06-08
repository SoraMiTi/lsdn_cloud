package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client")
@ComponentScan({"cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service",
        "cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.controller"})
@EnableDistributedTransaction
public class LsdnScreenLogicApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsdnScreenLogicApplication.class, args);
    }
}
