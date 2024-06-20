package Empresa;

import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertTrue;

public class DemoTest {

    @Test
    public void testValidarEntradaNomeGenero() {

        String inputValido = "João-Masculino,Maria-Feminino";


        List<Funcionarios> funcionarios = Demo.processarFuncionarios(inputValido);


        for (Funcionarios funcionario : funcionarios) {
            assertTrue(!funcionario.getNome().isEmpty());
            assertTrue(!funcionario.getGenero().isEmpty());
            assertTrue(funcionario.getGenero().equalsIgnoreCase("Masculino") ||
                    funcionario.getGenero().equalsIgnoreCase("Feminino"));
        }
    }

    @Test
    public void testFiltrarMulheres() {
        String input = "João-Masculino,Maria-Feminino,Pedro-Masculino,Ana-Feminino";
        List<Funcionarios> funcionarios = Demo.processarFuncionarios(input);


        List<Funcionarios> mulheresFiltradas = funcionarios.stream()
                .filter(f -> f.getGenero().equalsIgnoreCase("Feminino"))
                .collect(Collectors.toList());

        // Verificação: Verificar se a lista de mulheres filtradas contém apenas mulheres
        for (Funcionarios mulher : mulheresFiltradas) {
            assertTrue(mulher.getGenero().equalsIgnoreCase("Feminino"));
        }
    }
}
