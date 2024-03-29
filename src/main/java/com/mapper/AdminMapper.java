package com.mapper;

import com.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    Admin selectAdminById(String id);

    int updateAdmin(Admin admin);
}
