package com.simple.common.model.enums.converter;

import com.simple.system.model.enums.RequestMethod;
import com.simple.system.model.enums.ValueEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @param <E>
 *     mybatis枚举转换器抽象类，用于mybatis在与数据库交互时，将java的枚举类型转为对应的int,查询时根据Int转换为枚举型
 */
public  abstract class  AbstractEnumConverter<E extends Enum<E> & ValueEnum> extends BaseTypeHandler<E> {
    private Class<E> type;

    private E [] enums;

    public AbstractEnumConverter(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();

        if (this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
    }

    /*
    设置保存时获取枚举的值
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (type.isAssignableFrom(RequestMethod.class)) {
            preparedStatement.setString(i, (String) parameter.getValue());
        } else {
            preparedStatement.setInt(i, (Integer) parameter.getValue());
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型
//        Integer i = rs.getInt(columnName);
//        if (rs.wasNull()) {
//            return null;
//        }
        if (type.isAssignableFrom(RequestMethod.class)) {
            return locateEnumStatus(rs.getString(columnName));
        } else {
            return locateEnumStatus(rs.getInt(columnName));
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer i  = rs.getInt(columnIndex);
        if(rs.wasNull()) {
            return null;
        }else{
    // 根据数据库中的code值，定位enum子类
            return locateEnumStatus(i);
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer i  = cs.getInt(columnIndex);
        if(cs.wasNull()) {
            return null;
        }else{
    // 根据数据库中的code值，定位enum子类
            return locateEnumStatus(i);
        }
    }
    /*
    根据值获取对应枚举子类
     */
    private E locateEnumStatus(Object value) {
        for(E e:enums) {
            if(Objects.equals(e.getValue(), value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value +",请核对"+ type.getSimpleName());
    }
}
