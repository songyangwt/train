package train.welcome;

import java.util.Comparator;

import train.trainmanage.pojo.TManage;

public class MyCompartor implements Comparator{

	//@Override
    public int compare(Object o1, Object o2)
   {

		TManage sdto1= (TManage)o1;
		TManage sdto2= (TManage)o2;

        return sdto1.getDate().compareTo(sdto2.getDate());
   }
    public int compare1(Object o1, Object o2)
    {

 		WelcomeBean sdto1= (WelcomeBean)o1;
 		WelcomeBean sdto2= (WelcomeBean)o2;

         return sdto1.getDate().compareTo(sdto2.getDate());
    }
}
