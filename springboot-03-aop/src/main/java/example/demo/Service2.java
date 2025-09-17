package example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service
public class Service2 {
    
    public void add() {
        System.out.println("Service2 add run ......");
    }
}
