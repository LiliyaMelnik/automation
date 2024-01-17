package api.step;

import api.builders.BookBuilders;
import api.config.Requests;
import api.dto.response.book.BookDto;
import api.endpoints.BookEndpoint;

import static api.config.RequestService.requestWithToken;
import static api.config.ResponseService.create;
import static api.config.ResponseService.delete;

public class BookSteps {

    Requests requests = new Requests();

    public BookDto addBookToUser() {
        return requests.post(requestWithToken(), new BookBuilders().defaultBookDtoBuilder(), BookEndpoint.ADD_BOOK.getBook())
                .then().spec(create()).extract().body().as(BookDto.class);
    }
    public void deleteBook() {
        requests.delete(requestWithToken(), BookEndpoint.DELETE_BOOK.getBook() + "0b160a17-abb7-4a78-bc0b-a8557dfddeb4")
                .then().spec(delete());
    }
}
