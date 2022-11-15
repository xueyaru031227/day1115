package com.lening.day1001.service;

import com.lening.day1001.VO.Student;
import com.lening.day1001.bean.TStudent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 段鑫（乐柠教育）
 * @since 2022-10-01
 */
public interface ITStudentService extends IService<TStudent> {
     List<TStudent>selectAll(Student student);

}
