package br.edu.iff.pooa20181.trabalho012_2018_1.model;

public class Servente extends Funcionario{

    public Servente(int nHoras, int nfaltas, int nFilhos){
        super(nHoras,nfaltas,nFilhos);
        this.setSalarioBase(300);
    }
}
