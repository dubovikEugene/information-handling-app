package com.epam.jwd.logic.parser;

public interface Parser<T, E> {
    E parse(T t);
}
