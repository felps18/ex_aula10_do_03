public class Carro {


    private String cor, marca, modelo, placa;
    private float potencia;
    private double velocidadeAtual;
    private double quantidadeCombustivel;
    private double capacidadeTanque;


    public Carro(String cor, String marca, String modelo, String placa, float potencia, double velocidadeAtual, double quantidadeCombustivel, double capacidadeTanque) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.potencia = potencia;
        this.velocidadeAtual = velocidadeAtual;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.capacidadeTanque = capacidadeTanque;
    }

    public Carro(String cor, String modelo, String placa) {
        this.cor = cor;
        this.modelo = modelo;
        this.placa = placa;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }

    public void setQuantidadeCombustivel(double quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void acelerar(){
        velocidadeAtual +=  potencia/100;
        quantidadeCombustivel -= potencia/200;
    }
    public void abastecer(double qtde){
        quantidadeCombustivel += qtde;
    }
    public void frear(double qtde){
        velocidadeAtual = velocidadeAtual/qtde;
    }
    public void frear(){
        velocidadeAtual = velocidadeAtual/10;
    }


    @Override          //copiado do alceu pq eu nao faco ideia do pq precisa disso *perguntar pro professor*
    public String toString(){
        String s = "Cor: "+cor+" Marca: "+marca+" Modelo: "+modelo;
        return s;
    }

}