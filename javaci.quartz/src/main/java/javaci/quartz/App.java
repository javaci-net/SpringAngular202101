package javaci.quartz;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.calendar.HolidayCalendar;

public class App {

	
	public static void main(String args[]) throws Exception {
		
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		Scheduler sched = schedFact.getScheduler();
		sched.start();

		JobDetail job = JobBuilder.newJob()
				.ofType(Sample1.class)
				.withIdentity("myJob", "group1")
				.usingJobData("msgId", "1234")
				.build();
		
		HolidayCalendar cal = new HolidayCalendar();
		cal.addExcludedDate( new Date() );
		sched.addCalendar("myHolidays", cal, false, true);

		
		Date startDate = Date.from(Instant.now().plus(1, ChronoUnit.SECONDS));
		
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				//.startNow()
				.startAt(startDate )
				/*.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(1)
							//.repeatForever()
							.withRepeatCount(3)
							)*/
				.withPriority(100)
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
				//.modifiedByCalendar("myHolidays")
				.build();

		sched.scheduleJob(job, trigger);

	}
}
