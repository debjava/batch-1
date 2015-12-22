package com.ddlab.rnd.batch.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskLet2 implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution stepContrbn, ChunkContext chunkContext) throws Exception {

		String someResult = (String) chunkContext.getStepContext().getStepExecution().getJobExecution()
				.getExecutionContext().get("Output");
		System.out.println("Result from the Previous Job :::" + someResult);

		String result = "Step2 - Result";
		// Store the result which will be used in the next job
		chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("Output", result);

		return RepeatStatus.FINISHED;
	}

}
