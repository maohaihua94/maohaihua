import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    Object target;

    public MyInvocationHandler() {
    }

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前...");
        Object object = method.invoke(target, args);
        System.out.println("执行后...");
        return object;
    }
}
