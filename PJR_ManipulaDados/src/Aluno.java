
class Aluno {

    String pnome;
    String unome;
    Integer pontos;

    //construtor
    Aluno() {
        this("", "", 0);
    }

    Aluno(String pnomealuno, String unomealuno, Integer pontosaluno) {
        pnome = pnomealuno;
        unome = unomealuno;
        pontos = pontosaluno;
    }
}
