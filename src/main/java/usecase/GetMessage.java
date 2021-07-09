package usecase;

import entity.Message;
import lombok.extern.log4j.Log4j2;
import repository.MessageRepository;
import response.MessageResponse;

@Log4j2(topic = "service")

public class GetMessage implements MessageProvider{

    private MessageRepository repository;
    private final static String ID_NOT_PROVIDED = "Message id not provided";
    private final static String ID_NOT_FOUND = "Message not found with a given id";

    public GetMessage(MessageRepository messageRepository) {
        this.repository = messageRepository;
    }

    @Override
    public MessageResponse getMessage(Long messageId) {
        if(messageId == null || messageId.equals("")) {
            log.error(ID_NOT_PROVIDED);
            throw new MessageProvider.idNotProvided(ID_NOT_PROVIDED);
        }
        Message message = repository.findMessageById(messageId);
        if(message == null) {
            log.info(String.format(ID_NOT_FOUND, messageId));
            throw new MessageProvider.idNotFound(ID_NOT_FOUND);
        }
        return MessageResponse.builder().statement(message.getContent()).build();
    }

    @Override
    public MessageResponse postMessage(Message message) {
        return MessageResponse.builder().statement(message.getContent()).build();
    }
}
