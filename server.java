try{
//creiamo un server in ascolto sulla porta 2222
ServerSocket server= new ServerSocket(2222);
//entriamo nel ciclo infinito
while(true){
//controlliamo se ci sono nuove connessioni da parte di un client
//il metodo accept della classe ServerSocket resta in attesa finchè non c'è una connessione, e appena c'è una connessione ritorna la Socket che si è connessa
Socket sock= server.accept();
//ora che abbiamo la socket sulla quale operare la affidiamo a ClientConnection un thread che abbiamo creato noi.
ClientConnection client= new ClientConnection(sock);
//facciamo partire il thread
client.start();
//teniamo traccia della nuova connessione del client aggiungendolo ad una arraylist di ClientConnection, variabile di istanza della classe Server.
this.connessioni.add(client);
}
} catch (IOException ex) {
}
