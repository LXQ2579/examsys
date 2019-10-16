package com.damo.examsys.common;

public class ErrorCode {
    private int code;
    private String msg;

    // success
    public static int SUCCESS = 0;
    // 服务器异常
    public static int SERVER_ERROR = 500;

    // 登录密码不能为空
    public static int PASSWORD_EMPTY = 1001;
    // 手机号不能为空
    public static int PHONE_EMPTY = 1002;
    // 手机号不存在
    public static int PHONE_ERROR = 1003;
    // 密码错误
    public static int PASSWORD_ERROR = 1004;
    // 用户未登录
    public static int USER_NO_LOGIN = 1005;

    // 秒杀完毕
    public static int SECKILL_FINISH = 3001;
    // 不能重复秒杀
    public static  int SECKILL_REPEATE = 3002;
    // 秒杀失败
    public static int SECKILL_FAIL = 3003;

    // 生成静态页面错误
    public static int CREATE_HTML_ERROR = 4001;

    // 生成静态页面错误
    public static int STUDENT_NULL = 1920;

    //不能为空
    public static int MENUID_NULL=9001;

    //不能为空
    public static int MENU_NULL=9002;
}
