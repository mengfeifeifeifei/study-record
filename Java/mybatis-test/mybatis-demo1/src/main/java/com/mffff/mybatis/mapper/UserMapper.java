package com.mffff.mybatis.mapper;

public interface UserMapper {

    /**
     * 保持两个一致（通过mapper和mapper映射文件对比来看）：
     * 1.映射文件xml的namespace要和mapper接口的全类名保持一致
     * 2.定义的名称要和映射文件xml的id值保持一致
     * @return
     */
    int insertUser();
}
