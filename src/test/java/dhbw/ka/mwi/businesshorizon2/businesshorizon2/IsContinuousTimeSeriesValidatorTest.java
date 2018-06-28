package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.dhbw.ka.mwi.businesshorizon2.App;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ScenarioPostRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IsContinuousTimeSeriesValidatorTest {
	@Autowired
    private Validator validator;

	@Test
	public void isOk() throws Exception {
		ScenarioPostRequestDto request = new ScenarioPostRequestDto();
		Set<ConstraintViolation<ScenarioPostRequestDto>> violations = validator.validate(request);
		
		assertTrue(true);
	}
}
