import java.time.LocalDateTime;

public class Movimento {
    private TipoMovimento tipoMovimento;
    //2026-09-02T20:25:0111.212112
    private LocalDateTime dataHoraMovimento;
    private double valor;

    public Movimento() {
    }

    public Movimento(TipoMovimento tipoMovimento, LocalDateTime dataHoraMovimento, double valor) {
        this.tipoMovimento = tipoMovimento;
        this.dataHoraMovimento = dataHoraMovimento;
        this.valor = valor;
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimento tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public LocalDateTime getDataHoraMovimento() {
        return dataHoraMovimento;
    }

    public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
        this.dataHoraMovimento = dataHoraMovimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
