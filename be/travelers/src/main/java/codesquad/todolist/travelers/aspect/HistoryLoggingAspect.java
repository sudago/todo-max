package codesquad.todolist.travelers.aspect;

import codesquad.todolist.travelers.annotation.ActionId;
import codesquad.todolist.travelers.aspect.dto.TaskServiceHistoryDto;
import codesquad.todolist.travelers.history.service.HistoryService;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HistoryLoggingAspect {
    HistoryService historyService;

    public HistoryLoggingAspect(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Pointcut("execution(public * codesquad.todolist.travelers.task.service.TaskService.*Task*(..))")
    void allTaskService() {
    }

    @Around("allTaskService()")
    public Object logHistory(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ActionId actionId = method.getAnnotation(ActionId.class);

        Object[] args = proceedingJoinPoint.getArgs();
        historyService.saveHistory((TaskServiceHistoryDto) args[0], actionId.value());
        return proceedingJoinPoint.proceed();
    }

}
