package com.example.prisoner.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Paginate {
    private int start;
    private int length;
}