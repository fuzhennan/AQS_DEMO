package src.practise.Value;

public class TestDataSort {
    public static void main(String[] args){
        Date[] days=new Date[5];
        days[0]=new Date(2006,5,4);
        days[1]=new Date(2006,7,4);
        days[2]=new Date(2008,5,4);
        days[3]=new Date(2004,5,9);
        days[4]=new Date(2004,5,4);

        Date d=new Date(2006,7,4);
        bubbleSort(days);

        for (Date day : days) {
            System.out.println(day);
        }
        System.out.println(binarySearch(days,d));
    }

    public static Date[] bubbleSort(Date[] a){
        int len =a.length;
        for (int i=len-1;i>=1;i--){
            for (int j=0;j<=i-1;j++){
                if (a[j].compare(a[j+1])>0){
                    Date temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a;
    }

    public static int binarySearch(Date[] days,Date d){
        if (days.length==0)return -1;

        int startPos=0;
        int endPos=days.length-1;
        int mid=(startPos+endPos)/2;
        while(startPos<=endPos){
            if (d.compare(days[mid])==0) return mid;
            if (d.compare(days[mid])>0){
                startPos=mid+1;
            }
            if (d.compare(days[mid])<0){
                endPos=mid+1;
            }
            mid=(startPos+endPos)/2;
        }
        return -1;
    }
}

class Date{
    private int year,month,day;

    Date(int y,int m,int d){
        year=y;
        month=m;
        day=d;
    }
    public int compare(Date date){
        return Integer.compare(day, date.day);
    }

    public String toString() {
        return "Year:Month:Day--"+year+"-"+month+"-"+day;
    }
}
