/*
package org.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionFilterSystem {

    */
/*
        Implement the filterTransactions method which
        returns a stream the includes only completed transactions
     *//*

    public Stream<MainTransaction> filterTransactions(Stream<MainTransaction> mainStream,
                                                      Stream<StatusTransaction> statusStream) {

       Stream<MainTransaction> s = mainStream
                .filter( steam -> statusStream
                        .filter(status -> status.status.orElse("")
                                .equalsIgnoreCase("COMPLETED")&& status.id == steam.id )
                        .count() ==1) ;
        List<MainTransaction> filteredTransactions = s.collect(Collectors.toList());
        filteredTransactions.stream().forEach(System.out::println);

       // s.forEach(System.out::println);

        // Implementation goes here

        return Stream.empty(); // For happy compiler
    }

    */
/*
        id -> unique id of a transaction
     *//*


    static class MainTransaction {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    */
/*
        id ->  unique id of a transaction
        status -> can have value "COMPLETED", "IN_PROGRESS" or no value
     *//*

    static class StatusTransaction {
        private Integer id;
        private Optional<String> status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    public static void main(String args[])
    {
        MainTransaction m1 = new MainTransaction();
        m1.id = 4;
        MainTransaction m2 = new MainTransaction();
        m2.id = 1;
        MainTransaction m3 = new MainTransaction();
        m3.id = 2;
        MainTransaction m4 = new MainTransaction();
        m4.id = 6;
        MainTransaction m5 = new MainTransaction();
        m5.id = 5;

        StatusTransaction s1 = new StatusTransaction();
        s1.id = 3;
        s1.status=Optional.of("COMPLETED");
        StatusTransaction s2 = new StatusTransaction();
        s2.id = 1;
        s2.status=Optional.of("IN_PROGRESS");
        StatusTransaction s3 = new StatusTransaction();
        s3.id = 6;
        s3.status=Optional.of("COMPLETED");
        StatusTransaction s4 = new StatusTransaction();
        s4.id = 4;
        s4.status=Optional.of("<No Value>");
        StatusTransaction s5 = new StatusTransaction();
        s5.id = 8;
        s5.status=Optional.of("COMPLETED");

        MainTransaction[] myArray = {m1,m2,m3,m4,m5};
        Stream<MainTransaction> mainstream = Stream.of(myArray);

        StatusTransaction[] statusArray = {s1,s2,s3,s4,s5};
        Stream<StatusTransaction> statusStream = Stream.of(statusArray);
        new TransactionFilterSystem().filterTransactions(mainstream,statusStream);
    }
}
*/



package org.interview;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionFilterSystem
{
    public static void main(String[] args)
    {
        TransactionFilterSystem ts = new TransactionFilterSystem();
        ts.filterTransactions(Stream.of(new MainTransaction(4),
                        new MainTransaction(3),
                                        new MainTransaction(1),
                                        new MainTransaction(2),
                                        new MainTransaction(6),
                                        new MainTransaction(5)),

                Stream.of(new StatusTransaction(3, Optional.of("COMPLETED")),
                        new StatusTransaction(1, Optional.of("IN_PROGRESS")),
                        new StatusTransaction(6, Optional.of("COMPLETED")),
                        new StatusTransaction(4, Optional.of("<No Value>")),
                        new StatusTransaction(8, Optional.of("COMPLETED"))));

    }

    /*        Implement the filterTransactions method which        returns a stream the includes only completed transactions     */

    public Stream<MainTransaction> filterTransactions(Stream<MainTransaction> mainStream,Stream<StatusTransaction> statusStream)
    {
       /* List<StatusTransaction> statusList = statusStream.collect(Collectors.toList());
        //statusList.stream();
        Supplier<Stream<StatusTransaction>> supplier = ()->statusList.stream();
        List<MainTransaction> s = mainStream.filter( steam -> supplier.get().filter(status -> status.status.orElse("")
                                                                            .equalsIgnoreCase("COMPLETED")&& status.id == steam.id )
                                                                            .count() ==1).collect(Collectors.toList());*/
       // s.forEach(System.out::println);
        List<Integer> comparingIDs = statusStream.filter(statusItem->statusItem.status.orElse(null).equals("COMPLETED"))
                                                .map(statusItem->statusItem.id).collect(Collectors.toList());
        comparingIDs.forEach(System.out::println);
        mainStream.filter(obj->comparingIDs.contains(obj.id)).forEach(System.out::println);
        return Stream.empty(); // For happy compiler
         }    /*        id -> unique id of a transaction     */

         static class MainTransaction {
             MainTransaction(int id){            this.id = id;        }
             private Integer id;

             @Override
             public String toString() {
                 return "MainTransaction{" +
                         "id=" + id +
                         '}';
             }
         }    /*        id ->  unique id of a transaction        status -> can have value "COMPLETED", "IN_PROGRESS" or no value     */
    static class StatusTransaction {
        private Integer id;
        private Optional<String> status;
        StatusTransaction(int id, Optional<String> status)
        {            this.id = id;            this.status = status;        }
    }


}
