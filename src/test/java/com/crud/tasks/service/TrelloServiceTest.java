package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;
    @Mock
    private SimpleEmailService emailService;
    @Mock
    private AdminConfig adminConfig;

    @Test
    void shouldCreateNewCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "top", "1");
        CreatedTrelloCardDto sampleCreatedTrelloCardDto = new CreatedTrelloCardDto("1", "name", "shortUrl",
                new Badges(1, new AttachmentsByType()));

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(sampleCreatedTrelloCardDto);

        //When
        CreatedTrelloCardDto createdTrelloCardDto = trelloService.createTrelloCard(trelloCardDto);

        //Then
        assertThat(createdTrelloCardDto).isNotNull();
        assertThat(createdTrelloCardDto.getBadges().getVotes()).isNotNull();
        assertThat(createdTrelloCardDto.getBadges().getAttachments()).isNotNull();
        assertThat(createdTrelloCardDto.getId()).isNotNull();
        assertThat(createdTrelloCardDto.getName()).isNotNull();
        assertThat(createdTrelloCardDto.getShortUrl()).isNotNull();
    }


}
