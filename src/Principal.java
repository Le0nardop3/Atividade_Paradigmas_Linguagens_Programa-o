void main(){
    Pessoa p1 = new PessoaFisica("A", 2000, Situacao.ATIVADO, "321245", "32654554545");
    Pessoa p2 = new PessoaJuridica("A", 2000, Situacao.ATIVADO, "212212154545");

    Conta conta1 = new Conta("123", "321", p1);
    Conta conta2 = new Conta("987", "654", p2);

    conta1.depositar(6000);
    conta1.sacar(2500);
    conta1.depositar(200);

    conta2.depositar(50000);
    conta2.sacar(3000);
    conta2.transferir(10000, conta1);

    conta1.imprimir();
    conta2.imprimir();
}
