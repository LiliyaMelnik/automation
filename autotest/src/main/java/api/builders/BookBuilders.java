package api.builders;

import api.dto.request.book.AddBookDto;
import api.dto.request.book.IsbnDto;

import java.util.List;

public class BookBuilders {

    public AddBookDto defaultBookDtoBuilder() {
        return AddBookDto.builder()
                .userId("0b160a17-abb7-4a78-bc0b-a8557dfddeb4")
                .collectionOfIsbns(List.of(IsbnDto.builder().isbn("9781449325862").build()))
                .build();
    }
}
