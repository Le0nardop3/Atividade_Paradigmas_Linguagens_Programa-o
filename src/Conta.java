import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conta implements IExtrato {
    private String numero;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private Situacao situacao;
    private String senha;
    private double saldo;
    private Pessoa pessoa;
    private List<Movimento> movimentacoes = new ArrayList<>();

    public Conta(String numero, String senha, Pessoa pessoa){
        this.numero = numero;
        this.senha = senha;
        this.pessoa = pessoa;
        this.dataAbertura = LocalDateTime.now();
        this.dataAbertura = null;
        this.situacao = Situacao.ATIVADO;
        this.saldo = 0;
    }

    public void sacar(double valor){
        if(valor > this.saldo){
            IO.println("Saldo insuficiente!");
            return;
        }
        this.saldo -= valor;
        this.movimentacoes.add(new Movimento(TipoMovimento.SACAR, LocalDateTime.now(), valor));
    }

    public void depositar(double valor){
        this.saldo += valor;
        this.movimentacoes.add(new Movimento(TipoMovimento.DEPOSITAR, LocalDateTime.now(), valor));
    }

    public void transferir(double valor, Conta conta){
        if(valor > this.saldo){
            IO.println("Saldo insuficiente!");
            return;
        }
        this.saldo -= valor;
        conta.depositar(valor);
        this.movimentacoes.add(new Movimento(TipoMovimento.TRANSFERIR, LocalDateTime.now(), valor));
    }

    @Override
    public void imprimir() {
        IO.println("-------Extrato Conta: " +numero+ "-------" );
        movimentacoes.forEach((movimento)->{
            IO.println("Tipo Movimento: " + movimento.getTipoMovimento());
            IO.println("Data Hora: " + movimento.getDataHoraMovimento());
            IO.println("Valor: " + movimento.getValor());
            IO.println("--------------------------------------");
        });

    }
}
