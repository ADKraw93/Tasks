package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        Pattern kodillaPattern = Pattern.compile("Kodilla");

        trelloBoards.stream()
                .filter(t -> t.getId()!=null)
                .filter(t -> t.getName()!=null)
                .filter(t -> kodillaPattern.matcher(t.getName()).find()) //t -> t.getName().kodillaPattern.asPredicate()
                .forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
        });
    }
}
