public class UserServiceImpl implements UserService {
    @Override
    public void login(String name) {
        System.out.println(name + "登录了");
    }

    @Override
    public void logout(String name) {
        System.out.println(name + "下线了");
    }
}
