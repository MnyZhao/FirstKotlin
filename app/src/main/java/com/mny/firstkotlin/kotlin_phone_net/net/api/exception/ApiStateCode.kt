package com.mny.firstkotlin.kotlin_phone_net.net.api.exception

class ApiStateCode {
    companion object {
        /**
         * 正常状态码
         */
        const val SUCCESS_CODE = "200"
        /**
         * 手机号码为空
         */
        const val PHONE_NUMBER_EMPTY = "201"
        /**
         *错误的手机号码
         */
        const val PHONE_ERROR = "202"
        /**
         * 没有查询到结果
         */
        const val PHONE_RESULT_NULL = "203"
        /**
         * 错误的请求KEY
         */
        const val KEY_ERROR = "10001"
        /**
         * 该KEY无请求权限
         */
        const val KEY_NO_PEREMISSION = "10002"
        /**
         * key 过期
         */
        const val KEY_EXPIRE = "10003"
        /**
         * 错误的OPENID
         */
        const val ERROR_OPEN = "10004"
        /**
         * 应用未审核超时，请提交认证
         */
        const val APP_TIME_OUT = "10005"
        /**
         * 未知的请求源
         */
        const val UNKNOW_REQUEST = "10007"
        /**
         * 被禁止的IP
         */
        const val IP_PROHIBIT = "10008"
        /**
         * 被禁止的KEY
         */
        const val KEY_PROHIBIT = "10009"
        /**
         * 当前IP请求超过限制
         */
        const val IP_ERROR = "10011"
        /**
         * 请求超过次数限制
         */
        const val ERROR_NUMBER_OF_QUESTOIN = "10012"
        /**
         * 测试KEY超过请求限制
         */
        const val KEY_EXCEED = "10013"
        /**
         * 系统内部异常(调用充值类业务时，请务必联系客服或通过订单查询接口检测订单，避免造成损失)
         */
        const val SYSTEM_ERROR = "10014"
        /**
         * 接口维护
         */
        const val API_MAINTAIN = "10020"
        /**
         * 接口停用
         */
        const val API_STOP = "10021"
    }
}