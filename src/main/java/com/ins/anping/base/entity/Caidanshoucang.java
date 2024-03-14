package com.ins.anping.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Caidanshoucang对象", description="")
public class Caidanshoucang implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "收藏菜单名")
    @TableField("CaiDanJSON")
    private String caidanjson;

    @ApiModelProperty(value = "用户名")
    @TableField("YongHuMing")
    private String yonghuming;


}
