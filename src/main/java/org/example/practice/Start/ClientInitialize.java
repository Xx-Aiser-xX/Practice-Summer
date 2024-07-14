//package org.example.practice.Start;
//
//import org.example.practice.Service.ClientService;
//import org.example.practice.Table.Client;
//
//import java.util.Arrays;
//
//public class ClientInitialize {
//    private final ClientService clientservice;
//
//    public ClientInitialize(ClientService clientservice) {
//        this.clientservice = clientservice;
//    }
//
//    public void run(String... args) throws Exception {
//        // Добавляем билеты в базу данных через сервис
//        clientservice.saveAllClient(Arrays.asList(
//                new Client(1,1),
//                new Client(1, 2),
//                new Client(2, 3)
//        ));
//    }
//}
