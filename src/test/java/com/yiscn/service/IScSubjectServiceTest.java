package com.yiscn.service;

import com.yiscn.entity.ScOption;
import com.yiscn.model.ScOptionDto;
import com.yiscn.model.ScSubjectDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScSubjectServiceTest {

    @Autowired
    private IScSubjectService scSubjectService;

    @Test
    public void randomIusse() {

        Calendar cale = Calendar.getInstance();
        int month = cale.get(Calendar.MONTH) ;
        System.out.println(month);

    }

    @Test
    public void add() {

        ScSubjectDto scSubjectDto = new ScSubjectDto();
        scSubjectDto.setAnswer(3);
        scSubjectDto.setContributor("王键");
        scSubjectDto.setGrade(2);
        scSubjectDto.setQuiz("从抹香鲸体内提炼出的香料是？");
        scSubjectDto.setSchool("文科");
        scSubjectDto.setType(4);
        List<ScOption> scOptions = new ArrayList<>();

        ScOption scOptionDto1 = new ScOption();
        ScOption scOptionDto2 = new ScOption();
        ScOption scOptionDto3 = new ScOption();
        ScOption scOptionDto4 = new ScOption();

        scOptionDto1.setAnswer("檀香");
        scOptionDto1.setOptionNum(1);
        scOptions.add(scOptionDto1);

        scOptionDto2.setAnswer("麝香");
        scOptionDto2.setOptionNum(2);
        scOptions.add(scOptionDto2);

        scOptionDto3.setAnswer("龙涎香");
        scOptionDto3.setOptionNum(3);
        scOptions.add(scOptionDto3);

        scOptionDto4.setAnswer("熏香");
        scOptionDto4.setOptionNum(4);
        scOptions.add(scOptionDto4);

        scSubjectDto.setScOptions(scOptions);

        Integer add = scSubjectService.add(scSubjectDto);
        System.out.println(add);
    }
}