// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val nome: String)

data class ConteudoEducacional(
    val nome: String, 
    val duracao: Int = 60,
    val nivel: Nivel
)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuario ${usuario.nome} matriculado no sistema")
        println("Total de usuarios no sistema: ${inscritos.size}" )
    }

    fun matricular(usuarios: List<Usuario>) {
        inscritos+=usuarios
        println("Total de usuarios no sistema: ${inscritos.size}")
    }

    fun listarConteudos(){
        var conteudoCurso = String()
        conteudos.forEach{
            conteudoCurso+= "${it.nome} "
        }
        println("Os conteudos da Formação em ${nome} são: ${conteudoCurso}")
    }

    fun detalharConteudo(nomeConteudo: String){
        val detalhesConteudo = conteudos.filter{it.nome == nomeConteudo}.first()

        println("Detalhes sobre o conteudo:")
        println("Nome: ${detalhesConteudo.nome}")
        println("Duração: ${detalhesConteudo.duracao}")
        println("Nivel: ${detalhesConteudo.nivel}")
    }

    fun detalhes(){
        listarConteudos()
        
        val duracaoCurso = conteudos.sumOf{it.duracao}
        println("Carga horária total: ${duracaoCurso}")
        
        conteudos.forEach{
            detalharConteudo(it.nome)
        }
    }

}

fun main() {

    val listaConteudos = mutableListOf<ConteudoEducacional>(
        ConteudoEducacional(
            nome = "Kotlin",
            duracao = 180,
            nivel = Nivel.INTERMEDIARIO
        ),

        ConteudoEducacional(
            nome = "Swift",
            duracao = 260,
            nivel = Nivel.DIFICIL
        ),

        ConteudoEducacional(
            nome = "Flutter",
            duracao = 80,
            nivel = Nivel.BASICO
        )
    )

    val formacao = Formacao("Mobile", listaConteudos)

    val usuario1 = Usuario(nome = "Lorraine")
    val usuario2 = Usuario(nome = "Danilo")

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    val usuarios = listOf(
        Usuario(nome = "Ana"),
        Usuario(nome = "Hugo")
    )

    formacao.matricular(usuarios)
    formacao.detalhes()
}
