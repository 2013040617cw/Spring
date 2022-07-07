package com.cuiwei.service;

public interface AccountService {
    /**
     * 切入点，要进行拦截增强的方法（目标方法
     */
    public void transfer();
}
