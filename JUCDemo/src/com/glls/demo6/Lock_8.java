package com.glls.demo6;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : Lock_8
 * @Author : glls
 * @Date: 2021/7/14 21:34
 * @Description :  多线程所  synchronized 的 八种情况
 */
class Phone{
    public static synchronized void sendSMS() throws InterruptedException {
        //停留4秒
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-----sendSMS");
    }

    public  synchronized void sendEmail(){
        System.out.println("-----sendEmail");
    }

    public void getHello(){
        System.out.println("-----getHello");
    }


}


/**
 *  8锁
    1. 标准访问 ，先打印短信还是邮件
----sendSMS
----sendEmail
    2. 停4秒 在短信方法内，先打印短信还是邮件
 ----sendSMS
 ----sendEmail
    3. 新增普通的hello 方法，是先打短信还是hello
 -----getHello
 ----sendSMS

    4. 现在有两部手机，先打印短信还是邮件
 -----sendEmail
 -----sendSMS
    5.两个静态同步方法 1部手机 先打印短信还是邮件
 -----sendSMS
 -----sendEmail
    6.两个静态同步方法，2部手机，先打印短信还是邮件
 -----sendSMS
 -----sendEmail
    7.1个静态同步方法，1个普通同步方法，1部手机，先打印短信还是邮件
 -----sendEmail
 -----sendSMS
    8.1个静态同步方法，1个普通同步方法，2部手机，先打印短信还是邮件
 -----sendEmail
 -----sendSMS

 **/
public class Lock_8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        Thread.sleep(100);

        new Thread(()->{
            //phone.sendEmail();

            //phone.getHello();

            phone2.sendEmail();
        },"BB").start();
    }
}
