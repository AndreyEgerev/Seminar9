package homework.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnProperty(value = "aspect.enabled", havingValue = "true")
public class TimerAspectConfiguration {
    @Bean
    public TimerAspect timerAspect() {
        return new TimerAspect();
    }
}
