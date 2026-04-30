package kudadiri.DataEngineer.portofolio;

public class RunBoy {
    public static void main(String[] args) {
        System.out.println("=====Hasil Pembacaan Header Dataset====="  );
        System.out.println("{Unnamed_0: 0,Flow_ID: 1, Source_IP: 2, ..., Label: 87}");
        System.out.println();
        System.out.println("=====Contoh Hasil Pembacaan Baris pertama Data=====");
        System.out.println("nilai-0,nilai-1,nilai2,...,nilai-87");
        System.out.println();
        System.out.println("==== Hasil Split Data (Dalam Bentuk Array) ====");
        System.out.println("[nilai-0, nilai-1, nilai-2, ..., nilai-87]");
//        System.out.println("==== Hasil Mapping Avro sesudah di finalisasi ====");
//        System.out.println("Avro Objek 1 = {\"Unnamed_0\": nilai-a1, \"Flow_ID\": \"nilai-a2\", \"Source_IP\": \"nilai-a3\", ..., \"Label\": \"nilai-a87\"}");
//        System.out.println("Avro Objek 2 = {\"Unnamed_0\": nilai-b1, \"Flow_ID\": \"nilai-b2\", \"Source_IP\": \"nilai-b3\", ..., \"Label\": \"nilai-b87\"}");
//        System.out.println("Avro Objek 3 = {\"Unnamed_0\": nilai-c1, \"Flow_ID\": \"nilai-c2\", \"Source_IP\": \"nilai-c3\", ..., \"Label\": \"nilai-c87\"}");
//        System.out.println();
//        System.out.println("==== Hasil Akhir Proses ====");
//        System.out.println("[Avro Objek 1, Avro Objek 2, Avro Objek 3, ..., Avro Objek n]");
//        System.out.println();
//        System.out.println("==== Hasil Penambahan Metadata dari data Avro ====");
//        System.out.println("ProducerRecord(topic=topic-network, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=null, value={\"Unnamed_0\": nilai-a1, \"Flow_ID\": \"nilai-a2\", \"Source_IP\": \"nilai-a3\", ..., \"Label\": \"nilai-a87\"}, timestamp=null)");
//        System.out.println("==== Serialisasi ProducerRecord ==== ");
//        System.out.println("[-2, -1, 0, 1, 2, 3, ..., n]");
//        System.out.println("==== Struktur Log ==== ");
//        System.out.println("<Waktu Log dibuat> [<Id Producer>] <Pesan Log>");
//        System.out.println();
//        System.out.println("==== Contoh Log Pesan yang tercatat ==== ");
//        System.out.println("2026-04-24 00:00:00 [Producer 1] Data Sent with Flow ID: nilai flow id, dataForwardedTime:2026-04-24 10:42:12.295, dataReceiveTime:2026-04-24 10:42:13.815, brokerTimeStamp:1777027333815, latency=1520");

    }
}