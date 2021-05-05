package workflow.stages;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import workflow.enums.StageStatus;

@Data
@RequiredArgsConstructor
public abstract class IStage {

    protected StageStatus stageStatus;

    abstract public void start();

    public boolean next() {
        return this.stageStatus.equals( StageStatus.SUCCESS );
    }

}
