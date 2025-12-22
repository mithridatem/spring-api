package com.adrar.api.entity.filter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WrapNameOnly {

    private final NameOnly nameOnly;

    public String toString()
    {
        return nameOnly.getFirstname() + " " + nameOnly.getLastname();
    }
}
