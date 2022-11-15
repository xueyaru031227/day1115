package com.lening.day1001.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author 段鑫（乐柠教育）
 * @since 2022-10-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TStudent对象", description="")
@TableName("t_student")
public class TStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;
  @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Integer cid;
   @TableField(exist = false)

    private TGrade tGrade;
    @TableField(exist = false)
    private List<TCourse> tCourses;
    @TableField(exist = false)
    private List<Long>ids;


}
