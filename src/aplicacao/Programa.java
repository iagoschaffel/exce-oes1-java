package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Numero do quarto: ");
		int numeroQuarto = teclado.nextInt();
		System.out.println("Informe a data de checkIn(dd/MM/yyyy): ");
		Date checkIn = sdf.parse(teclado.next());
		System.out.println("Informe a data de checkOut(dd/MM/yyyy): ");
		Date checkOut = sdf.parse(teclado.next());
		
		if(!checkOut.after(checkIn)) { //verificar se a data é anterior a outra
			System.out.println("Erro na reserva. A data de checkOut deve ser depois da data de checkIn.");
		}
		else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			
			System.out.println("Informe uma data para atualizar sua reserva: ");
			System.out.println("Informe a data de checkIn(dd/MM/yyyy): ");
			checkIn = sdf.parse(teclado.next());
			System.out.println("Informe a data de checkOut(dd/MM/yyyy): ");
			checkOut = sdf.parse(teclado.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: as datas de reserva devem ser futuras as atuais.");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva. A data de checkOut deve ser depois da data de checkIn.");
			}
			else {
			
			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
	}
		
		teclado.close();
	}

}

