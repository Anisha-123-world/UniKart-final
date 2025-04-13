package io.github.ansh1kaa.unikart;

import org.springframework.boot.SpringApplication;

public class TestUniKartApplication {

    public static void main(String[] args) {
        SpringApplication.from(UniKartApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
