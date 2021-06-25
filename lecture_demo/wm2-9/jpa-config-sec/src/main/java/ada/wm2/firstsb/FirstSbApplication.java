package ada.wm2.firstsb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class FirstSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSbApplication.class, args);
	}

}
