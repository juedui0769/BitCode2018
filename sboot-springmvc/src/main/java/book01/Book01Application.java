package book01;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Book01Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Book01Application.class)
                .run(args);
    }
}
