package fil.pji.devops.filemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import fil.pji.devops.filemanager.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class FilemanagerApplication {

	@Autowired
    private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(FilemanagerApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
            public void addCorsMappings(CorsRegistry registry) {
                String urls = env.getProperty("cors.allowed-origins");
                CorsRegistration reg = registry.addMapping("/**");
                reg.allowedOrigins(urls.split(","));
            }
		};
    }

}
