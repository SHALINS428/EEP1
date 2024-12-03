package com.hphd.model;

import lombok.Data;

@Data
public class CategoryQuery {
    private Integer id; // sql where id = #{id}
    private Integer[] ids; // where id in (1,2,3)
    private String name;  // where like concat('%','变量值','%')
    private Integer status;
    private Integer parentId;
    private Integer pageNum;
    private Integer pageSize;

}
