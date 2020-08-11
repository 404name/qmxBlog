package com.qmx.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qmx.demo.entity.Email;

import java.util.List;

public interface EmailService extends IService<Email> {
    /**
     *
     * @Description 发送简单纯文字邮件
     * @param to 收件人地址
     * @param subject 邮件主题
     * @param content 邮件内容
     * @return boolean 成功返回true，失败返回false
     */
    boolean sendAttachmentMail(String to, String subject, String content);

    /**
     *
     * @Description 发送带单个或多个附件的邮件
     * @param to 收件人地址
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param filepath 包含附件路径地址的字符串数组
     * @return boolean 功返回true，失败返回false
     */
    boolean sendAttachmentMail(String to, String subject, String content, List filepath);
}
