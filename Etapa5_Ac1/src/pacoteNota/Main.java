package pacoteNota;

public class Main {

	// Método principal para testar a classe
    public static void main(String[] args) {
        // Aluno de disciplina presencial com 2 notas
        double[] notas1 = {7.5, 8.0};
        Universidade aluno1 = new Universidade("João", "RA123456", notas1, 80.0);
        aluno1.imprimirSituacao(); // Aprovado (nota 7.75, presença 80%)

        System.out.println();

        // Aluno de disciplina presencial com 4 notas
        double[] notas2 = {6.0, 7.0, 8.0, 9.0};
        Universidade aluno2 = new Universidade("Maria", "RA654321", notas2, 70.0);
        aluno2.imprimirSituacao(); // Reprovado (nota 7.65, presença 70%)

        System.out.println();

        // Aluno de disciplina EAD com 3 notas
        double[] notas3 = {4.0, 6.0, 8.0};
        Universidade aluno3 = new Universidade("Pedro", "RA789456", notas3);
        aluno3.imprimirSituacao(); // Aprovado (nota 6.57)

        System.out.println();

        // Aluno de disciplina presencial com 3 notas (e reprovado por presença)
        double[] notas4 = {8.0, 8.5, 9.0};
        Universidade aluno4 = new Universidade("Ana", "RA987654", notas4, 74.0);
        aluno4.imprimirSituacao(); // Reprovado (nota 8.5, presença 74%)
    }
}
