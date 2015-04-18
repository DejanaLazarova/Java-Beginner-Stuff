package com;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class RunBean implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		HandleUserInput input = new HandleUserInput();
		input.run();
	}

}
