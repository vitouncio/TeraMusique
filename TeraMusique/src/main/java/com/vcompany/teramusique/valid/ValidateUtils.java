/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vcompany.teramusique.valid;

import com.vcompany.teramusique.model.Pessoa;
import com.vcompany.teramusique.model.dao.PessoaDAO;

/**
 *
 * @author vitor
 */
public class ValidateUtils {
    public boolean validateLogin(String email, String senha) throws Exception {
        PessoaDAO Pdao = new PessoaDAO();
        try {
            Pessoa p = Pdao.findByEmail(email);

            if (p != null) {
                if (p.getEmail().equals(email) && p.getSenha().equals(senha)) {
                    return true;
                }
            }
        } catch (Exception e) {
            // Trate exceções aqui, se necessário
            throw new Exception("Ocorreu um erro ao validar o login.");
        }

        return false;

    }


}
