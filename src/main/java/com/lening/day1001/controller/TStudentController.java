package com.lening.day1001.controller;


import com.lening.day1001.VO.Student;
import com.lening.day1001.bean.TCourse;
import com.lening.day1001.bean.TGrade;
import com.lening.day1001.bean.TStudent;
import com.lening.day1001.service.ITCourseService;
import com.lening.day1001.service.ITGradeService;
import com.lening.day1001.service.ITStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 段鑫（乐柠教育）
 * @since 2022-10-01
 */
@RestController
@RequestMapping("/tStudent")
public class TStudentController {

    @Autowired
    private ITStudentService itStudentService;
    @Autowired
    private ITGradeService itGradeService;
    @Autowired
    private ITCourseService itCourseService;

    @RequestMapping("/SelectAll")
    public List<TStudent>SelectAll(Student student){
        List<TStudent> tStudents = itStudentService.selectAll(student);
        return tStudents;
    }
    @RequestMapping("/insertStudent")
    public String insertStudent(@RequestBody TStudent tStudent){
        System.out.println(tStudent);
        try {
            itStudentService.getBaseMapper().insert(tStudent);
            return "增加成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "增加失败";
        }
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudent(Integer id){
        try {
             itStudentService.getBaseMapper().deleteById(id);
             return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }

    }
    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestBody TStudent tStudent){
        try {
            itStudentService.getBaseMapper().updateById(tStudent);
            return "修改成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }
    }
    @RequestMapping("/SelectGrade")
    public List<TGrade>SelectGrade(){
        List<TGrade> tGrades = itGradeService.getBaseMapper().selectList(null);
        return tGrades;
    }
    @RequestMapping("/selectcourse")
    public List<TCourse>selectcourse(){
        List<TCourse> tCourses = itCourseService.getBaseMapper().selectList(null);
        return tCourses;
    }

}

