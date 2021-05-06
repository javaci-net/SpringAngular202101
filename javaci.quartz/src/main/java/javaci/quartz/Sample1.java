package javaci.quartz;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Sample1 implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap map = context.getJobDetail().getJobDataMap();
		String msgId = map.getString("msgId");
		System.out.println("Job is running at:" + LocalDateTime.now() + " msgId:" + msgId);
	}

}
