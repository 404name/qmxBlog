package com.qmx.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qmx.demo.controller.EmailController;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.entity.User;
import com.qmx.demo.mapper.CommentMapper;
import com.qmx.demo.mapper.PostingMapper;
import com.qmx.demo.mapper.UserMapper;
import com.qmx.demo.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PostingMapper postingMapper;
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void test0(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    void test1(){
        List<Comment> commentList= commentMapper.selectList(null);
        commentList.forEach(System.out::println);
    }
    @Test
    void test2(){
        Posting posting = postingMapper.selectByPositngId(12);
        System.out.println(posting);
    }
    @Test
    void test3(){
        List<Posting> postings = postingMapper.selectAll();
        System.out.println("------------------------------------------");
        postings.forEach(System.out::println);
    }
    //  wrapper��ѯ
    @Test
    void select1(){
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("commentid",600,1000);
        queryWrapper.between("blogid",0,12);
        commentMapper.selectList(queryWrapper).forEach(System.out::println);
    }
    @Test
    void insert(){
        Comment comment = new Comment();
        comment.setCommentid(2);
        comment.setId(13);
        comment.setUsername("mybatis-plus");
        comment.setCommentcontent("????");
        System.out.println(comment.toString());
        int res = commentMapper.insert(comment);
    }
    //????????????????
    //Preparing:  UPDATE comment SET commentid=?, blogid=?, name=?, commentcontent=? WHERE id=?
    @Test
    void update(){
        Comment comment = new Comment();
        comment.setCommentcontent("eeeaaaeeeee");
        comment.setId(14);
        comment.setCommentid(920);
        comment.setCommentid(124);
        comment.setUsername("mybatis-aaeeea");
        commentMapper.updateById(comment);
    }

    //  map��ѯ
    @Test
    void select(){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("name","����");
        hashMap.put("commentcontent","1");
        List<Comment> commentList= commentMapper.selectByMap(hashMap);
        commentList.forEach(System.out::println);
    }

    @Test
    void delete(){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("commentid","920");
        int res = commentMapper.deleteByMap(hashMap);
    }
    @Test
    void delete1(){
        int res = commentMapper.deleteById(123);
    }
    //��ҳ
    @Test
    void page(){
        long now = 1;
        Page<Comment> page = new Page<>(now,5);
        commentMapper.selectPage(page,null);
        while(page.hasNext()){
            page.setCurrent(now);
            commentMapper.selectPage(page,null);
            System.out.println("��"+now+"ҳ��-------------------------------");
            page.getOrders().forEach(System.out::println);
            now++;
        }
    }
    @Autowired
    EmailController emailControllerl;
    @Test
    void emailTest(){
        int code = emailControllerl.makeAuthCode();
        String to = "1308964967@qq.com";
        String title = "启明星验证码";
        String content = "验证码如下:"+code+"</span>";
        boolean flag = emailControllerl.sendEmail(to,title,content);
        System.out.println(content);
        if(flag){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }
}
