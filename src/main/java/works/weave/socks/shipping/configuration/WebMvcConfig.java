package works.weave.socks.shipping.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import works.weave.socks.shipping.middleware.HTTPMonitoringInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private HTTPMonitoringInterceptor httpMonitoringInterceptor;

    @Bean
    HTTPMonitoringInterceptor httpMonitoringInterceptor() {
        return new HTTPMonitoringInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpMonitoringInterceptor)
                .addPathPatterns("/**");
    }
}
