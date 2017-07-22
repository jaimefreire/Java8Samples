package snippets.streams;

import snippets.streams.clients.Client;

import java.util.stream.Stream;

public class MapToDouble {

    public static void main(String[] args) {

        new MapToDouble().call();
    }

    void call() {
        Stream<Client> clients = Stream.of(new Client("Will", "vps server", 200),
                new Client("Rachel", "java program", 1200), new Client("Anthony", "Configuration", 1000));

       // DoubleFunction func = Client.getBudget();
       // DoubleStream prices = clients.mapToDouble(func);
       // prices.forEachOrdered(d -> System.out.print(d + " "));
    }



}