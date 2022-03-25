package com.spring.ref.config.scheduler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.SimpleTimeZoneAwareLocaleContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Spring Scheduler
 * 1. Application main() 에 @EnableScheduling 추가
 * 2. Scheduler 생성
 * Scheduler 는 기본적으로 thread 1개를 이용하여 동기 형식으로 진행됩니다.
 * 즉 1번 스케줄이 끝나지 않으면 2번 스케줄이 시작시간이 되었다고 하더라도 시작되지 않습니다.
 * 비동기 형식으로 진행하시고 싶으시다면 @EnableAsync 어노테이션을 이용할 수 있습니다.
 * *           *　　　　　　*　　　　　　*　　　　　　*　　　　　　*
 * 초(0-59)   분(0-59)　　시간(0-23)　　일(1-31)　　월(1-12)　　요일(0-7)
 */
@Slf4j
@EnableAsync
@Component
public class Scheduler {
  @Scheduled(fixedDelay = 1,timeUnit = TimeUnit.DAYS) // scheduler 끝나는 시간 기준으로 실행
  public void scheduleFixedDelayTask() {
    log.info("scheduleFixedDelayTask - {}", System.currentTimeMillis() / 1000);
  }


  /**
   * [cron]
   *  *          *          *　　  　　　　*　　 　　　　*　　　　　　MON-FRI
   *  초(0-59)   분(0-59)    시간(0-23)　　일(1-31)　　월(1-12)　　요일(0-7)
   */
  @Scheduled(cron = "* * 6 * * 1-6") //평일 6시간 마다 실행됨
  public void scheduleTaskUsingCronExpression() {
    long now = System.currentTimeMillis() / 1000;
    log.info("scheduleTaskUsingCronExpression - {}",now);
  }
}
