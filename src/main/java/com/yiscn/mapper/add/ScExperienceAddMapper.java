package com.yiscn.mapper.add;

import com.yiscn.entity.ScExperience;
import com.yiscn.entity.ScUserExample;
import com.yiscn.model.ScUserExperienceVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ScExperienceAddMapper {

    @Insert("<script>insert into sc_experience ( userId, mouth," +
            "    level, paragraph, heightVictory," +
            "    nowVictory, allField, winField," +
            "    winRate, experience, rank" +
            "    ) values" +
            "    <foreach separator=\",\" index=\"index\" item=\"item\" collection=\"list\">" +
            "     ( #{item.userid,jdbcType=INTEGER}, #{item.mouth,jdbcType=INTEGER}," +
            "    #{item.level,jdbcType=INTEGER}, #{item.paragraph,jdbcType=INTEGER}, #{item.heightvictory,jdbcType=INTEGER}," +
            "    #{item.nowvictory,jdbcType=INTEGER}, #{item.allfield,jdbcType=INTEGER}, #{item.winfield,jdbcType=INTEGER}," +
            "    #{item.winrate,jdbcType=VARCHAR}, #{item.experience,jdbcType=INTEGER}, #{item.rank,jdbcType=INTEGER}" +
            "    )" +
            "    </foreach></script>")
    Integer bacthAdd(List<ScExperience> scExperiences);

    @Select("SELECT " +
            "u.id,u.nickName,u.gender,u.city,u.head, " +
            "e.mouth,e.`level`,e.paragraph,e.heightVictory, " +
            "e.nowVictory,e.allField,e.winField,e.winRate, " +
            "e.experience,e.rank " +
            "FROM " +
            "sc_experience AS e " +
            "LEFT JOIN sc_user AS u ON e.userId = u.id " +
            "WHERE " +
            "e.mouth = #{mouth} "+
            "ORDER BY rank ")
    @Results({
            @Result(property = "id", column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "nickname", column = "nickname", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "gender", column = "gender", javaType = Boolean.class, jdbcType = JdbcType.BOOLEAN),
            @Result(property = "city", column = "city", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "head", column = "head", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "mouth", column = "mouth", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "level", column = "level", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "paragraph", column = "paragraph", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "heightVictory", column = "heightVictory", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "nowVictory", column = "nowVictory", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "allField", column = "allField", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "winField", column = "winField", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "winRate", column = "winRate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "experience", column = "experience", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "rank", column = "rank", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    List<ScUserExperienceVo> getList(@Param("mouth") Integer mouth);

    @Select("SELECT" +
            "u.id,u.nickName,u.gender,u.city,u.head," +
            "e.mouth,e.`level`,e.paragraph,e.heightVictory," +
            "e.nowVictory,e.allField,e.winField,e.winRate," +
            "e.experience,e.rank" +
            "FROM" +
            "sc_experience AS e" +
            "LEFT JOIN sc_user AS u ON e.userId = u.id" +
            "<where> 1=1 " +
            "<if test=\" mouth!=null and mouth !='' \">" +
            "and e.mouth = #{mouth jdbcType=INTEGER}" +
            "</if>" +
            "<if test=\" userId!=null and userId !='' \">\" +" +
            "and e.userId = #{userId jdbcType=INTEGER}" +
            "</if>" +
            "<where>")
    @Results({
            @Result(property = "id", column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "nickname", column = "nickname", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "gender", column = "gender", javaType = Boolean.class, jdbcType = JdbcType.BOOLEAN),
            @Result(property = "city", column = "city", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "head", column = "head", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "mouth", column = "mouth", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "level", column = "level", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "paragraph", column = "paragraph", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "heightVictory", column = "heightVictory", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "nowVictory", column = "nowVictory", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "allField", column = "allField", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "winField", column = "winField", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "winRate", column = "winRate", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "experience", column = "experience", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "rank", column = "rank", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    ScUserExperienceVo getOne(@Param("mouth")Integer mouth, @Param("userId")Integer userId);
}
