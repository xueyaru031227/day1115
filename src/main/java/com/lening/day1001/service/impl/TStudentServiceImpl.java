package com.lening.day1001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lening.day1001.VO.Student;
import com.lening.day1001.bean.TCourse;
import com.lening.day1001.bean.TGrade;
import com.lening.day1001.bean.TSC;
import com.lening.day1001.bean.TStudent;
import com.lening.day1001.mapper.TCourseMapper;
import com.lening.day1001.mapper.TGradeMapper;
import com.lening.day1001.mapper.TSCMapper;
import com.lening.day1001.mapper.TStudentMapper;
import com.lening.day1001.service.ITStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 段鑫（乐柠教育）
 * @since 2022-10-01
 */
@Service
public class TStudentServiceImpl extends ServiceImpl<TStudentMapper, TStudent> implements ITStudentService {
    @Autowired
    private TStudentMapper tStudentMapper;
    @Autowired
    private TCourseMapper tCourseMapper;
    @Autowired
    private TGradeMapper tGradeMapper;
    @Autowired
    private TSCMapper tscMapper;
    @Override
    public List<TStudent> selectAll(Student student) {
        QueryWrapper<TStudent> tStudentQueryWrapper = new QueryWrapper<TStudent>();
          tStudentQueryWrapper.like(!StringUtils.isEmpty(student.getName()),"name",student.getName());
          tStudentQueryWrapper.ge(!StringUtils.isEmpty(student.getAge()),"age",student.getAge());
          tStudentQueryWrapper.le(!StringUtils.isEmpty(student.getSage()),"age",student.getSage());
        List<TStudent> tStudents = tStudentMapper.selectList(tStudentQueryWrapper);
        for (TStudent tStudent : tStudents) {
            TGrade tGrade = tGradeMapper.selectById(tStudent.getCid());
            tStudent.setTGrade(tGrade);
            LambdaQueryWrapper<TSC> tscLambdaQueryWrapper = new LambdaQueryWrapper<>();
            tscLambdaQueryWrapper.eq(TSC::getSid,tStudent.getId());
            List<TSC> tscs = tscMapper.selectList(tscLambdaQueryWrapper);
            ArrayList<TCourse> tCourses = new ArrayList<>();
            for (TSC tsc : tscs) {
                TCourse tCourse = tCourseMapper.selectById(tsc.getCid());
                tCourses.add(tCourse);
            }
            tStudent.setTCourses(tCourses);
        }
        return tStudents;
    }
}
