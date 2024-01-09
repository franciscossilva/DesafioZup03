package Testes;

import org.example.Pessoa;
import org.example.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurmaTest {
    private Turma turma;

    @BeforeEach
    void setUp() {
        turma = new Turma();
    }

    @Test
    public void adicionarPessoas() throws Exception {
        //preparação
        Pessoa pessoa = new Pessoa(1, "Francisco");
        // ação
        turma.adicionarPessoa(pessoa);
        //verificação
        assertTrue(turma.getPessoas().contains(pessoa));
    }

    @Test
    public void removerTodasPessoas() throws Exception {
        //preparação
        Pessoa pessoa1 = new Pessoa(1, "Francisco");
        Pessoa pessoa2 = new Pessoa(2, "Joy");
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);
        // ação
        turma.removerTodasPessoas();
        //verificação
        assertTrue(turma.getPessoas().isEmpty());
    }

    @Test
    public void naoAdicionarInvalidos() {
        //preparação
        Pessoa pessoa = new Pessoa(1, "");

        // ação e verificação
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> turma.adicionarPessoa(pessoa), "pessoa inválida");
        assertEquals("Nome não pode ser vazio", exception.getMessage());
        assertTrue(turma.getPessoas().isEmpty());
    }

    @Test
    public void naoAdicionarDuplicadas() throws Exception {
        //preparação
        Pessoa pessoa1 = new Pessoa(1, "Francisco");
        Pessoa pessoa2 = new Pessoa(1, "Francisco");
        turma.adicionarPessoa(pessoa1);

        // ação e verificação
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> turma.adicionarPessoa(pessoa2), "pessoa duplicada");
        assertEquals("Pessoa já está na turma", exception.getMessage());
        assertEquals(1, turma.getPessoas().size());
    }
}
