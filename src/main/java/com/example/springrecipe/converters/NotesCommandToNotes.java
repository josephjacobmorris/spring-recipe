package com.example.springrecipe.converters;

import com.example.springrecipe.commands.NotesCommand;
import com.example.springrecipe.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Override
    public Notes convert(NotesCommand source) {
        Notes notes = new Notes();
        notes.setRecipeNotes(source.getRecipeNotes());
        notes.setId(source.getId());
        return notes;
    }
}
