package goalsapi;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MyFirstRoute extends RouteBuilder {

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public void configure() throws Exception {
        from("timer:goalsCheck?period=10000")
                .process(exchange -> {
                    List<Goal> goals = goalRepository.findAll();
                    exchange.getIn().setBody("Total goals in database: " + goals.size());
                })
                .log("${body}")
                .to("file:output?fileName=goals-report.txt");
    }
}
