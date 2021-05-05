package workflow.stages;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import workflow.enums.StageStatus;
import workflow.events.EnvProvidedEvent;

@Component
@RequiredArgsConstructor
public class AskEnv extends IStage {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void start() {
        System.out.println("ASK ENV");
        applicationEventPublisher.publishEvent( new EnvProvidedEvent("TESTING") );
        this.stageStatus = StageStatus.SUCCESS;
    }

}
