package org.example

import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)
    val biblioteca = mutableListOf<Livro>()
    var opcao: Int

    addDados(biblioteca)

    do {

        println("\n--------------------------------------")
        println("Escolha uma opção")
        println("--------------------------------------")
        println("| 1 - Cadastrar")
        println("| 2 - Listar")
        println("| 3 - Pesquisar")
        println("| 4 - Alterar")
        println("| 5 - Remover")
        println("| 0 - Sair")
        println("--------------------------------------")

        opcao = scanner.nextInt()

        when (opcao) {

            1 -> addLivro(scanner, biblioteca)

            2 -> listar(biblioteca)

            3 -> pesquisar(scanner, biblioteca)

            4 -> atualizar(scanner, biblioteca)

            5 -> remover(scanner, biblioteca)

            0 -> println("Saindo...")

            else -> println("Opção inválida")
        }

    } while (opcao != 0)

}

fun addLivro(scanner: Scanner, biblioteca: MutableList<Livro>) {

    println("Digite o nome do livro:")

    scanner.nextLine()
    val nome = scanner.nextLine()

    if (nome.isBlank()) {
        println("Nome do livro não pode ser vazio!")
        return
    }

    val existe = biblioteca.any { it.nome.equals(nome, true) }

    if (existe) {
        println("Esse livro já está cadastrado.")
        return
    }

    biblioteca.add(Livro(nome))

    println("Livro cadastrado com sucesso!")
}

fun listar(biblioteca: MutableList<Livro>) {

    println("\nLista de livros:")

    if (biblioteca.isEmpty()) {
        println("Nenhum livro cadastrado.")
        return
    }

    for ((index, livro) in biblioteca.withIndex()) {
        println("${index + 1} - ${livro.nome}")
    }

}

fun pesquisar(scanner: Scanner, biblioteca: MutableList<Livro>) {

    println("Digite o nome do livro:")

    scanner.nextLine()
    val nome = scanner.nextLine()

    val resultado: Livro? = biblioteca.find { it.nome.equals(nome, true) }

    println(resultado?.nome ?: "Livro não encontrado")

}

fun atualizar(scanner: Scanner, biblioteca: MutableList<Livro>) {

    if (biblioteca.isEmpty()) {
        println("Não há livros para alterar.")
        return
    }

    listar(biblioteca)

    println("Digite o número do livro que deseja alterar:")

    val indice = scanner.nextInt() - 1

    if (indice < 0 || indice >= biblioteca.size) {
        println("Índice inválido")
        return
    }

    scanner.nextLine()

    println("Digite o novo nome do livro:")

    val novoNome = scanner.nextLine()

    if (novoNome.isBlank()) {
        println("Nome não pode ser vazio!")
        return
    }

    biblioteca[indice].nome = novoNome

    println("Livro atualizado!")

}

fun remover(scanner: Scanner, biblioteca: MutableList<Livro>) {

    if (biblioteca.isEmpty()) {
        println("Não há livros para remover.")
        return
    }

    listar(biblioteca)

    println("Digite o número do livro que deseja remover:")

    val indice = scanner.nextInt() - 1

    if (indice < 0 || indice >= biblioteca.size) {
        println("Índice inválido")
        return
    }

    biblioteca.removeAt(indice)

    println("Livro removido com sucesso!")

}

fun addDados(biblioteca: MutableList<Livro>) {

    biblioteca.add(Livro("João e Maria"))
    biblioteca.add(Livro("Dom Casmurro"))
    biblioteca.add(Livro("Harry Potter"))
    biblioteca.add(Livro("O Senhor dos Anéis"))
    biblioteca.add(Livro("1984"))

}