package com.qmx.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.qmx.demo.entity.Email;
import com.qmx.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class EmailServiceImpl implements EmailService {
    //从application.properties配置文件中注入发送者的邮件地址
    @Value("${spring.mail.username}")
    private String fromEmail;

    //注入spring发送邮件的对象
    @Autowired
    private JavaMailSender javaMailSender;

//    这里就是单单的最简单的邮件发送功能
    @Override
    public boolean sendAttachmentMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(fromEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try {
            javaMailSender.send(simpleMailMessage);  		//执行发送
        } catch (Exception e) {
            return false;
        }
        return true;
    }

//    虽然重置密码可能用不到附件的路径功能，不过还是保留好了
    @Override
    public boolean sendAttachmentMail(String to, String subject, String content, List filepath) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            helper.setFrom(fromEmail);
            if(filepath.size()>0){						//读取附件文件（传入文件路径）
                for (Object string : filepath) {		//遍历文件数组，实现多个附件的添加
                    FileSystemResource file = new FileSystemResource(string.toString());
                    String fileName = file.getFilename();//获取文件名
                    helper.addAttachment(fileName, file);//参数：文件名，文件路径
                }
                try {
                    javaMailSender.send(mimeMessage);		//发送邮件
                } catch (Exception e) {
                    return false;						//发送出现异常(或者文件路径不对)
                }
                return true;							//成功发送
            }else {
                return false;    						//没有附件文件（中断发送）
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            //捕获到创建MimeMessageHelper的异常
//			return false;
        }
        return true;
    }

    @Override
    public boolean save(Email entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<Email> entityList) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<Email> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Email> entityList) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Email> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Email> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(Email entity) {
        return false;
    }

    @Override
    public boolean update(Wrapper<Email> updateWrapper) {
        return false;
    }

    @Override
    public boolean update(Email entity, Wrapper<Email> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Email> entityList) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Email> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Email entity) {
        return false;
    }

    @Override
    public Email getById(Serializable id) {
        return null;
    }

    @Override
    public List<Email> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<Email> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Email getOne(Wrapper<Email> queryWrapper) {
        return null;
    }

    @Override
    public Email getOne(Wrapper<Email> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Email> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Email> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int count(Wrapper<Email> queryWrapper) {
        return 0;
    }

    @Override
    public List<Email> list(Wrapper<Email> queryWrapper) {
        return null;
    }

    @Override
    public List<Email> list() {
        return null;
    }

    @Override
    public <E extends IPage<Email>> E page(E page, Wrapper<Email> queryWrapper) {
        return null;
    }

    @Override
    public <E extends IPage<Email>> E page(E page) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Email> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return null;
    }

    @Override
    public List<Object> listObjs() {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public List<Object> listObjs(Wrapper<Email> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<Email> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<Email> queryWrapper) {
        return null;
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return null;
    }

    @Override
    public BaseMapper<Email> getBaseMapper() {
        return null;
    }

    @Override
    public QueryChainWrapper<Email> query() {
        return null;
    }

    @Override
    public LambdaQueryChainWrapper<Email> lambdaQuery() {
        return null;
    }

    @Override
    public UpdateChainWrapper<Email> update() {
        return null;
    }

    @Override
    public LambdaUpdateChainWrapper<Email> lambdaUpdate() {
        return null;
    }

    @Override
    public boolean saveOrUpdate(Email entity, Wrapper<Email> updateWrapper) {
        return false;
    }
}
