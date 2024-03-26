// ComponentScan nos ajuda a procurar as classes para serem gerenciadas como beans

package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
}
