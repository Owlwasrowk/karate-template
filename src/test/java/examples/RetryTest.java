package examples;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.intuit.karate.RuntimeHook;
import com.intuit.karate.Suite;
import com.intuit.karate.core.ScenarioResult;
import java.util.List;
import java.util.stream.Collectors;



class RetryTest {

    @Test
    void testRetry() {
        Results results = Runner.path("classpath:examples")
                .parallel(1);
        Suite suite = results.getSuite();
        List<ScenarioResult> failedResults = suite.getScenarioResults().filter(ScenarioResult::isFailed).collect(Collectors.toList());
        for (ScenarioResult scenarioResult : failedResults) {
            ScenarioResult retryResult = suite.retryScenario(scenarioResult.getScenario());
            suite.updateResults(retryResult);
        }
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
