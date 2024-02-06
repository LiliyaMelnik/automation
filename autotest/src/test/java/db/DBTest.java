package db;

import db.service.UserTable;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DBTest {

    private final UserTable userTable = new UserTable();

    @Test
    void shouldBeAddedAndUpdated() {
        userTable.deleteAllUsers();
        userTable.insertAlice();
        userTable.updateAlice();
        String username = userTable.getBen();
        assertThat(username).isEqualTo("Ben");

    }
    @Test
    void shouldBeAddedAndDeleteAlice() {
        userTable.deleteAllUsers();
        userTable.insertAlice();
        userTable.deleteAlice();
        String username = userTable.getAlice();
        assertThat(username).isEqualTo("");
    }
}
