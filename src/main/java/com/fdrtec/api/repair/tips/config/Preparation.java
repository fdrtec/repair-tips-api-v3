package com.fdrtec.api.repair.tips.config;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;

@Profile(value = "dev")
public class Preparation implements CommandLineRunner {

    @Override
    public void run(String ...arg) throws Exception {
        System.out.println("Teste com classe de preparação");
    }     
    
}
