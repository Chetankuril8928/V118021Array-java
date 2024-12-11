import java.util.Scanner;

class Room {
    int roomNumber;
    boolean isBooked;
    String guestName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    public void bookRoom(String guestName) {
        if (!isBooked) {
            this.guestName = guestName;
            this.isBooked = true;
            System.out.println("Room " + roomNumber + " booked successfully for " + guestName);
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    public void releaseRoom() {
        if (isBooked) {
            System.out.println("Room " + roomNumber + " released from " + guestName);
            this.isBooked = false;
            this.guestName = null;
        } else {
            System.out.println("Room " + roomNumber + " is not currently booked.");
        }
    }
}

class Hotel {
    Room[] rooms;

    public Hotel(int numRooms) {
        rooms = new Room[numRooms];
        for (int i = 0; i < numRooms; i++) {
            rooms[i] = new Room(i + 1);
        }
    }

    public void displayStatus() {
        for (Room room : rooms) {
            System.out.println("Room " + room.roomNumber + " is " + (room.isBooked ? "booked by " + room.guestName : "available"));
        }
    }

    public void bookRoom(int roomNumber, String guestName) {
        if (roomNumber > 0 && roomNumber <= rooms.length) {
            rooms[roomNumber - 1].bookRoom(guestName);
        } else {
            System.out.println("Invalid room number.");
        }
    }

    public void releaseRoom(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= rooms.length) {
            rooms[roomNumber - 1].releaseRoom();
        } else {
            System.out.println("Invalid room number.");
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rooms in the hotel: ");
        int numRooms = scanner.nextInt();

        Hotel hotel = new Hotel(numRooms);

        while (true) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Display Room Status");
            System.out.println("2. Book Room");
            System.out.println("3. Release Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayStatus();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumberToBook = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    hotel.bookRoom(roomNumberToBook, guestName);
                    break;
                case 3:
                    System.out.print("Enter room number to release: ");
                    int roomNumberToRelease = scanner.nextInt();
                    hotel.releaseRoom(roomNumberToRelease);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
