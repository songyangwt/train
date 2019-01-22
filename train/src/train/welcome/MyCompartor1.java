package train.welcome;

import java.util.Comparator;

import train.trainmanage.pojo.TManage;

public class MyCompartor1 implements Comparator{

	//@Override
  
    public int compare(Object o1, Object o2)
    {

 		WelcomeBean sdto1= (WelcomeBean)o1;
 		WelcomeBean sdto2= (WelcomeBean)o2;

         return sdto1.getDate().compareTo(sdto2.getDate());
    }
}
