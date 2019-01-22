package train.process.action;

import train.userinfo.pojo.UserInfo;

public class GetProcessByPosition {

	public int getPxsqProcess(UserInfo ui,int chu)
	{
		
		int process = 0;
		
		String authoV = ui.getAuthority().substring(21, 22);
		String authoU = ui.getAuthority().substring(20, 21);
		if(authoV.equals("V")&&chu!=11&&chu!=12&&chu!=13&&chu!=14&&chu!=15)//
		{
			process = 1;
		}
		else if(authoV.equals("V")&&(chu==11||chu==12||chu==13||chu==14||chu==15))
		{
			process = 2;
		}
		else if((!authoV.equals("V")&&!authoU.equals("U"))&&chu!=11&&chu!=12&&chu!=13&&chu!=14&&chu!=15)
		{
			process = 3;
		}
		else if((!authoV.equals("V")&&!authoU.equals("U"))&&(chu==11||chu==12||chu==13||chu==14||chu==15))
		{
			process = 4;
		}
		else if (authoU.equals("U"))
		{
			process = 5;
		}
			
	
		return process;
	}

}
