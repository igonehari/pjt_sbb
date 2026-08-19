package org.example.sbb.question;

import org.example.sbb.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Url 프릭픽스
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();

        model.addAttribute("questionList", questionList);
        return "question_list";  // question_list.html  리턴 됨
    }

    @GetMapping("/detail/{id}")
    // @PathVariable
    public String detail(Model model,
                         @PathVariable("id") Integer id,
                         AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "question_form";
        }

        // ToDo: 질문을 저장한다 --> 수정시 아래줄 처럼 작성
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return  "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
}