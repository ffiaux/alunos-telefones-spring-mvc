package com.alunos.spring.util;

import java.util.UUID;

public class MatriculaUtil
{
    public static String gerarMatricula() 
    {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7);
    }
    
    public static String left(Integer number)
    {
    	return String.format("%010d" , number);
    }
}