package jp.co.nasuramsn.sitewarapper.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("jp.co.nasuramsn.sitewarapper.common.aspect")
@EnableAspectJAutoProxy
public class AopConfig {
}
