package pers.yurwisher.dota2.common.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import pers.yurwisher.wisp.utils.NumberUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * @author yq
 * @date 2018/12/05 14:59
 * @description 数字格式化,保留2为小数
 * @since V1.0.0
 */
public class BigDecimalSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type type, int i) throws IOException {
        SerializeWriter out = serializer.out;
        BigDecimal value = (BigDecimal) object;
        if (value == null) {
            out.writeNull();
        }else {
            out.writeString(NumberUtils.round2(value).toString());
        }
    }
}
