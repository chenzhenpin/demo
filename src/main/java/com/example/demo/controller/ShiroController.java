package com.example.demo.controller;

import com.example.demo.dataobject.ShiroEntity.ShiroUser;
import com.example.demo.form.LoginForm;
import com.example.demo.form.RegisterForm;
import com.example.demo.service.jpaService.ShiroService;
import com.example.demo.shiro.MD5toHash;
import com.example.demo.validator.LoginValidator;
import com.example.demo.validator.RegisterValidator;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Controller
public class ShiroController {
    @Autowired
    ShiroService shiroService;
    @Autowired
    RegisterValidator registerValidator;
    @Autowired
    LoginValidator loginValidator;

    @RequestMapping("loginForm")
    public String loginForm(LoginForm loginForm){
        return "LoginForm";
    }

   @PostMapping("/login")
   public String login(
           HttpServletRequest request,
           @Valid @ModelAttribute LoginForm loginForm,
           BindingResult result ){

       /*loginValidator.validate(loginForm, result);
       if(result.hasErrors()){
           return "LoginForm";
       }*/
       //shiro认证失败会在request shiroLoginFailure属性上标记；
       String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
       if (UnknownAccountException.class.getName().equals(exceptionClassName)){
           System.out.println("账号不存在");
           return "LoginForm";
       }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
           System.out.println("密码错误");
           return "LoginForm";
       }
       return "redirect:/success";

   }
    @RequestMapping("/success")
    public String success(Model model){
        model.addAttribute("name", "Dear");
        return "success";
    }


    @GetMapping("/register")
    public String showRegisterForm(RegisterForm registerForm){  //必须填写表单参数
        return "RegisterForm";
    }
    @PostMapping("/register")
    public String shiroRegister(
            @Valid @ModelAttribute RegisterForm registerForm,
            BindingResult result){
        //自定义校验

        registerValidator.validate(registerForm, result);
        if(result.hasErrors()){
            return "RegisterForm";
        }
        String name =registerForm.getName();
        String username =registerForm.getUsername();
        String password =registerForm.getPassword();
        String salt=username+"123";

        String md5pwd=new MD5toHash(password,salt).toMD5Hash().toString();

        ShiroUser user=new ShiroUser();
        user.setName(name);
        user.setUsername(username);
        user.setSalt(salt);
        user.setPassword(md5pwd);
        shiroService.registerUser(user);
        //model.addAttribute("user",user);
        return "redirect:/loginForm";

    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //session失效
        session.invalidate();
        return "LoginForm";

    }

    @RequestMapping("/validateCode")
    @ResponseBody
    public void  validateCode(HttpServletResponse response, HttpSession session){

        int width = 60;
        int height = 32;
        //create the image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        // set the background color
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, width, height);
        // draw the border
        g.setColor(Color.black);
        g.drawRect(0, 0, width - 1, height - 1);
        // create a random instance to generate the codes
        Random rdm = new Random();
        String hash1 = Integer.toHexString(rdm.nextInt());
        System.out.print(hash1);
        // make some confusion
        for (int i = 0; i < 50; i++) {
            int x = rdm.nextInt(width);
            int y = rdm.nextInt(height);
            g.drawOval(x, y, 0, 0);
        }
        // generate a random code
        String capstr = hash1.substring(0, 4);
        //将生成的验证码存入session
        session.setAttribute("validateCode", capstr);
        g.setColor(new Color(0, 100, 0));
        g.setFont(new Font("Candara", Font.BOLD, 24));
        g.drawString(capstr, 8, 24);
        g.dispose();
        //输出图片
        response.setContentType("image/jpeg");

        OutputStream strm;
        try {
            strm = response.getOutputStream();
            ImageIO.write(image, "jpeg", strm);
            strm.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
