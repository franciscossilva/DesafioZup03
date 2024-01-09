package Testes;

import org.example.Main;
import org.example.Pessoa;
import org.example.Turma;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private Main main;

    @Test
    @BeforeEach
    public void TestedeAdicionarPessoas() throws Exception {
        Turma turma = new Turma();
        //preparação
        Pessoa pessoa1 = new Pessoa(1, "Fulano");
        Pessoa pessoa2 = new Pessoa(2, "Beltrano");
        Pessoa pessoa3 = new Pessoa(3, "Ciclano");
        // ação
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);
        turma.adicionarPessoa(pessoa3);
        //verificação
        assertEquals(3, turma.getPessoas().size());
    }
}