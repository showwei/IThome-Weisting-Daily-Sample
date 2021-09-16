package sw.idv.romp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectCloneHandler implements InvocationHandler {
    private static volatile ObjectCloneHandler instance = null;
    public static Map<String,Object> INVOCATION_HANDLER = new HashMap<String,Object>();

    public static synchronized ObjectCloneHandler getInstance() {
        if ( instance == null ) {
            instance = new ObjectCloneHandler();
        }
        return instance;
    }


    private Object delegate;

    public Object bind(Object delegate) {
        //透過配置池取得對應元件
        this.delegate = ObjectCloneHandler.getInstance().getInvocationHandler().get(delegate.getClass().getName());;
         return this.delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            result = method.invoke(delegate,args);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return result;
    }

    public static Map<String, Object> getInvocationHandler() {
        return INVOCATION_HANDLER;
    }
}
