package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloMapperTest {

    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("1", "name1", new ArrayList<>()));
        trelloBoardsDto.add(new TrelloBoardDto("2", "name2", new ArrayList<>()));
        trelloBoardsDto.add(new TrelloBoardDto("3", "name3", new ArrayList<>()));

        //Then
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //When
        assertEquals(trelloBoards.size(), 3);
        assertEquals(trelloBoards.get(1).getClass(), TrelloBoard.class);
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "name1", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("2", "name2", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("3", "name3", new ArrayList<>()));

        //Then
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //When
        assertEquals(trelloBoardsDto.size(), 3);
        assertEquals(trelloBoardsDto.get(1).getClass(), TrelloBoardDto.class);
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("1", "name1", true));
        trelloListsDto.add(new TrelloListDto("2", "name2", false));
        trelloListsDto.add(new TrelloListDto("3", "name3", true));

        //Then
        List<TrelloList> trellolists = trelloMapper.mapToList(trelloListsDto);

        //When
        assertEquals(trellolists.size(), 3);
        assertEquals(trellolists.get(1).getClass(), TrelloList.class);
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "name1", true));
        trelloLists.add(new TrelloList("2", "name2", false));
        trelloLists.add(new TrelloList("3", "name3", true));

        //Then
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);

        //When
        assertEquals(trelloListsDto.size(), 3);
        assertEquals(trelloListsDto.get(1).getClass(), TrelloListDto.class);
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto();

        //Then
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //When
        assertEquals(trelloCard.getClass(), TrelloCard.class);
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "description", "top", "listId");

        //Then
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //When
        assertEquals(trelloCardDto.getClass(), TrelloCardDto.class);
    }
}
