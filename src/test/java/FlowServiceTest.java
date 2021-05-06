import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import workflow.FlowApplication;
import workflow.flows.SimpleFlow;
import workflow.stages.UploadTemplate;

@RunWith( SpringRunner.class )
@SpringBootTest( classes = FlowApplication.class )
public class FlowServiceTest {

    @Autowired
    private UploadTemplate uploadTemplate;

    @Autowired
    private SimpleFlow simpleFlow;

    @Test
    public void test() {

        simpleFlow.addStage( uploadTemplate );
        simpleFlow.executeFlow();


    }

}
