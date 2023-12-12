package br.pucgo.edu.evenitapi.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://pablohsz.github.io", "http://localhost:63342/")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
                .allowedHeaders("Authorization", "Content-Type", "ngrok-skip-browser-warning")
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String reportPath = uploadPath("./generated-reports");

        registry.addResourceHandler("/generated-reports/**")
                .addResourceLocations("file:/"+reportPath+"/");
    }

    private String uploadPath(String directory){
        Path uploadDirPath = Paths.get(directory);
        return uploadDirPath.toFile().getAbsolutePath();
    }
}
