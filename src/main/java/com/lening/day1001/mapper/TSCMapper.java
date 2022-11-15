package com.lening.day1001.mapper;

import com.lening.day1001.bean.TSC;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 段鑫（乐柠教育）
 * @since 2022-10-01
 */
@Mapper
public interface TSCMapper extends BaseMapper<TSC> {
      List<TSC>selectTSC(Integer sid);
}
