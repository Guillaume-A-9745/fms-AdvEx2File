import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TpResto {
	public static final String [] STARTER = 	{"entrée", "salade","soupe","quiche","aucune"};
	public static final String [] DISHES = 		{"plats" , "poulet" , "boeuf" , "poisson" , "végétarien" , "vegan","aucun"};
	public static final String [] SIDE_DISH = 	{"accompagnements" , "riz" , "pates" , "frites" , "légumes","aucun"};
	public static final String [] DRINKS = 		{"boissons" , "eau plate" , "eau gazeuze" , "soda" , "vin","aucune"};
	public static final String [] DESSERTS = 	{"desserts" , "tarte maison" , "mousse au chocolat" , "tiramisu","aucun"};

	public static void main(String[] args) {
		
		File customerOrder = new File("C://Users/AnselmeG/Documents/Exercices/AdvEx3File/menu.txt");									
		if(!customerOrder.exists()) {				//vérification que le ficjier existe
			try {
				customerOrder.createNewFile(); 		// creation du fichier si il n'exite pas
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("bonjour, combien de menus souhaitez vous ?");
		Scanner scan = new Scanner(System.in);
		int nbMenu;
		while(scan.hasNextInt() == false)	scan.next();
		nbMenu = scan.nextInt();
		ArrayList<String>  order = new ArrayList<String>();

		try {
			FileWriter writer = new FileWriter(customerOrder);
			BufferedWriter bw = new BufferedWriter(writer);
			for(int i = 0 ; i < nbMenu ; i ++) {
				System.out.println("Commande numéro " + (i+1));
				int result = getInfos(scan,STARTER[0]);
				if(STARTER.length-1 > result)	order.add(STARTER[result]);

				result = getInfos(scan,DISHES[0]);
				if(DISHES.length-1 > result)	order.add(DISHES[result]);	

				result = getInfos(scan,SIDE_DISH[0]);
				if(SIDE_DISH.length-1 > result)	order.add(SIDE_DISH[result]);	

				result = getInfos(scan,DRINKS[0]);
				if(DRINKS.length-1 > result)	order.add(DRINKS[result]);

				result = getInfos(scan,DESSERTS[0]);
				if(DESSERTS.length-1 > result)	order.add(DESSERTS[result]);	

				System.out.println("Résumé de la commande "+(i+1));
				System.out.println(order);		//ici on pourrait stocker la commande en base par exemple
				System.out.println();			//avant de passer à la suivante	
				bw.write("************ Résumé de la commande N°"+ (i+1) + " ***********");
				bw.newLine();
				for(String choice : order) {
					bw.write(choice);
					bw.newLine();
				}
				bw.newLine();
				order.clear();
			}
			
			bw.close();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		scan.close();
	}
	public static int getInfos(Scanner scan, String info) {
		System.out.println("choix " + info + " : ");
		if(info.equalsIgnoreCase(STARTER[0]))	displayTable(STARTER);
		else if(info.equalsIgnoreCase(DISHES[0]))	displayTable(DISHES);
		else if(info.equalsIgnoreCase(SIDE_DISH[0]))	displayTable(SIDE_DISH);
		else if(info.equalsIgnoreCase(DRINKS[0]))	displayTable(DRINKS);
		else if(info.equalsIgnoreCase(DESSERTS[0]))	displayTable(DESSERTS);		
		System.out.println("que souhaitez vous comme "+ info + " ? [saisir le chiffre correspondant]");
		return scan.nextInt();
	}	
	public static void displayTable(String [] table) {
		for(int i=1;i<table.length;i++) {			
			System.out.print("[" + i + " - " + table[i].toUpperCase() + "]");
		}
		System.out.println();
	}

}
