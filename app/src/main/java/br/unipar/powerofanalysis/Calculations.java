package br.unipar.powerofanalysis;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class Calculations {
    String ativo;
    Double LPA;
    Double PL;
    Double ROE;
    Double VPA;
    Double PV;


    private static DecimalFormat df2 = new DecimalFormat("#.##");

    private static Double CalcularLPA(Double lucroLiquido, Long numeroAcoes){
        return lucroLiquido / numeroAcoes;
    }
    private static Double CalcularPL(Double precoAtual, Double LPA){
        return precoAtual / LPA;
    }
    private static Double CalcularROE(Double lucroLiquido, Double patrimonioLiquido){
        return (lucroLiquido / patrimonioLiquido) / 100;
    }
    private static Double CalcularVPA(Double patrimonioLiquido, Long numeroAcoes){
        return patrimonioLiquido / numeroAcoes;
    }
    private static Double CalcularPV(Double precoAcao, Double VPA){
        return precoAcao / VPA;
    }

    Calculations(String ativo, Double lucroLiquido, Double patrimonioLiquido, Long numeroAcoes, Double precoAcao){
        this.ativo = ativo;
        this.LPA = CalcularLPA(lucroLiquido, numeroAcoes);
        this.PL = CalcularPL(precoAcao, LPA);
        this.ROE = CalcularROE(lucroLiquido, patrimonioLiquido);
        this.VPA = CalcularVPA(patrimonioLiquido, numeroAcoes);
        this.PV = CalcularPV(precoAcao, VPA);
    }


    public String getAtivo() {
        return ativo;
    }

    String getLPA() {
        return df2.format(LPA).replace('.', ',');
    }

    String getPL() {
        return df2.format(PL).replace('.', ',');
    }

    public String getROE() {
        return df2.format(ROE).replace('.', ',');
    }

    public String getVPA() {
        return df2.format(VPA).replace('.', ',');
    }

    public String getPV() {
        return df2.format(PV).replace('.', ',');
    }
}
