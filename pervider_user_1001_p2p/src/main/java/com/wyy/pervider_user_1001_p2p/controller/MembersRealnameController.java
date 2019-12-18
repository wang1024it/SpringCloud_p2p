package com.wyy.pervider_user_1001_p2p.controller;


import com.wyy.common_p2p.entity.members.Members;
import com.wyy.common_p2p.entity.members.MembersRealname;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.Query;
import com.wyy.common_p2p.utils.R;
import com.wyy.pervider_user_1001_p2p.service.MembersRealnameService;
import com.wyy.pervider_user_1001_p2p.service.MembersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (MembersRealname)表控制层 身份证实名认证
 *
 * @author cpc
 * @since 2019-10-23 15:51:06
 */

@RestController
@RequestMapping("members/mem")
public class MembersRealnameController {
    /**
     * 服务对象
     */
    @Resource
    private MembersRealnameService membersRealnameService;

    @Resource
    private MembersService membersService;
    /**
     * 分页查询
     *
     * @param  params 请求参数集
     * @return 结果集封装对象 
     */
    @GetMapping("queryPager")
    public PageUtils queryPager(@RequestParam Map<String, Object> params) {
         Query query = new Query(params);
         List<MembersRealname> list = membersRealnameService.queryPager(query);
         return new PageUtils(list, query.getTotal());
    }

    /**
     * 添加字段项
     * @param membersrealname
     * @return
     */
//    @PostMapping("add")
//    @PostMapping("add")
//    public R add(MembersRealname membersrealname) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, ParseException {
//        //身份认证
//        JSONObject jsonObject = Authentication.verification(membersrealname.getIdNumber(), membersrealname.getRealname());
////        判断是否验证通过
//        Integer code = Integer.parseInt(jsonObject.getStr("showapi_res_code"));
//        if(code == 0){
//            JSONObject obj = new JSONObject(jsonObject.getStr("showapi_res_body"));
//            code = Integer.parseInt(obj.getStr("ret_code"));
//            if(code == 0){
//                //验证开始
//                membersrealname.setBornDate(DateUtils.parse(obj.getStr("birthday"), "yyyy-MM-dd"));
//                //这是地址
//                membersrealname.setAddress(obj.getStr("address"));
//                //这是性别
//                membersrealname.setSex(obj.getStr("sex"));
//                //设置申请时间
//                membersrealname.setApplyTime(new Date());
//                //设置申请人编号
//                membersrealname.setMembersId(JwtSession.getCurrentMembersId());
//                //修改当前用户的身份证认证状态
//                Members members = this.membersService.queryById(JwtSession.getCurrentMembersId());
//                //这是设置成带认证状态
//                members.setIsIdentityAuthentication(2);
//                this.membersService.update(members);
//                //添加审核
//                return R.update(this.membersRealnameService.insert(membersrealname));
//            }else {
//                return R.error(obj.getStr("msg"));
//            }
//        }else {
//            return R.error("您输入的证据号码获取名称错误，无法找到对应的数据");
//        }
//    }

    /**
     * 修改字段项
     * @param
     * @return
     */
    @PostMapping("update")
    public R update(MembersRealname membersRealname){
        //修改账户认证状态
         Integer state = membersRealname.getState();
        Members members = new Members();
        members.setId(membersRealname.getMembersId());
        members.setIsIdentityAuthentication(state);
        membersService.update(members);
        return R.update(this.membersRealnameService.update(membersRealname));
    }


    /////////////////////////////////////////// 我是身份证图片上传的代码 ////////////////////////////////////////////////
    /**
     * 文件上传 用于身份证的图片上传
     * @param picture
     * @param request
     * @return
     */
//    @RequestMapping("upload")
//    public R upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
//        try {
//            //生成图片名称
//            //获取原始文件名称(包含格式)
//            String originalFileName = picture.getOriginalFilename();
//            System.out.println("原始文件名称：" + originalFileName);
//            //获取文件类型，以最后一个`.`为标识
//            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
//            System.out.println("文件类型：" + type);
//            //获取文件名称（不包含格式）
//            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));
//
//            //设置文件新名称: 当前时间+文件名称（不包含格式）
//            Date d = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//            String date = sdf.format(d);
//            String fileName = date + name + "." + type;
//            System.out.println("新文件名称：" + fileName);
//            //上传图片
//            FileUtils.copyInputStreamToFile(picture.getInputStream(),new File("D://upload/"+fileName));
//            //图片上传成功返回图片访问地址
//            R r = R.ok("图片上车成功");
//            r.put("path", "/upload/" + fileName );
//            return r;
//        } catch (IOException e) {
//            return R.error("上传失败");
//        }
//    }


}