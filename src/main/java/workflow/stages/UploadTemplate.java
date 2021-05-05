package workflow.stages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UploadTemplate extends IStage {

    private final AskEnv askEnv;

    private final Login login;

    private final Upload upload;

    @Override
    public void start() {
        askEnv.start();
        if( askEnv.next() )
            login.start();
        if( login.next() )
            upload.start();
    }

}
