package workflow.stages;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import workflow.enums.StageStatus;
import workflow.events.AccessTokenRetrivedEvent;

@Component
public class Upload extends IStage {

    private String accessToken;

    @Override
    public void start() {
        System.out.println("PERFORM UPLOAD");
        if( ! ( accessToken == null) ) {
            System.out.println("FOR AUTH_TOKEN " + this.accessToken);
            System.out.println("UPLOAD DONE!");
            this.stageStatus = StageStatus.SUCCESS;
        } else {
            System.out.println("MISSING AUTH_TOKEN");
        }
    }

    @EventListener
    public void setAccessToken( AccessTokenRetrivedEvent event ) {
        this.accessToken = event.getAccessToken();
    }

}
