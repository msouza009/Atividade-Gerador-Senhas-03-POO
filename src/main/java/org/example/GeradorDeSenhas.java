package org.example;

import java.security.SecureRandom;

public class GeradorDeSenhas {

    // Conjuntos de caracteres
    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETRAS_MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

    // Gerador de números aleatórios seguro
    private final SecureRandom random = new SecureRandom();

    // Método para gerar a senha
    public String gerarSenha(int tamanho, boolean incluirMinusculas, boolean incluirMaiusculas, boolean incluirNumeros, boolean incluirSimbolos) {
        // Verifica se pelo menos um tipo de caractere foi selecionado
        if (!incluirMinusculas && !incluirMaiusculas && !incluirNumeros && !incluirSimbolos) {
            throw new IllegalArgumentException("Pelo menos uma categoria de caracteres deve ser selecionada.");
        }

        // Constrói o conjunto de caracteres com base nas opções selecionadas
        StringBuilder conjuntoCaracteres = new StringBuilder();
        if (incluirMinusculas) {
            conjuntoCaracteres.append(LETRAS_MINUSCULAS);
        }
        if (incluirMaiusculas) {
            conjuntoCaracteres.append(LETRAS_MAIUSCULAS);
        }
        if (incluirNumeros) {
            conjuntoCaracteres.append(NUMEROS);
        }
        if (incluirSimbolos) {
            conjuntoCaracteres.append(SIMBOLOS);
        }

        // Gera a senha aleatória
        StringBuilder senha = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            int indexAleatorio = random.nextInt(conjuntoCaracteres.length());
            senha.append(conjuntoCaracteres.charAt(indexAleatorio));
        }

        return senha.toString();
    }

    public static void main(String[] args) {
        GeradorDeSenhas gerador = new GeradorDeSenhas();
        String senha = gerador.gerarSenha(12, true, true, true, true);
        System.out.println("Senha gerada: " + senha);
    }
}
