package com.hugnew.sps.services.pay.util.web.unionpay.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 名称： 基础参数<br>
 * 功能： 提供基础数据<br>
 * 版本： 5.0<br>
 * 日期： 2014-07<br>
 * 作者： 中国银联ACP团队<br>
 * 版权： 中国银联<br>
 * 说明：以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己需要，按照技术文档编写。该代码仅供参考。<br>
 */
public class DemoBase {

    public static String encoding = "UTF-8";

    /**
     * 5.0.0
     */
    public static String version = "5.0.0";


    /**
     * http://localhost:8080/ACPTest/acp_front_url.do
     */
    //后台服务对应的写法参照 FrontRcvResponse.java
    //public static String frontUrl = "http://localhost:8080/ACPTest/acp_front_url.do";
    public DemoBase() {
        super();
    }

    /**
     * http://localhost:8080/ACPTest/acp_back_url.do
     */
//后台服务对应的写法参照 BackRcvResponse.java
    //public static String backUrl = "http://localhost:8080/ACPTest/acp_back_url.do";// 受理方和发卡方自选填写的域[O]--后台通知地址

    /**
     * 构造HTTP POST交易表单的方法示例
     *
     * @param action  表单提交地址
     * @param hiddens 以MAP形式存储的表单键值
     * @return 构造好的HTTP POST交易表单
     */
    public static String createHtml(String action, Map<String, String> hiddens) {
        StringBuilder sf = new StringBuilder();
        sf.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body>");
        sf.append("<form id = \"pay_form\" action=\"" + action
                + "\" method=\"post\">");
        if (null != hiddens && 0 != hiddens.size()) {
            Set<Entry<String, String>> set = hiddens.entrySet();
            Iterator<Entry<String, String>> it = set.iterator();
            while (it.hasNext()) {
                Entry<String, String> ey = it.next();
                String key = ey.getKey();
                String value = ey.getValue();
                sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\""
                        + key + "\" value=\"" + value + "\"/>");
            }
        }
        sf.append("</form>");
        sf.append("</body>");
        sf.append("<script type=\"text/javascript\">");
        sf.append("document.all.pay_form.submit();");
        sf.append("</script>");
        sf.append("</html>");
        return sf.toString();
    }


    /**
     * 构造HTTP POST交易表单的方法示例
     *
     * @param action    表单提交地址
     * @param sParaTemp 以MAP形式存储的表单键值
     * @return 构造好的HTTP POST交易表单
     */
    public static String createParam(String action, Map<String, String> sParaTemp) {

        StringBuffer toRet = new StringBuffer();
        for (Map.Entry<String, String> entry : sParaTemp.entrySet()) {
            toRet.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        toRet.substring(0, toRet.length() - 1);
        return toRet.toString();

    }




}