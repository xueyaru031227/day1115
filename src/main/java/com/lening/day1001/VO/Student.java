package com.lening.day1001.VO;

import com.lening.day1001.bean.TStudent;
import lombok.Data;

/**
 * @author 段鑫
 * @version 1.0
 * @data 2022/10/1 19:30
 */
@Data
public class Student extends TStudent {
    private String name;
    private Integer age;
    private Integer sage;
}
