class Abstrata {

    Integer NumeroSecao;
    Integer NumeroCandidato;

    Abstrata() {
        this(0, 0);
    }

    Abstrata(Integer NumeroSecaoAbstrata, Integer NumeroCandidatoAbstrata) {
        NumeroSecao = NumeroSecaoAbstrata;
        NumeroCandidato = NumeroCandidatoAbstrata;
    }
}
