package org.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    //    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String list(Model model) {
//        List<Question> questionList = this.questionRepository.findAll();
        List<Question> questionList = this.questionService.getList();

        // 중요 --> "questionList" 라는 이름이 html의 ${questionList}와 연결됨
        model.addAttribute("questionList", questionList);
        return "question_list";  // question_list.html  리턴 됨
    }

    @GetMapping("question/detail/{id}")
    // @PathVariable
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}