package com.damo.examsys;

import com.damo.examsys.entity.Paper;
import com.damo.examsys.service.PaperService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liujiulong
 * @date 2019/10/17  17:40:00
 */
public class PaperServiceTest extends ExamsysApplicationTests {

    @Autowired
    private PaperService paperService;

    @Test
    public void testAdd() {
        Paper paper = new Paper();
        paper.setPaperName("数学一模");
        paper.setAllowTime(90);
        paper.setScore(100);
        paper.setSubjectId(1);
        paper.setChoiceNum(6);
        paper.setCompletionNum(10);
        paper.setShortAnswerNum(5);

        System.out.println(paper);

        paperService.add(paper);

    }
}
