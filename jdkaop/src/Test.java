import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) throws IOException {
        UserService target = new UserServiceImpl();
        UserService service = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new MyInvocationHandler(target));
        service.login("华哥");
        service.logout("华哥");

        byte[] proxyclass = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{UserService.class, HakerService.class});
        File file = new File("D:\\aop\\$Proxy0.class");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(proxyclass);
        outputStream.flush();
        outputStream.close();

    }

}
