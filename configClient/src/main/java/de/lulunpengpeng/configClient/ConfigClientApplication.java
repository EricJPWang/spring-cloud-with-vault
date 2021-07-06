package de.lulunpengpeng.configClient;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}

@RefreshScope
@RestController
class ClientController {

    private String value1;
    private String value2;
    private String value3;

    @Autowired
    public ClientController(@Value("${key1}") String value1,
                            @Value("${key2}") String value2,
                            @Value("${key3}") String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    @GetMapping("/keys")
    List<Result> getKeys() {
        return Arrays.asList(
                Result.builder().key("key1").value(value1).build(),
                Result.builder().key("key2").value(value2).build(),
                Result.builder().key("key3").value(value3).build()
        );
    }

}

@Data
@Builder
class Result {
    String key;
    String value;
}
