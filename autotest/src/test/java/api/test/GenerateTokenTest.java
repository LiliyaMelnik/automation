package api.test;

import api.step.BookSteps;
import api.step.UserSteps;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class GenerateTokenTest {

    private final UserSteps userSteps = new UserSteps();
    private final BookSteps bookSteps = new BookSteps();

    @Test
    void addAndDeleteBook() {
        bookSteps.addBookToUser();
        var responseUser = userSteps.getUser();
        assertThat(responseUser.getBooks().get(0).getTitle()).isEqualTo("Git Pocket Guide");

        bookSteps.deleteBook();
        var finalResponse = userSteps.getUser();
        assertThat(finalResponse.getBooks()).isEqualTo(List.of());
    }
}
