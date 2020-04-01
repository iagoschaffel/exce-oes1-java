package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.ExcecaoDominio;

public class Programa {

	public static void main(String[] args)  {
		
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Numero do quarto: ");
			int numeroQuarto = teclado.nextInt();
			System.out.println("Informe a data de checkIn(dd/MM/yyyy): ");
			Date checkIn = sdf.parse(teclado.next());
			System.out.println("Informe a data de checkOut(dd/MM/yyyy): ");
			Date checkOut = sdf.parse(teclado.next());
			
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			
			System.out.println("Informe uma data para atualizar sua reserva: ");
			System.out.println("Informe a data de checkIn(dd/MM/yyyy): ");
			checkIn = sdf.parse(teclado.next());
			System.out.println("Informe a data de checkOut(dd/MM/yyyy): ");
			checkOut = sdf.parse(teclado.next());
			
			reserva.atualizarDatas(checkIn, checkOut);
			
			System.out.println("Reserva: " + reserva);
	
		}
		catch(ParseException e) {
			System.out.println("Data inválida");
		}
		catch(ExcecaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		teclado.close();
	}

}

