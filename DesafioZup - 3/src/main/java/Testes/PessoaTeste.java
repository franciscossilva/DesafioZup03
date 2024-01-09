package Testes;

import org.example.Pessoa;
import org.junit.Assert;
import org.junit.Test;

public class PessoaTeste {

    @Test
    public void validarNomeEID() {
        //preparação
        int id = 22;
        String nome = "Francisco";

        // ação
        Pessoa pessoa = new Pessoa(id, nome);
        boolean resultado = pessoa.valido();

        //verificação
        Assert.assertTrue("Válido. O id e nome não podem ser vazios.", resultado);
    }

    @Test
    public void validarIDNegativo() {
        //preparação
        int id = -11;
        String nome = "";

        // ação
        Pessoa pessoa = new Pessoa(id, nome);
        boolean resultado = pessoa.valido();

        //verificação
        Assert.assertFalse("Inválido. O id não pode ser negativo.", resultado);
    }

    @Test
    public void validarNomeVazio() {
        //preparação
        int id = 22;
        String nome = "";

        // ação
        Pessoa pessoa = new Pessoa(id, nome);
        boolean resultado = pessoa.valido();

        //verificação
        Assert.assertFalse("Inválido. O nome não pode ser vazio.", resultado);
    }
}
