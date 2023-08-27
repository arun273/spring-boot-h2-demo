package com.database.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {

    private long id;
    private String title;
    private String description;
    private boolean published;


}
