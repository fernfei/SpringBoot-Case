package com.fern.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MailApplicationTests {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    TemplateEngine templateEngine;
    @Test
    void contextLoads() {
        //顾名思义，一个简单的消息注定不能发送附近和html
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //邮件标题
        mailMessage.setSubject("这是一封测试邮件");
        //内容
        mailMessage.setText("这是一封测试内容");
        //来自谁
        mailMessage.setFrom("1639670695@qq.com");
        mailMessage.setSentDate(new Date());
        //也可以是数组，群发
        //发给谁
        mailMessage.setTo("3259272159@qq.com");
//        抄送，一同收到邮件得用户可以看到，收到该邮件的其他人
//        mailMessage.setCc();
//        匿抄，别人不会看见同时收到信息得人
//        mailMessage.setBcc();
        javaMailSender.send(mailMessage);
    }

    @Test
    void test1() throws MessagingException {
        //多用途邮件扩展
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //true表示是否创建支持替代文本、行内元素和附件的多部分消息
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("这是一封测试邮件（带附件）");
        mimeMessageHelper.setText("这是一封测试内容");
        mimeMessageHelper.setFrom("1639670695@qq.com");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setTo("3259272159@qq.com");
        //顾名思义，添加附件
        mimeMessageHelper.addAttachment("fern.jpg", new File("D:\\User\\fern.jpg"));
        javaMailSender.send(mimeMessage);

    }

    @Test
    void test2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("这是一封测试邮件（html）");
        //true表示开启html
        mimeMessageHelper.setText("这是一封测试邮件内容<image src='cid:01'></image>",true);
        //mimeMessageHelper.setText("这是一封测试邮件内容","<image src='cid:01'></image>");
        mimeMessageHelper.addInline("01",new File("D:\\User\\fern.jpg"));
        mimeMessageHelper.setFrom("hufei1639670695@163.com");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setTo("hufei1639670695@gmail.com");
        javaMailSender.send(mimeMessage);
    }

    @Test
    void test3() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("欢迎加入荣华富贵大家庭(thymeleaf)");
        //操作html的类
        Context context = new Context();
        context.setVariable("username", "陈翔");
        context.setVariable("position", "java工程师");
        context.setVariable("joblevel", "高级工程师");
        context.setVariable("salary", "10000");
        context.setVariable("dep", "研发部");
        //将html转成字符串发到邮箱
        String process = templateEngine.process("mail.html", context);
        //true开启html
        mimeMessageHelper.setText(process,true);
        mimeMessageHelper.setFrom("hufei1639670695@163.com");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setTo("hufei1639670695@gmail.com");
        javaMailSender.send(mimeMessage);
    }

    @Test
    void test4() throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("欢迎加入荣华富贵大家庭(freemarker)");
        //配置版本
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
        //freemarker所在的位置
        configuration.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "templates");
        //freemarker文件名
        Template template = configuration.getTemplate("mail.ftlh");
        Map<String, String> map = new HashMap<>();
        map.put("username", "陈翔");
        map.put("position", "java工程师");
        map.put("joblevel", "高级工程师");
        map.put("salary", "10000");
        map.put("dep", "研发部");
        StringWriter writer = new StringWriter();
        template.process(map, writer);
        mimeMessageHelper.setText(writer.toString(),true);
        mimeMessageHelper.setFrom("hufei1639670695@163.com");
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setTo("hufei1639670695@gmail.com");
        javaMailSender.send(mimeMessage);
    }
}
