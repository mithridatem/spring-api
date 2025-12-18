package com.adrar.api.entity;

public class WrapNameOnly {

    private NameOnly nameOnly;
    public WrapNameOnly(NameOnly nameOnly)
    {
        this.nameOnly = nameOnly;
    }

    public String toString()
    {
        return nameOnly.getFirstname() + " " + nameOnly.getLastname();
    }
}
