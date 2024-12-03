package com.hphd.model;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {

    @Alias("汽车编号")
    private Integer  id;
    private String name;
    private String img;
    private Integer seq;
    private Integer status;
    @Alias("父目录Id")
    private Integer parentId;

    @Alias("最新更信人")
    private String lastUpdateBy;
    private LocalDateTime lastUpdateTime;
}
