package com.yiscn.model;

import com.yiscn.entity.ScUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 *    匹配成功返回对象
 *
 * @author wangj
 * @date 2018/7/9 16:31
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchIngSuccessVo {

    private Integer roomId;

    private ScUser enemyUser;

    private List<SubjectVo> iusse;

}
