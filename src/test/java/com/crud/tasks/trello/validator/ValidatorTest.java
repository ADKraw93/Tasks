package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    void shouldFilterBoards() {
        //Given
        List<TrelloBoard> listOfTrelloBoards = new ArrayList<>();
        listOfTrelloBoards.add(new TrelloBoard("1", "test", new ArrayList<>()));
        //When
        List<TrelloBoard> resultList = trelloValidator.validateTrelloBoards(listOfTrelloBoards);
        //Then
        assertEquals(0, resultList.size());
    }
}
