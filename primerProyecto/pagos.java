package primerProyecto;

public class pagos {
	public int tarifaHora;
	public int horas;

	public pagos(int tarifaHora, int horas) {
		this.tarifaHora = tarifaHora;
		this.horas = horas;
	}

	public static int calcularTotalPagar(int tarifaHora, int horas) {
		int totalPago = 0;
		totalPago = (horas * tarifaHora);
		return totalPago;
	}
}