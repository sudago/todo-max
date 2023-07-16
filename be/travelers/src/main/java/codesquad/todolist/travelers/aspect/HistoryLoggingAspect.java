package codesquad.todolist.travelers.aspect;

import codesquad.todolist.travelers.history.service.HistoryService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HistoryLoggingAspect {
    HistoryService historyService;

    public HistoryLoggingAspect(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Pointcut("execution(public * codesquad.todolist.travelers.task.service..*(..))")
    void allTaskService() {
    }

    @After("allTaskService()")
    public void logHistory(JoinPoint joinPoint) {
        Object args = joinPoint.getArgs();
        historyService.saveHistory();
    }

}
