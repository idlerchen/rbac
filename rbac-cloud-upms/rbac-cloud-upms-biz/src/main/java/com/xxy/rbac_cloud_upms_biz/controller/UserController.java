package com.xxy.rbac_cloud_upms_biz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xxy.common.core.util.R;
import com.xxy.common.security.annotation.Inner;
import com.xxy.common.security.utils.SecurityUtils;
import com.xxy.rbac.admin.api.entity.SysUser;
import com.xxy.rbac_cloud_upms_biz.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SysUserService userService;

    @GetMapping(value = "/info")
    public R info(){
        String userName = SecurityUtils.getUser().getUsername();
        SysUser user = userService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, userName));
        if(user == null){
            return R.failed("获取用户信息失败");
        }
        return R.ok(userService.getUserInfo(user));
    }
    /**
     * 获取指定用户全部信息
     *
     * @return 用户信息
     */
    @Inner
    @GetMapping("/info/{username}")
    public R info(@PathVariable String username) {
        SysUser user = userService.getOne(Wrappers.<SysUser>query()
                .lambda().eq(SysUser::getUsername, username));
        if (user == null) {
            return R.failed(String.format("用户信息为空 %s", username));
        }
        return R.ok(userService.getUserInfo(user));
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R user(@PathVariable Integer id){
        return R.ok(userService);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/details/{username}")
    public R user(@PathVariable String username) {
        SysUser condition = new SysUser();
        condition.setUsername(username);
        return R.ok(userService.getOne(new QueryWrapper<>(condition)));
    }

}
