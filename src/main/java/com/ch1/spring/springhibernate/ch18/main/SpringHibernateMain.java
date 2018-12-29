package com.ch1.spring.springhibernate.ch18.main;

import com.ch1.spring.springhibernate.ch18.dao.PersonDAO;
import com.ch1.spring.springhibernate.ch18.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SpringHibernateMain {
    public static void main(String[] args) throws ParseException {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
        test12();
    }

    private static void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PersonDAO personDAO = context.getBean(PersonDAO.class);

        Person person = new Person();
        person.setName("Pankaj");
        person.setCountry("India");
        personDAO.save(person);

        System.out.println("Person:" + person);
        List<Person> list = personDAO.list();
        for (Person p : list) {
            System.out.println("Person List:" + p);
        }

        //close resources
        context.close();
    }

    private static void test2() {
        String str = "有志者，事竟成，破釜沉舟，百二秦关终属楚；苦心人，天不负，卧薪尝胆，三千越甲可吞吴。——蒲松龄";
        System.out.println(str);

        String result = str.substring(0, 10);
        System.out.println(result);

    }

    private static void test3() {
        /*Date date = new Date("2018-12-24 18:53:35");
        System.out.println(date);*/
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp);
    }

    private static void test4() {
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(stamp.getTime());
        System.out.println(date);
    }

    private static void test5() {
        long l = System.currentTimeMillis();
        System.out.println(l);

        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        System.out.println(timeInMillis);
    }

    private static void test6() throws ParseException {
        String str = "2017-10-28 19:27:37";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date parse = sdf.parse(str);

        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        long timeInMillis = instance.getTimeInMillis();
        System.out.println(timeInMillis);
    }

    private static void test7() {
        int number = 10;
        // 原始数二进制
        printInfo(number);

        // 左移一位
        number = number << 1;
        printInfo(number);

        // 右移一位
        number = number >> 1;
        printInfo(number);
    }

    private static void printInfo(int num) {
        System.out.print(num + "\t\t\t");
        System.out.println(Integer.toBinaryString(num));
    }


    /*
    * 无符号右移位操作符，无论符号是正负，都在高位插入0（都变成了正数）。
    -1>>>1得到的结果是2147483647，是Integer的最大值。

    -1的二进制补码：
    1111 1111 1111 1111 1111 1111 1111 1111
    右移一位，在最左边空出的一位插入0，变成了32位整数的最大值：
    0111 1111 1111 1111 1111 1111 1111 1111
    结果是2147483647
*/
    private static void test8() {
        int number = -1;
        printInfo(number);

        number = number >>> 1;
        System.out.println(number);
        printInfo(number);
    }

    /*
    快速算出移位运算符结果方法：

    在不大于自身数值类型最大位数的移位时，一个数移位n，就是将这个数乘以（左移）2的n次幂，右移就是除，然后都取整就可以了
    比如int 32位的
    500>>3 这样算：500/8 取整 就是62
    356>>4 356/16 结果是 22
    8<<3 8*8 结果是 64

    64位和上面方法一样。
    如果移动过大超过了32位怎么办 移位数和32取余得到的数字在套用上面就可以了
    比如 500>>67 怎么算？（就相当于500>>3）
    1.先67对32取余 结果是3
    2. 然后500/8 结果62

    补充一点：计算机指令种的右移位运算符有2种，左移就是补0没花哨。但右移就有点事情了。
    1. 算术右移 意思是你移动后补的是最高位的值。
    举例：一个byte数字99 的二进制是 0110 0011
    你右移4位后 补的是0 ------0000 0110
    但是再看这一个：byte数字-107二进制是1001 0101 这是1开头的
    你右移4位后补的确是最高位1 -------1111 1001
    2.逻辑右移 补0就完事了

    针对右移，C语言美显示给出用哪种的，一般根据编译器/机器组合来确定用哪一种，但大多数都默认算术右移。
    JAVA就比较严谨了，明确规定x>>k是算术右移
    x>>>k是逻辑右移
    话说回来之所以区分这一点我想应该是对有符号的规定吧，无符号右移肯定是逻辑的啊 最高位本来就是0，
    然而对于负数最高位是1，在进行右移时算术右移的提出解决了一个很普遍的问题，那就是负整数的除法运算，
    你负数除以一个正数一定是负数吧，如果没有算数右移这一概念的提出不补1都补0的话你得到的就是正数了，
    算术右移可以替代除法运算。有了这个就完美了，得到的还是负数，符合现实中数学常识了
    */
    private static void test9() {
        int number = 0;
        printInfo(number);

        number = number >> 1;
        printInfo(number);
    }

    private static void test10() {
        int number = 1;
        printInfo(number);

        number = number << 1;
        printInfo(number);

        number = number << 1;
        printInfo(number);

        number = number << 1;
        printInfo(number);

        number = number << 1;
        printInfo(number);

        number = number << 1;
        printInfo(number);

        number = number << 1;
        printInfo(number);

        number = number << 1;
        printInfo(number);

        number = number << 1;
        printInfo(number);

        System.out.println("--------------------------------------------------------------");

        number = number >> 1;
        printInfo(number);

        number = number >> 1;
        printInfo(number);

        number = number >> 1;
        printInfo(number);

        number = number >> 1;
        printInfo(number);

        number = number >> 1;
        printInfo(number);
    }

    private static void test11() {
        int number = 500;
        printInfo(number);

        number = number >> 3;
        printInfo(number);
    }

    private static void test12() {
        int number = 2;
        printInfo(number);

        number = number << 31 - 1;// -2147483648
        printInfo(number);
    }
}
