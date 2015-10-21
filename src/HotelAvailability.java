/**
 * Created by Bharath on 10/20/15.
 */

/**
 --------  DOCUMENTATION -------

 ALGORITHM:
    To check whether the required booking range is available in a particular hotel,
    we check for the overlapping of the range with the existing bookings in that
    particular hotel. If this number is greater than or equal to the rooms available
    in that hotel, it is not available. Else it is available.

 A data structure daterange is used which contaiins start, end dates in the given
 range and a function that checks whether this range overlaps with other range or
 not is a part of this class.

 In the main class HotelAvailability, two utility functions that parse two input files
 and return the data as HashMaps are used.

 Finally in the function getHotels(), All the hotels which have no bookings at all and the
 ones with availability are found and printed on to the console.

 USAGE:
    sample : java HotelAvailability --hotels metropolis_hotels.csv --bookings metropolis_bookings.csv --checkin 2015-08-01 --checkout 2015-08-05
 order of parameters such as --hotels, --bookings can be changed. For eg. following usage is also valid
 java HotelAvailability --bookings metropolis_bookings.csv --hotels metropolis_hotels.csv --checkin 2015-08-01 --checkout 2015-08-05

 However the two input files must also be in the same directory from which the tool is being invoked and dates should be in yyyy-mm-dd format

*/


import java.text.ParseException;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

class DateRange{
    Date start;
    Date end;

    // Function for checking whether two date ranges overlap or not
    public boolean overlaps(DateRange dr){

        return ((this.end.after(dr.start)||(this.end.compareTo(dr.start)==0))&&((dr.end.after(this.start))||(dr.end.compareTo(this.start)==0)));
    }

    public DateRange(Date s, Date e){
        this.start=s;
        this.end=e;
    }

}

public class HotelAvailability {

    // Function for reading Hotels file and return data in a Hash Map
    HashMap<String,Integer> getHotels(String name){
    BufferedReader br = null;
    HashMap<String,Integer> Hotels = new HashMap<String,Integer>();

        try{
            String currentLine;
            String filePath = new File("").getAbsolutePath();
            //System.out.println(filePath);
            br = new BufferedReader(new FileReader(filePath+"/"+name));
            while ((currentLine = br.readLine()) != null) {
                String[] data = currentLine.split(", ");
                Hotels.put(data[0], Integer.parseInt(data[1]));
            }
         return Hotels;
        }

        catch(IOException e){
            System.out.println("Error occured while reading Hotels file"+e);
        }

        finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return Hotels;
        }
    }

    // Function to read Bookings file and return bookings data of hotels in a HashMap
    HashMap<String,ArrayList<DateRange>> getBookings(String name){
        BufferedReader br = null;
        HashMap<String,ArrayList<DateRange>> Bookings = new HashMap<String,ArrayList<DateRange>>();

        try{
            String currentLine;
            String filePath = new File("").getAbsolutePath();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            //System.out.println(filePath);
            br = new BufferedReader(new FileReader(filePath+"/"+name));
            while ((currentLine = br.readLine()) != null) {
              //  System.out.println(currentLine);
                String[] data = currentLine.split(", ");

                Date date = new Date();
                Date date1 = new Date();
                date = df.parse(data[1]);
                date1 = df.parse(data[2]);
                DateRange dr = new DateRange(date,date1);
                if(!Bookings.containsKey(data[0])){
                    ArrayList<DateRange> bookings = new ArrayList<DateRange>();
                    bookings.add(dr);
                    Bookings.put(data[0],bookings);
                }
                else{
                    ArrayList<DateRange> bookings = new ArrayList<DateRange>(Bookings.get(data[0]));
                    bookings.add(dr);
                    Bookings.put(data[0],bookings);
                }

            }
            //System.out.println("*******BOOKINGS******");
            //System.out.println(Bookings);
            return Bookings;
        }

        catch(Exception e){
            System.out.println("Error occured while reading Hotels file"+e);
        }

        finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return Bookings;
        }
    }

    // Function to calculate overlaps of required checkin, checkout range with current bookings of each hotel
    public int numOverlaps(ArrayList<DateRange> l, DateRange dr){
        int count = 0;
        int n = l.size();

        for(int i=0;i<n;i++){
            if(l.get(i).overlaps(dr))
                count++;
        }
        return count;
    }

    // Function to finally parse through each hotel and print the available ones
    public void getHotels(String hotelFile, String bookingsFile, String checkin, String checkout){
        HashMap<String,Integer> Hotels = getHotels(hotelFile);
        HashMap<String,ArrayList<DateRange>> Bookings = getBookings(bookingsFile);
        Set<String> bookingKeys = Bookings.keySet();
        int n = Hotels.size();
        Date date = new Date();
        Date date1 = new Date();
        try {
            // Display Hotels with no bookings
            for(String key : Hotels.keySet()){
                if(Bookings.containsKey(key)==false)
                    System.out.println(key);
            }

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.parse(checkin);
            date1 = df.parse(checkout);
            DateRange dr = new DateRange(date, date1);
            for(String key:bookingKeys){
                //Check whether there are any available rooms in the hotel
                if((numOverlaps(Bookings.get(key),dr)>=Hotels.get(key)))
                    continue;
                else
                    System.out.println(key);

            }



        }
        catch(Exception e){
            e.printStackTrace();
        }


    }


    public static void main(String[] args){
        int n = args.length;
        String d1=null;String d2=null;
        String hotelFile = null; String bookingFile = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        BufferedReader br = null;
        String filePath = new File("").getAbsolutePath();
        Date test = new Date();
        if(n<8) {
            System.out.println("Please check the number of arguments passed and try again");
            System.out.println("Please refer to the documentation for information on how to use the tool");
        }
        else {
            try {
                for (int i=0;i<n;i++) {
                    //System.out.println(args[i]);
                    if(args[i].compareTo("--hotels")==0) {
                        hotelFile = args[i + 1];
                        br = new BufferedReader(new FileReader(filePath+"/"+hotelFile));
                    }
                    else if(args[i].compareTo("--bookings")==0) {
                        bookingFile = args[i + 1];
                        br = new BufferedReader(new FileReader(filePath+"/"+hotelFile));
                    }
                    else if(args[i].compareTo("--checkin")==0) {
                        d1 = args[i + 1];
                        test = df.parse(d1);
                    }
                    else if(args[i].compareTo("--checkout")==0) {
                        d2 = args[i + 1];
                        test = df.parse(d2);
                    }
                }

                HotelAvailability availableHotels = new HotelAvailability();
                availableHotels.getHotels(hotelFile,bookingFile,d1,d2);

            }
            catch(ParseException e){
                System.out.println("Please enter Date parateters in yyyy-mm-dd format");
            }
            catch(Exception e){
                System.out.println("One or both of the files specified are not available or accessible");
                System.out.println("Please place them in the same directory as the tool and try again");

            }
            finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}
