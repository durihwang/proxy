package hello.proxy.cglib.code;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
        throws Throwable {

        log.info("TimeProxy Inter 실행");
        long start = System.currentTimeMillis();

        Object result = methodProxy.invoke(target, args);

        long end = System.currentTimeMillis();
        long resultTime = end - start;

        log.info("TimeProxy 종료 resultTime={}", resultTime);

        return result;
    }
}
