package br.com.antun.apiantuntextil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AntunApplication {

    private final long id;

    private final String content;

    private final String version = "0.0.1-SNAPSHOT";
}