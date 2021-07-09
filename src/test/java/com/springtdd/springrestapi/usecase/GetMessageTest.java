package com.springtdd.springrestapi.usecase;

import entity.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.MessageRepository;
import response.MessageResponse;
import usecase.GetMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
public class GetMessageTest {

    private GetMessage getMessage;
    @Mock
    private MessageRepository repository;

    @BeforeEach
    public void setUp() {
        getMessage = new GetMessage(repository);
    }

    @Test
    @DisplayName("Should check if we can get a message content")
    public void canGetASavedMessage() throws Exception {
        Message message = new Message();
        message.setContent("content");
        message.setId(1L);
        repository.save(message);
        given(repository.findMessageById(1L)).willReturn(new Message("content"));
        MessageResponse response = getMessage.getMessage(1L);
        assertEquals(response.getStatement(), "content");
    }

}
