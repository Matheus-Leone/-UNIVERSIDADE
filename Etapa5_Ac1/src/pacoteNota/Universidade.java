package pacoteNota;

public class Universidade {
    // Atributos privados
    private String nome;
    private String ra; // Registro Acadêmico (RA)
    private double[] notas;
    private double presenca; // Porcentagem de presença (em disciplinas presenciais)
    private boolean ead; // Indica se a disciplina é EAD

    // Construtor para disciplinas presenciais informando os atributos
    public Universidade(String nome, String ra, double[] notas, double presenca) {
        this.nome = nome;
        this.ra = ra;
        this.notas = notas;
        this.presenca = presenca;
        this.ead = false; // Disciplina não é EAD
    }

    // Construtor para disciplinas EAD (sem presença) informando os atributos
    public Universidade(String nome, String ra, double[] notas) {
        this.nome = nome;
        this.ra = ra;
        this.notas = notas;
        this.ead = true; // Disciplina é EAD
    }

    // Método para calcular a nota final
    public double calcularNotaFinal() {
        int numAvaliacoes = notas.length; //length vai somando a quantidade de notas para cair em algum IF e realizar a conta
        double notaFinal = 0.0;

        // Até 2 notas: média aritmética
        if (numAvaliacoes == 1 || numAvaliacoes == 2) {
            for (double nota : notas) {
                notaFinal += nota;
            }
            notaFinal /= numAvaliacoes; // Média aritmética

        // 3 notas: média ponderada
        } else if (numAvaliacoes == 3) {
            notaFinal = (notas[0] + notas[1] * 2 + notas[2] * 4) / 7.0; // Ponderação

        // 4 notas: fórmula específica
        } else if (numAvaliacoes == 4) {
            notaFinal = (notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45);
        }

        return notaFinal;
    }

    // Método para verificar aprovação (considerando presença ou não)
    public boolean verificarAprovacao() {
        double notaFinal = calcularNotaFinal();
        
        if (ead) {
            // No formato EAD, só a nota final importa
            return notaFinal >= 5.0;
        } else {
            // Em disciplinas presenciais, nota >= 5 e presença >= 75%
            return notaFinal >= 5.0 && presenca >= 75.0;
        }
    }

    // Método para imprimir a situação do aluno
    public void imprimirSituacao() {
        double notaFinal = calcularNotaFinal();
        String situacao = verificarAprovacao() ? "Aprovado" : "Reprovado";

        System.out.println("Nome: " + nome);
        System.out.println("RA: " + ra);
        System.out.println("Nota Final: " + notaFinal);
        System.out.println("Situação: " + situacao);
    }

}