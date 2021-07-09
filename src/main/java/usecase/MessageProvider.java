package usecase;

import entity.Message;
import response.MessageResponse;

public interface MessageProvider {
    MessageResponse getMessage(Long Id);
    MessageResponse postMessage(Message message);

    class idNotFound extends RuntimeException {
        public idNotFound(String idNotFound) {

        }
    }

    class idNotProvided extends RuntimeException {
        public idNotProvided(String idNotProvided) {

        }
    }
}
