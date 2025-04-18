package vn.doan;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartSeverJavaWeb {
	public static void main(String[] args) {
		SpringApplication start = new SpringApplication(StartSeverJavaWeb.class);
		start.setDefaultProperties(Collections.singletonMap("server.port", "9090"));
		start.run(args);
	}
}
