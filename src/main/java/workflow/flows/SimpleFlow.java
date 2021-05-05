package workflow.flows;

import org.springframework.stereotype.Service;
import workflow.stages.IStage;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleFlow implements IFlow {

    List<IStage> stages;

    public SimpleFlow( List<IStage> stages ) {
        this.stages = new ArrayList<>();
    }

    public void addStage( IStage stage ) {
        this.stages.add( stage );
    }

    @Override
    public void executeFlow() {
        for (IStage stage : this.stages) {
            stage.start();
        }
    }

}
