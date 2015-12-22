package com.ddlab.rnd.batch.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskLet3 implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution stepContrbn, ChunkContext chunkContext) throws Exception {
		
		System.out.println("Task - 3 executed .......");
		String someResult = (String) chunkContext.getStepContext().getStepExecution().getJobExecution()
				.getExecutionContext().get("Output");
		System.out.println("Result from the Previous Job :::" + someResult);
		
		return RepeatStatus.FINISHED;
	}

}
