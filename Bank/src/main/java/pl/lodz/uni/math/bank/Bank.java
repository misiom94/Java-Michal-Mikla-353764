package pl.lodz.uni.math.bank;

import java.util.ArrayList;

public class Bank {
	
	private final String name;
	private ArrayList<Client> clientsList;
	
	public Bank(String name){
		this.name = name;
		clientsList = new ArrayList<Client>();
	}
	
	public void addClient(Client client){
		if(!checkIfClientInBank(client)){
			clientsList.add(client);
		}
	}
	
	public void removeClient(Client client){
		clientsList.remove(client);
	}
	
	public boolean checkIfClientInBank(Client client){
		for (Client clientInBankList : clientsList) {
			if(clientInBankList.equals(client)){
				return true;
			}
		}
		return false;
	}

	public ArrayList<Client> getClientsList() {
		return clientsList;
	}

	public void setClientsList(ArrayList<Client> clientsList) {
		this.clientsList = clientsList;
	}

	public String getName() {
		return name;
	}
	
	
}
