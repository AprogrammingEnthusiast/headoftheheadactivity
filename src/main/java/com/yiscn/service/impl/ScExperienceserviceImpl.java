package com.yiscn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiscn.common.bean.CommonConfig;
import com.yiscn.common.bean.PageBean;
import com.yiscn.common.util.SpringBootLogger;
import com.yiscn.entity.ScExperience;
import com.yiscn.entity.ScExperienceExample;
import com.yiscn.entity.ScUser;
import com.yiscn.mapper.ScExperienceMapper;
import com.yiscn.mapper.add.ScExperienceAddMapper;
import com.yiscn.model.ScUserExperienceVo;
import com.yiscn.service.IScExperienceservice;
import com.yiscn.service.IScUserService;
import org.springframework.beans.BeanUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 *    用户历史经验接口
 *
 * @author wangj
 * @date 2018/7/26 10:44
 * @param
 * @return
 * Life is so short,do something to make yourself happy,such as coding
 */
@Service
public class ScExperienceserviceImpl implements IScExperienceservice {

    @Autowired
    private CommonConfig commonConfig;
    @Autowired(required = false)
    private ScExperienceAddMapper scExperienceAddMapper;
    @Autowired(required = false)
    private ScExperienceMapper scExperienceMapper;
    @Autowired
    private IScUserService scUserService;

    @Override
    public Integer bacthAdd() {

        //获取上一个月份 201806
        Calendar cale = Calendar.getInstance();
        int month = cale.get(Calendar.MONTH);
        int year = cale.get(Calendar.YEAR);

        Integer m = year*100+month;

        List<ScUser> list = scUserService.getList();
        AtomicInteger num = new AtomicInteger(1);
        List<ScExperience> scExperiences = list.stream().map(e -> {
            ScExperience scExperience = new ScExperience();
            BeanUtils.copyProperties(e,scExperience);
            scExperience.setUserid(e.getId());
            scExperience.setId(null);
            scExperience.setMouth(m);
            scExperience.setRank(num.get());
            num.incrementAndGet();
            return scExperience;
        }).collect(Collectors.toList());

        //上一个月的数据清零
        scUserService.batchUpdateTo0(list);

        //将数据转移到经验表中
        return scExperienceAddMapper.bacthAdd(scExperiences);
    }

    @Override
    public PageBean<ScUserExperienceVo> getPageBean(Integer mouth, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ScUserExperienceVo> list = scExperienceAddMapper.getList(mouth);
        PageInfo<ScUserExperienceVo> pageInfo = new PageInfo<>(list);
        return new PageBean<>(pageInfo);
    }

    @Override
    public ScUserExperienceVo getOneOld(Integer mouth, Integer userId) {
        return scExperienceAddMapper.getOne(mouth,userId);
    }

    @Override
    public List<ScExperience> getOne(Integer mouth, Integer userId) {
        ScExperienceExample example = new ScExperienceExample();
        ScExperienceExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        if(mouth != null && !"".equals(mouth)){
            criteria.andMouthEqualTo(mouth);
        }
        return scExperienceMapper.selectByExample(example);
    }

    @Override
    public String getPassDreamexport(Integer mouth, Integer size,String classPathRealPath) {

        PageBean<ScUserExperienceVo> pageBean = getPageBean(mouth, 1, size);
        //String fileDirPath = "/mnt/tomcat/apache-tomcat-8.5.30"+File.separator+"download";
        String fileDirPath = classPathRealPath+File.separator+"download";
        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        String fileName = "TheTop"+size+"ListIn"+mouth+"Mouth.xlsx";
        String filePath = fileDirPath+"/"+fileName;
        File file = new File(filePath);
        if(!file.exists()) {
            outputPass(pageBean.getList(), filePath);
        }
        return "download/"+fileName;
    }

    void outputPass(List<ScUserExperienceVo> list, String filePath){
        Workbook workBook = new SXSSFWorkbook(1000);
        // 生成一个表格
        Sheet sheet = workBook.createSheet();
        workBook.setSheetName(0, "sheet1");
        Row row0 = sheet.createRow(0);

        row0.createCell(0).setCellValue("排名");
        row0.createCell(1).setCellValue("昵称");
        row0.createCell(2).setCellValue("性别");
        row0.createCell(3).setCellValue("openId");
        row0.createCell(4).setCellValue("月份");
        row0.createCell(5).setCellValue("等级");
        row0.createCell(6).setCellValue("段位");
        row0.createCell(7).setCellValue("历史最高连胜");
        row0.createCell(8).setCellValue("当前连胜");
        row0.createCell(9).setCellValue("总场次");
        row0.createCell(10).setCellValue("胜场");
        row0.createCell(11).setCellValue("胜率");
        row0.createCell(12).setCellValue("经验");

        // 创建表格标题行 第一行
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Row row = sheet.createRow(i + 1);
            ScUserExperienceVo vo = list.get(i);

            row.createCell(0).setCellValue(i+1);
            row.createCell(1).setCellValue(vo.getNickname()==null?"":vo.getNickname());
            row.createCell(2).setCellValue(vo.getGender()?"男":"女");
            row.createCell(3).setCellValue(vo.getOpenid()==null?"":vo.getOpenid());
            row.createCell(4).setCellValue(vo.getMouth()==null?"":vo.getMouth().toString());
            row.createCell(5).setCellValue(vo.getLevel()==null?"":vo.getLevel().toString());
            row.createCell(6).setCellValue(vo.getParagraph()==null?"":vo.getParagraph().toString());
            row.createCell(7).setCellValue(vo.getHeightVictory()==null?"":vo.getHeightVictory().toString());
            row.createCell(8).setCellValue(vo.getNowVictory()==null?"":vo.getNowVictory().toString());
            row.createCell(9).setCellValue(vo.getAllField()==null?"":vo.getAllField().toString());
            row.createCell(10).setCellValue(vo.getWinField()==null?"":vo.getWinField().toString());
            row.createCell(11).setCellValue(vo.getWinRate()==null?"":vo.getWinRate().toString());
            row.createCell(12).setCellValue(vo.getExperience()==null?"":vo.getExperience().toString());

        }
        File output;
        try {
            output = new File(filePath);
            if (!output.exists()) {
                output.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(output);
            workBook.write(outStream);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            SpringBootLogger.error("导出历史排名异常", e);
        }
    }
}
