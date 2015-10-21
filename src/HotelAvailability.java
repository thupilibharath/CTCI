/**
 *--------  DOCUMENTATION -------
 *
 *ALGORITHM:
 *   To check whether the required booking range is available in a particular
 *   hotel, we check for the overlapping of the range with the existing bookings
 *   in that particular hotel. If this number is greater than or equal to the
 *   rooms available in that hotel, it is not available. Else it is available.
 *
 * A data structure daterange is used which contaiins start, end dates in the
 * given range and a function that checks whether this range overlaps with other
 * range or not is a part of this class.
 *
 * In the main class HotelAvailability, two utility functions that parse two
 * input files and return the data as HashMaps are used. These functions ignore
 * the first line of csv files as they describe contents. Please make sure
 * that there is a space after each comma in the csv
 *
 * Finally in the function getHotels(), All the hotels which have no bookings
 * at all and the ones with availability are found and printed on to the console.
 *
 * USAGE:
 *   sample : java HotelAvailability --hotels metropolis_hotels.csv
 * --bookings metropolis_bookings.csv --checkin 2015-08-01 --checkout 2015-08-05
 *
 * order of parameters such as --hotels, --bookings can be changed.
 * For eg. following usage is also valid
 * java HotelAvailability --bookings metropolis_bookings.csv --hotels
 * metropolis_hotels.csv --checkin 2015-08-01 --checkout 2015-08-05
 *
 * However the two input files must also be in the same directory from which the
 * tool is being invoked and dates should be in yyyy-mm-dd format
 *
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

/**
 * Data Structure for storing date ranges.
 */
class DateRange {
    /**
     * Start Date.
     */
    private Date start;
    /**
     * End Date.
     */
    private Date end;

    /**
     * Function for checking whether two date ranges overlap or not.
     * @param dr - Date range with which the current range is being compared
     * @return Return true if overlap is positive else false
     */
    public boolean overlaps(final DateRange dr) {
        return ((this.end.after(dr.start) || (this.end.compareTo(dr.start) == 0)) && ((dr.end.after(this.start))
                || (dr.end.compareTo(this.start) == 0)));
    }

    /**
     * Constructor for initializing date range.
     * @param s start date
     * @param e end date
     */
    DateRange(final Date s, final Date e) {
        this.start = s;
        this.end = e;
    }

}

/**
 * Class for parsing input and producing required output.
 */
public class HotelAvailability {

    /**
     * Function for parsing the Hotels file and returning data in a
     * HashMap.
     * @param name name of file containing hotel info
     * @return data in the form of <HotelName, Rooms> HashMap
     */
    final HashMap<String, Integer> getHotels(final String name) {
    BufferedReader br = null;
    HashMap<String, Integer> hotels = new HashMap<String, Integer>();

        try {
            String currentLine;
            String filePath = new File("").getAbsolutePath();
            //System.out.println(filePath);
            br = new BufferedReader(new FileReader(filePath + "/" + name));
            currentLine = br.readLine();
            while ((currentLine = br.readLine()) != null) {
                String[] data = currentLine.split(", ");
                hotels.put(data[0], Integer.parseInt(data[1]));
            }
         return hotels;
        } catch (IOException e) {
            System.out.println("Error occured while reading Hotels file" + e);
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                System.out.println("Error occured while closing Hotels file");
            }
        }
        return hotels;
    }

    /**
     * Function to read Bookings file and return bookings data of hotels
     * in a HashMap.
     * @param name name of file containing Bookings data
     * @return data in file as <HotelName, ListofBookings> HashMap
     */
    final HashMap<String, ArrayList<DateRange>> getBookings(final String name) {
        BufferedReader br = null;
        HashMap<String, ArrayList<DateRange>> bookings = new HashMap<String, ArrayList<DateRange>>();

        try {
            String currentLine;
            String filePath = new File("").getAbsolutePath();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            //System.out.println(filePath);
            br = new BufferedReader(new FileReader(filePath + "/" + name));
            currentLine = br.readLine();
            while ((currentLine = br.readLine()) != null) {
              //  System.out.println(currentLine);
                String[] data = currentLine.split(", ");

                Date date = new Date();
                Date date1 = new Date();
                date = df.parse(data[1]);
                date1 = df.parse(data[2]);
                DateRange dr = new DateRange(date, date1);
                if (!bookings.containsKey(data[0])) {
                    ArrayList<DateRange> hbookings = new ArrayList<DateRange>();
                    hbookings.add(dr);
                    bookings.put(data[0], hbookings);
                } else {
                    ArrayList<DateRange> hbookings = new ArrayList<DateRange>(bookings.get(data[0]));
                    hbookings.add(dr);
                    bookings.put(data[0], hbookings);
                }

            }
            //System.out.println("*******BOOKINGS******");
            //System.out.println(Bookings);
            return bookings;
        } catch (Exception e) {
            System.out.println("Error occured while reading Bookings file" + e);
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                System.out.println("Error occured while closing Bookings file");
            }
        }
        return bookings;
    }

    /**
     * Function to calculate overlaps of required checkin, checkout range with
     * current bookings of each hotel.
     * @param l List of current bookings for each hotel
     * @param dr required checkin-checkout date range
     * @return no.of overlappings with current bookings
     */
    final int numOverlaps(final ArrayList<DateRange> l, final DateRange dr) {
        int count = 0;
        int n = l.size();

        for (int i = 0; i < n; i++) {
            if (l.get(i).overlaps(dr))
                count++;
        }
        return count;
    }

    /**
     * Function to finally check availability in each hotel and print that
     * hotel if a room is available for required range.
     * @param hotelFile name of file with Hotels data
     * @param bookingsFile name of file with bookings data
     * @param checkin check in date
     * @param checkout check out data
     */
    final void getHotels(final String hotelFile, final String bookingsFile,
                         final String checkin, final String checkout) {
        HashMap<String, Integer> hotels = getHotels(hotelFile);
        HashMap<String, ArrayList<DateRange>> bookings = getBookings(bookingsFile);
        Set<String> bookingKeys = bookings.keySet();
        int n = hotels.size();
        Date date = new Date();
        Date date1 = new Date();
        try {
            // Display Hotels with no bookings
            for (String key : hotels.keySet()) {
                if (!bookings.containsKey(key)) {
                    System.out.println(key);
                }
            }

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.parse(checkin);
            date1 = df.parse(checkout);
            DateRange dr = new DateRange(date, date1);
            for (String key:bookingKeys) {
                //Check whether there are any available rooms in the hotel
                if (!(numOverlaps(bookings.get(key), dr) >= hotels.get(key))) {
                    System.out.println(key);
                }

            }



        } catch (Exception e) {
            System.out.println("Error occured while processing information.. Please try again");
        }


    }

    /**
     * Function for parsing input and producing output
     * @param args Command line arguments received
     */
    final void checkInputAndProcess(final String[] args) {
        int n = args.length;
        String d1 = null; String d2 = null;
        String hotelFile = null; String bookingFile = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        BufferedReader br = null;
        String filePath = new File("").getAbsolutePath();
        Date test = new Date();
        if (n < 8) {
            System.out.println("Please check the number of arguments passed " + "and try again");
            System.out.println("Please refer to the documentation for information on how to use the tool");
        } else {
            try {
                for (int i = 0; i < n; i++) {
                    //System.out.println(args[i]);
                    if (args[i].compareTo("--hotels") == 0) {
                        hotelFile = args[i + 1];
                        br = new BufferedReader(new FileReader(filePath + "/" + hotelFile));
                    } else if (args[i].compareTo("--bookings") == 0) {
                        bookingFile = args[i + 1];
                        br = new BufferedReader(new FileReader(filePath + "/" + hotelFile));
                    } else if (args[i].compareTo("--checkin") == 0) {
                        d1 = args[i + 1];
                        test = df.parse(d1);
                    } else if (args[i].compareTo("--checkout") == 0) {
                        d2 = args[i + 1];
                        test = df.parse(d2);
                    }
                }

                getHotels(hotelFile, bookingFile, d1, d2);

            } catch (ParseException e) {
                System.out.println("Please enter Date parateters in yyyy-mm-dd format");
            } catch (Exception e) {
                System.out.println("One or both of the files specified are not available or accessible");
                System.out.println("Please place them in the same directory as the tool and try again");

            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ex) {
                    System.out.println("Error occured while closing the file");
                }
            }
        }
    }


    /**
     * Driver function.
     * @param args Command Line arguments
     */
    public static void main(final String[] args) {

        HotelAvailability availableHotels = new HotelAvailability();
        availableHotels.checkInputAndProcess(args);
    }
}
