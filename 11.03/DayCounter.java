public class DayCounter {

    public static void main(String[] args) {

        int yearIn = 2015;
        String [] months = new String [] {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String [] allDays = new String [365];
        
        int count = 0;
        for(int i=0; i<months.length; i++)
        {
        	int days = countDays(i+1, yearIn);
        	for(int j=1; j<=days & count<365; j++, count ++)
        	{
        		allDays[count] = months[i] + " " + j; 
        	}
        }
                
        for (int i=0; i<allDays.length; i++)
        {
        	System.out.println(allDays[i]);
        }
        
    }

    static int countDays(int month, int year) {
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }
                if ((year % 100 == 0) & (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;
    }
}