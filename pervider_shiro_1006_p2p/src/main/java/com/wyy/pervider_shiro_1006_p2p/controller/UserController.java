package com.wyy.pervider_shiro_1006_p2p.controller;

import com.wyy.common_p2p.constant.CommonConstant;
import com.wyy.common_p2p.entity.sys.User;
import com.wyy.common_p2p.utils.*;
import com.wyy.pervider_shiro_1006_p2p.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * (User)表控制层
 *
 * @author cpc
 * @since 2019-10-17 16:33:34
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Autowired(required = false)
    private RedisUtil redisUtil;


    /**
     *redis模板
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    /**
     * 用户登录
     * @return
     */
    @PostMapping("login")
    public R login(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response){
//        //获取用户输入的验证码
//        String userVerificationCode = request.getParameter("verificationCode");
//        //验证码是否正确
//        String userJwt = request.getHeader(CommonConstant.JWT_VERIFICATION_KEY);
//        //获取到保存在redis中的验证码
//        Object redisVerificationCode =  redisTemplate.opsForValue().get(CommonConstant.VERIFICATION_PREFIX + userJwt) ;
//
//        if(StringUtils.isEmpty(redisVerificationCode)){
//            return R.error("你的验证码已超时");
//        }
//
//        if(!redisVerificationCode.toString().equalsIgnoreCase(userVerificationCode)){
//            return R.error("验证码错误");
//        }
        //这是获取到用户名和密码
        String userName = params.get("userName").toString();
        String userPassword  = params.get("password").toString();

        //更具姓名找用户
        User user = userService.queryByName(userName);
        if(user == null){
            return R.error("用户名或密码错误");
        }

        //密码校验
//        if(PasswordHelper.checkCredentials(userPassword, user.getSalt(), user.getPassword())){
            //密码校验通过发令牌
            HashMap hashMap = new HashMap();
            hashMap.put("userId", user.getUserId());
            hashMap.put("userName", userName);
//            hashMap.put("password", user.getPassword());
            //生成jwt令牌
            String jwt = JwtUtils.createJwt(hashMap, CommonConstant.JWT_WEB_TTL);
            //将用户名和密码放入到请求头域中
            response.setHeader(CommonConstant.JWT_HEADER_KEY, jwt);
            //将jwt令牌保持到 redis中
            redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + jwt, jwt);
            //这里设置失效时长
            redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + jwt, JwtUtils.JWT_WEB_TTL / 1000);
            //返回请求成功
            return R.ok("登录成功");
//        } else{
//            return R.error("用和名或密码错误");
//        }

    }



    /**
     * 这是退出登录的方法
     * @param request
     * @return
     */
    @PostMapping("logout")
    public R logout(HttpServletRequest request){
        //去redis中将数据给清空掉就ok了
        String toke = request.getHeader(CommonConstant.JWT_HEADER_KEY);
        //将redis中的数据给删掉就ok了
        redisTemplate.delete(CommonConstant.PREFIX_USER_TOKEN + toke);
        return R.ok();
    }



    /**
     * 这是查询用户信息
     * @param params
     * @return
     */
    @GetMapping("quyerPages")
    public PageUtils quyerPages(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<User> users = userService.queryPager(query);
        return new PageUtils(users, query.getTotal());
    }


    /**
     * 生成验证码图片
     * @param req
     * @param resp
     * @return
     * @throws IOException
     */
    @GetMapping("verificationCode")
    public String verificationCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //生成验证码随机数
        String word = VerifyCodeUtil.produceNumAndChar(4);
//        获取用户的jwt令牌
        String userVerificationJwt = req.getHeader(CommonConstant.JWT_VERIFICATION_KEY);
        //验证码令牌
        Claims claims = JwtUtils.validateJwtToken(userVerificationJwt);
        if(claims == null){
            //如果用户令牌过期那么对应存放在redis中的数据也要清空
            if(!StringUtils.isEmpty(userVerificationJwt)){
                redisTemplate.expire(CommonConstant.VERIFICATION_PREFIX + userVerificationJwt, 1, TimeUnit.DAYS);
            }
            userVerificationJwt =  JwtUtils.createJwt(new HashMap<String, Object>() ,JwtUtils.JWT_WEB_TTL);
            //将jwt令牌放入 response head中
            resp.setHeader(CommonConstant.JWT_VERIFICATION_KEY, userVerificationJwt);
        }
        //刷新缓存，更新验证码
        redisTemplate.opsForValue().set(CommonConstant.VERIFICATION_PREFIX  + userVerificationJwt , word,60, TimeUnit.SECONDS);
        //生成图片
        String code = "data:image/png;base64," + ImageUtil.createImageWithVerifyCode(word, 116,40);;
        return code;
    }

    /**
     * 这是用户信息添加
     * @param user 添加用户对象
     * @return
     */
    @PostMapping("add")
    public R add(User user, String roleIds) {
        //生成随机盐
        String salt = PasswordHelper.createSalt();
        //这是将加密后的密码放入到user对象中去
        user.setPassword(PasswordHelper.createCredentials(user.getPassword(), salt));
        //这是将盐放入到用户对象中去
        user.setSalt(salt);
        //设置创建时间
        user.setCreatedate(new Date());
        //添加用户信息
        return R.update(userService.insert(user, roleIds));
    }


    /**
     * 删除用户信息
     * @return
     */
    @PostMapping("del/{userId}")
    public R del(@PathVariable("userId") Integer userId){
        return R.update(userService.deleteById(userId));
    }


    /**
     * 这是修改用户密码
     * @param user
     * @return
     */
    @PostMapping("updatePwd")
    public R updatePwd(User user){
        //生成随机盐
//        String salt = PasswordHelper.createSalt();
//        //这是将加密后的密码放入到user对象中去
//        user.setPassword(PasswordHelper.createCredentials(user.getPassword(), salt));
//        //设置用户当前的盐
//        user.setSalt(salt);
        return R.update(userService.updatePwd(user));
    }

    /**
     * 这是修改用户信息
     * @param user
     * @return
     */
    @PostMapping("update")
    public R update(User user, String roleIds){
        //防止恶意工具修改密码
        user.setPassword(null);
        user.setSalt(null);
        return R.update(userService.update(user, roleIds));
    }
}

