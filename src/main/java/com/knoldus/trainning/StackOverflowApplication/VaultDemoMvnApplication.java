package com.knoldus.trainning.StackOverflowApplication;

import com.knoldus.trainning.StackOverflowApplication.configuration.VaultConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class VaultDemoMvnApplication {

	// First raise the vault server by writing this command in terminal "vault server -dev"  .
	// By default server is up on 8200 port  .
	// After that use generated token in bootstrap.properties file  .
	// Then write the value of cid and secret at vault server  .

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(VaultDemoMvnApplication.class, args);
		VaultConfiguration vaultConfiguration = context.getBean(VaultConfiguration.class);
		System.out.println("Login: " + vaultConfiguration.getLogin());
		System.out.println("Password: " + vaultConfiguration.getPassword());
		String s1 = vaultConfiguration.getLogin();
		String s2 = vaultConfiguration.getPassword();
	}

}
