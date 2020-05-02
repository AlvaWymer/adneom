package com.adneom.service;

import org.springframework.security.core.GrantedAuthority;

/**
 * @ClassName: GrantedAuthorityImpl
 * @Description: 权限类型，负责存储权限和角色
 * @Author: Yang Naihua
 * @Create: 2019-01-20 13:55
 **/
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
