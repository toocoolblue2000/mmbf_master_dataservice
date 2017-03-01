package in.co.mmbf.services.data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
//@Import(RepositoryRestMvcConfiguration.class)
public class RestApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestApplication.class, args);
	}
}
