package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import javax.persistence.Entity;
import java.util.Set;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("cn.com.liandisys.lsdn.code.model.lsdn_screen")
@ComponentScan({"cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao",
        "cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.controller"})
@EnableJpaRepositories("cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao")
@EnableDistributedTransaction
public class LsdnScreenSelectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsdnScreenSelectApplication.class, args);
    }


    /**
     * 为了解决Spring Data Rest不暴露ID字段的问题。
     * 参考：http://tommyziegler.com/how-to-expose-the-resourceid-with-spring-data-rest/
     * Created by Dante on 2016/8/18.
     */
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(
                    RepositoryRestConfiguration config) {

                final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
                provider.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
                final Set<BeanDefinition> beans = provider.findCandidateComponents("cn.com.liandisys.lsdn.code.model.lsdn_screen.model");
                for (final BeanDefinition bean : beans) {
                    try {
                        config.exposeIdsFor(Class.forName(bean.getBeanClassName()));
                    } catch (final ClassNotFoundException e) {
                        // Can't throw ClassNotFoundException due to the method signature. Need to cast it
                        throw new IllegalStateException("Failed to expose `id` field due to", e);
                    }
                }
            }
        };
    }
}
