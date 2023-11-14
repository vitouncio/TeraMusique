/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author vitor
 */
public class fileUtils {
    
    public static byte[] lerArquivoComoBytes(String caminhoArquivo) throws IOException {
        Path path = Paths.get(caminhoArquivo);
        return Files.readAllBytes(path);
    }
}
