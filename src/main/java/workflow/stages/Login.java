package workflow.stages;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import workflow.enums.StageStatus;
import workflow.events.AccessTokenRetrivedEvent;
import workflow.events.EnvProvidedEvent;

@Component
@RequiredArgsConstructor
public class Login extends IStage {

    private final ApplicationEventPublisher applicationEventPublisher;

    private String env;

    @Override
    public void start() {
        System.out.println("GET LOGIN");
        if ( ! ( env == null ) ) {
            System.out.println("FOR ENV : " + this.env );
            System.out.println("USER: username");
            System.out.println("PASS: password");
            applicationEventPublisher.publishEvent( new AccessTokenRetrivedEvent("{ ACCESS_TOKEN, USER_ID }") );
            this.stageStatus = StageStatus.SUCCESS;
        } else {
            System.out.println("ENV MISSING");
        }
    }

    @EventListener
    private void setEnv( EnvProvidedEvent event ) {

        this.env = event.getEnv();

    }

}
