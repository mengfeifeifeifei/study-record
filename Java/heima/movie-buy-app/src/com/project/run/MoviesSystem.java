package com.project.run;

import com.project.bean.Business;
import com.project.bean.Customer;
import com.project.bean.Movie;
import com.project.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

public class MoviesSystem {
    /**
     * 存储用户数据
     * @param args
     */
    private static final List<User> ALL_USERS = new ArrayList<>();
    // 存储电影
    private static Map<Business, List<Movie>> ALL_MOVIES = new HashMap<>();

    private static final Scanner SYS_NC = new Scanner(System.in);

    private static User userInfo;

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static final Logger logger = LoggerFactory.getLogger("MoviesSystem");
    
    static {
        Customer customer = new Customer();
        customer.setLoginName("zhang");
        customer.setMoney(128);
        customer.setPassWord("123456");
        customer.setPhone("18031835710");
        customer.setSex('男');
        customer.setUserName("张梦飞");
        ALL_USERS.add(customer);

        Customer customer1 = new Customer();
        customer1.setLoginName("meng");
        customer1.setMoney(59);
        customer1.setPassWord("1234567");
        customer1.setPhone("18031835710");
        customer1.setSex('男');
        customer1.setUserName("飞");
        ALL_USERS.add(customer1);

        Business business = new Business();
        business.setLoginName("shangjia1");
        business.setMoney(0);
        business.setPhone("123");
        business.setPassWord("123");
        business.setSex('女');
        business.setUserName("好");
        business.setShopAddress("中国");
        business.setShopName("店铺1");
        ALL_USERS.add(business);
        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(business, movies);
    }
    
    public static void main(String[] args) {
        showMain();
    }

    private static void showMain() {
        System.out.println("===========电影首页============");
        System.out.println("1. 登陆");
        System.out.println("2. 用户注册");
        System.out.println("3. 商家注册");
        while (true) {
            System.out.println("输入操作命令");
            String s = SYS_NC.nextLine();
            switch (s) {
                case "1":
                    login();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("命令有误，重新输入");
            }
        }
    }

    private static void login() {
        while (true) {
            System.out.println("请输入用户名:");
            String loginName = SYS_NC.nextLine();
            System.out.println("请输入密码:");
            String passWord = SYS_NC.nextLine();
            // 根据登录名查询用户对象
            User u = getUserByLoginName(loginName);
            if (u != null) {
                if (u.getPassWord().equals(passWord)) {
                    userInfo = u;
                    // 登陆成功  判断是商家还是普通用户
                    if (u instanceof Customer) {
                        showCustomerMain();
                    } else {
                        // 商家用户
                        showBusinessMain();
                    }
                } else {
                    logger.warn("密码错误");
//                    System.out.println("密码错误");
                }
            } else {
                System.out.println("登录名错误，请确认");
            }
        }
    }

    private static void showBusinessMain() {
        while (true) {
            System.out.println("欢迎进入商家操作界面");
            System.out.println("1. 显示详情");
            System.out.println("2. 上架电影");
            System.out.println("3. 下架电影");
            System.out.println("4. 修改电影");
            System.out.println("5. 退出");
            System.out.println("请输入要操作的命令");
            String s = SYS_NC.nextLine();
            switch (s) {
                case "1":
                    showBusinessInfos();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    return;
                default:
                    System.out.println("不存在该命令");
                    break;
            }
        }
    }

    private static void showBusinessInfos() {
        Business business = (Business) userInfo;
        System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone() + "\t\t地址：" + business.getShopAddress());
        List<Movie> movies = ALL_MOVIES.get(userInfo);
        System.out.println("片名\t\t\t主演\t\t\t时长\t\t\t");
        for (Movie movie : movies) {
            System.out.println(movie.getName() + "\t\t\t" + movie.getActor() + "\t\t\t" + movie.getTime());
        }
    }

    // 展示当前商家的信息
    private static void showCustomerMain() {
//        ALL_MOVIES.forEach();
        System.out.println("欢迎进入客户操作界面");
        
    }

    public static User getUserByLoginName(String loginName) {
        for (User user : ALL_USERS) {
            // 判断用户登录名是否是我们想要的
            if (user.getLoginName().equals(loginName)){
                return user;
            }
        }
        return null;
    }
}
