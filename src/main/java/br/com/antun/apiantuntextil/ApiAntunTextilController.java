package br.com.antun.apiantuntextil;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiAntunTextilController {

    private static final String TEMPLATE = "Olá %s, tudo bem contigo? O sistema começa agora!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/api-antun-textil")
    public AntunApplication greeting(
            @RequestParam(value = "content", defaultValue = "Renato") String content) {

        return new AntunApplication(counter.incrementAndGet(), String.format(TEMPLATE, content));
    }
}