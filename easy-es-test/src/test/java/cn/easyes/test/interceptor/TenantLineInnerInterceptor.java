package cn.easyes.test.interceptor;


import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.springframework.stereotype.Component;

import cn.easyes.annotation.Intercepts;
import cn.easyes.annotation.Signature;
import cn.easyes.core.conditions.LambdaEsQueryWrapper;
import cn.easyes.core.conditions.interfaces.BaseEsMapper;
import cn.easyes.extension.context.Interceptor;
import cn.easyes.extension.context.Invocation;

/**
 * @author huangjy
 */
@Intercepts(
    {
        @Signature(type = BaseEsMapper.class, method = "select.*", args = {LambdaEsQueryWrapper.class}, useRegexp = true),
        @Signature(type = BaseEsMapper.class, method = "search", args = {SearchRequest.class, RequestOptions.class})
    //     @Signature(type = BaseEsMapper.class, method = "insert|update", args = {Object.class}, useRegexp = true),
    //     @Signature(type = BaseEsMapper.class, method = ".*ById", args = {Object.class}, useRegexp = true),
     }
)
@Component
public class TenantLineInnerInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("通过正则拦截方法测试");
        // if (arg instanceof LambdaEsQueryWrapper) {
        //     LambdaEsQueryWrapper wrapper = ((LambdaEsQueryWrapper) args[0]);
        //     wrapper.eq("tenantId", "1");
        //     return invocation.proceed();
        // }
        return invocation.proceed();
    }

}
