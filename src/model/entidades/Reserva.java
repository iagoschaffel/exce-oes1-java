package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.ExcecaoDominio;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut)  {
		
		if(!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("A data de checkOut deve ser depois da data de checkIn.");
		}
		
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut)  {
		
		Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				throw new ExcecaoDominio("As datas de reserva devem ser futuras as atuais."); // excessao usada quando os argumentos passados para um  m�todo s�o inv�lidos
		}
			if(!checkOut.after(checkIn)) {
				throw new ExcecaoDominio("A data de checkOut deve ser depois da data de checkIn.");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", dura��o: "
				+ duracao()
				+ " noites.";
	}

}
