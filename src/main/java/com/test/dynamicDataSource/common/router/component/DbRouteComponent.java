package com.test.dynamicDataSource.common.router.component;

import com.test.dynamicDataSource.common.router.RouteService;
import com.test.dynamicDataSource.common.router.annotation.RouteDbSource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by jd on 2016/7/17.
 */
@Aspect
@Component
public class DbRouteComponent {
    @Autowired
    private RouteService dBRouter;

    public DbRouteComponent() {
    }

    @Pointcut("@annotation( com.test.dynamicDataSource.common.router.annotation.RouteDbSource)")
    public void aopPoint() {
    }

    @Before("aopPoint()")
    public Object doRoute(JoinPoint jp) throws Throwable {
        long t1 = System.currentTimeMillis();
        boolean result = true;
        Method method = this.getMethod(jp);
        RouteDbSource doRoute = (RouteDbSource)method.getAnnotation(RouteDbSource.class);
        String routeField = doRoute.routeField();
        Object[] args = jp.getArgs();
        if(args != null && args.length > 0) {
            for(int i = 0; i < args.length; ++i) {
                long t2 = System.currentTimeMillis();
                String routeFieldValue = BeanUtils.getProperty(args[i], routeField);
                if(StringUtils.isNotEmpty(routeFieldValue)) {
                    if("name".equals(routeField)) {
                        this.dBRouter.doRouteByResource(Math.abs(routeFieldValue.hashCode()) + "");
                    } else {
                        this.searchParamCheck(routeFieldValue);
                        String resource = routeFieldValue.substring(routeFieldValue.length() - 4);
                        this.dBRouter.doRouteByResource(resource);
                    }
                    break;
                }
            }
        }

        return Boolean.valueOf(result);
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature msig = (MethodSignature)sig;
        return this.getClass(jp).getMethod(msig.getName(), msig.getParameterTypes());
    }

    private Class<? extends Object> getClass(JoinPoint jp) throws NoSuchMethodException {
        return jp.getTarget().getClass();
    }

    private void searchParamCheck(String payId) {
        if(payId.trim().equals("")) {
            throw new IllegalArgumentException("payId is empty");
        }
    }

//    public Router getdBRouter() {
//        return dBRouter;
//    }
//
//    public void setdBRouter(Router dBRouter) {
//        this.dBRouter = dBRouter;
//    }
}
