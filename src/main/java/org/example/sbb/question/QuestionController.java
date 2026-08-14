package org.example.sbb.question;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor

public class QuestionController {

//    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    @GetMapping("/question/list")
//    @ResponseBody
    public String list(Model model) {
//        List<Question> questionsList = this.questionRepository.findAll();
        List<Question> questionsList = this.questionService.getList();
        model.addAttribute("questionList",questionsList);
        return "question_list"; //question_list.html return
    }
}
