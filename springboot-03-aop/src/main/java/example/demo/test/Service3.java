package example.demo.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service
public class Service3 {
    
    public void add() {
        System.out.println("Service3 add run ......");
    }
}
