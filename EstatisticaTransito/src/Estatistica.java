
class Estatistica {

    Integer CodCidade;
    String NomeCidade;
    Integer QTDAcidentes;
    Integer TipoVeiculo;

    Estatistica() {
        this(0, "", 0, 0);
    }

    Estatistica(Integer CodCidadeEstatistica, String NomeCidadeEstatistica, Integer QTDAcidentesEstatistica, Integer TipoVeiculoEstatistica) {
        CodCidade = CodCidadeEstatistica;
        NomeCidade = NomeCidadeEstatistica;
        QTDAcidentes = QTDAcidentesEstatistica;
        TipoVeiculo = TipoVeiculoEstatistica;
    }
}
