package practise.Value;

public class Task1 {
    public static void main(String[] args){
        int data[] = { 33, 27, 7, 3, 9, 2, 5, 11, 23, 1, 16, 29, 8, 0 };
        int tmp;
        for (int i = 0; i < data.length; i++)
        {
            System.out.println(data[i]);
        }

        for (int i = 0; i < data.length - 1; i++)
        {
            for (int j = i + 1; j < data.length; j++)
            {
                if (data[i] > data[j])
                {
                    tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }

        }

        for (int i = 0; i < data.length; i++)
        {
            System.out.println(data[i]);
        }
    }
}
