package com.ddlab.rnd.batch.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskLet1 implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution stepContrbn, ChunkContext chunkContext) throws Exception {
		
		System.out.println("Step - 1 executed .......");
		
		//Get the Job Parameter value
		String value = (String) chunkContext.getStepContext().getJobParameters().get("JobParameterKey");
		System.out.println("Job Parameter Value :::"+value);
		
		String result = "Step1 - Result";
		
		//Store the result which will be used in the next job
		chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("Output", result);
		
		return RepeatStatus.FINISHED;
	}

}
