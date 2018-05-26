package br.edu.iff.pooa20181.trabalho012_2018_1.model;

public class Funcionario implements Empregado {

    protected float salarioBase;
    protected float salarioLiquido;
    protected float proventos;
    protected float descontos;
    protected int nHoras;
    protected int nFaltas;
    protected int nFilhos;

    public Funcionario(int nHoras, int nFaltas, int nFilhos){
        this.nHoras = nHoras;
        this.nFaltas = nFaltas;
        this.nFilhos = nFilhos;
    }

    protected void setSalarioBase(float salarioBase){ this.salarioBase = salarioBase;}

    public float getSalarioBase() {
        return salarioBase;
    }

    public float getSalarioLiquido() {
        return salarioLiquido;
    }

    public float getProventos() {
        return proventos;
    }

    public float getDescontos() {
        return descontos;
    }


    @Override
    public void calcular() {
        this.calcularProventos();
        this.calcularDescontos();
        this.calcularSalarioLiquido();
    }


    protected void calcularProventos() {
        float provHoras =  this.nHoras * ((this.salarioBase / 240) * 2);
        float provFilhos = (float) (this.nFilhos * (this.salarioBase * 0.03));
        this.proventos = (this.salarioBase + provHoras + provFilhos);
    }


    protected void calcularDescontos() {
        float descFaltas = this.nFaltas * (this.salarioBase / 30);
        float inss = (float) (this.proventos * 0.1);
        this.descontos = (descFaltas + inss);
    }


    protected void calcularSalarioLiquido() {
        this.salarioLiquido = (this.proventos - this.descontos);
    }
}
