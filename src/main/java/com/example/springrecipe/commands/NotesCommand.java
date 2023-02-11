package com.example.springrecipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NotesCommand {
    private Long id;
    private String recipeNotes;
}
