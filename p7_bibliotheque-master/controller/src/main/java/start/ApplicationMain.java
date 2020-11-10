package start;

 


import java.lang.annotation.Target;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.soro.entities.User;

/*@SpringBootApplication(scanBasePackages = {
		"fr.soro",
		"fr.soro.dtao", 
		"fr.soro.repositories",
		"fr.soro.entities"
		}, exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
@ComponentScan({
	"fr.soro",
	"fr.soro.dtao", 
	"fr.soro.repositories",
	"fr.soro.entities"
	})
*/
@Configuration
@PropertySource(value = {"application.properties"})
@EnableAutoConfiguration
//@ComponentScan(basePackageClasses =UserController.class)
@ComponentScan(basePackages = {
		"start",
		"controller", 
		"fr.soro.service",
		"fr.soro.security",
		"fr.soro.security.jwt",
		"fr.soro.config",
		"fr.soro.web"
	})
@EntityScan(basePackages = {"fr.soro"})
@EnableJpaRepositories(basePackages = {"fr.soro"})
@SpringBootApplication(scanBasePackages = {
		"fr.soro"
		},exclude= { DataSourceAutoConfiguration.class})
@RestController
//@EnableJpaAuditing
public class ApplicationMain{
	


	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
	 	
}
