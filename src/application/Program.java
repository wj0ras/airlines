package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entitys.AirlinesLine;

public class Program {

	public static void main(String[] args) {
		
		List<AirlinesLine> list = new ArrayList<>();
		String path = "C:\\temp\\ws-eclipse\\airlines\\airlines-lines.txt";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Scanner sc = new Scanner(System.in);
		
//Instanciando as linhas usando os dados do arquivo airlines-lines.txt
		
		System.out.printf("Voos e horarios:\n\n");
			
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String lineCsv = br.readLine();
			while(lineCsv != null) {
				String[] fields = lineCsv.split(",");
				list.add(new AirlinesLine(fields[0], fields[1], LocalDateTime.parse(fields[2], formatter)));
				
				lineCsv = br.readLine();			}
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
//lendo os voos a partir da minha lista de linhas
		for(AirlinesLine line : list ) {
			System.out.println(line);
		}
		
		System.out.printf("\nPara selecionar o voo que deseja digite o local de origem e logo apos local de destino:\n");
		String local = sc.nextLine();
		String destiny = sc.nextLine();
		int select = 0;
		
		for(int i = 0; i < list.size(); i++) {
			AirlinesLine obj = list.get(i);
			
			if(obj.getCurrentLocation().equals(local) && obj.getDestination().equals(destiny)) {
				select = i;
				
			}
		}
	
		System.out.println("Digite o seu nome: ");
		String name = sc.nextLine();
		
		System.out.printf("\nReserva do voo: " + list.get(select).toString() + "\nNome do passageiro: " + name);
		
		sc.close();
	}
	
	
		
}
